package Repositorio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import Dispositivo.Dispositivo;
import Dispositivo.Estandar;
import Dispositivo.Inteligente;
import Dispositivo.Tipo;
import Helpers.FuncionesHelper;
import TipoDato.Coordenadas;
import Usuarios.Cliente;
import ZonaGeografica.Transformador;
import ZonaGeografica.Zona;

public class Repositorio {
	
	private String dir = "C:\\Users\\Gaston Adm\\Workspace\\TP-DDS-SGE";
	private ArrayList<Cliente> clientes;
	private ArrayList<Dispositivo> dispositivos;
	private ArrayList<Log> log;
	private ArrayList<Zona> zonas;
	private static Repositorio miRepositorio;
	
	//constructor
	private Repositorio(){
		
	}
	
	
	//singleton para no instanciarlo mas de una vez
	public static Repositorio getInstance(){
		 
		 if (miRepositorio == null) {
		 
		 miRepositorio = new Repositorio();
		 
		 }
		 
		 return miRepositorio;
	}
	
	//getters and setters
	public String getDir() {
		return dir;
	}


	public void setDir(String dir) {
		this.dir = dir;
	}


	public ArrayList<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}


	public ArrayList<Dispositivo> getDispositivos() {
		return dispositivos;
	}


	public void setDispositivos(ArrayList<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}


	public ArrayList<Log> getLog() {
		return log;
	}


	public void setLog(ArrayList<Log> log) {
		this.log = log;
	}


	public ArrayList<Zona> getZonas() {
		return zonas;
	}


	public void setZonas(ArrayList<Zona> zonas) {
		this.zonas = zonas;
	}


	//importar los archivos 
	public  void importarLog() throws IOException {
		
		String json = this.dir +"\\"+"log.txt";
		
		Type tipoListaLog = new TypeToken<ArrayList<Log>>(){}.getType();
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(json));
		
		Gson gson = new Gson();
		
		this.setLog(gson.fromJson(bufferedReader, tipoListaLog));
		
	}
	
	
	public  void importarClientes() throws IOException, ApiException, InterruptedException {

		//cargo los clientes
		String json = this.dir +"\\"+"clientes.txt";
		
		Type tipoListaClientes = new TypeToken<ArrayList<Cliente>>(){}.getType();
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(json));
		
		Gson gson = new Gson();
		
		this.setClientes((gson.fromJson(bufferedReader, tipoListaClientes)));
		//
		
		//mapeo de propiedades del gson
		for(Cliente cli: this.clientes){			
			cli.setCoordenadas(this.obtenerCoordenadas(cli.getDomicilio()));
			
			this.asignarTransformador(cli);
		}
		
	}
	

	private Coordenadas obtenerCoordenadas(String domicilio) throws ApiException, InterruptedException, IOException {
		
		GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyCK3gGazusuz7AM73gd0kdI3gitoMF_5Yk").build();
		GeocodingResult[] result = GeocodingApi.geocode(context,domicilio).await();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String latitudString = gson.toJson(result[0].geometry.location.lat);
		String longitudString = gson.toJson(result[0].geometry.location.lng);
		
		double latitud = Double.parseDouble(latitudString);
		double longitud = Double.parseDouble(longitudString);
		
		Coordenadas coordenadas = new Coordenadas(latitud, longitud);
		
		return coordenadas;
	}


	private void asignarTransformador(Cliente cliente) {
		
		double cliLat = cliente.getCoordenadas().getLatitud();
		double cliLong = cliente.getCoordenadas().getLongitud();
		Transformador transformador = new Transformador();
		double distanciaMinima = 0;
		
		for(Zona zona: this.zonas){
			
			for(Transformador tra: zona.getTransformadores() ){
				
				
				double distancia = FuncionesHelper.calcularDistancia(cliente.getCoordenadas(), tra.getCoordenadas());
				
				if (distancia < distanciaMinima || distanciaMinima == 0){
					
					distanciaMinima = distancia;
					transformador = tra;
				}
			}
		}
		
		transformador.getClientes().add(cliente);
		
	}


	public  void importarDispositivos() throws IOException {
		
		String json = this.dir +"\\"+"dispositivos.txt";
		this.setDispositivos(new ArrayList<Dispositivo>());
		JsonParser parser = new JsonParser();
		JsonArray gsonArr = parser.parse(new FileReader(json)).getAsJsonArray();
		for (JsonElement obj: gsonArr){
			JsonObject unDispo = obj.getAsJsonObject();
			String nombre = unDispo.get("nombre").getAsString();
			float consumoFijo = unDispo.get("consumoFijo").getAsFloat();
			Tipo unTipo = null;
			int minimoHoras = unDispo.get("minimoHoras").getAsInt();
			int maximoHoras = unDispo.get("maximoHoras").getAsInt();
			String flag = unDispo.get("flag").getAsString();
			if (flag.equals("I")){
				 unTipo= new Inteligente(unDispo.get("estado").getAsString());	
			}else if(flag.equals("E")){
				 unTipo = new Estandar(unDispo.get("cantHoras").getAsInt()); 				
			}
			Dispositivo unDispositivo = new Dispositivo(nombre, consumoFijo, minimoHoras, maximoHoras, unTipo);
			this.getDispositivos().add(unDispositivo);
		}
	}
	
	public  void importarZona() throws JsonIOException, JsonSyntaxException, FileNotFoundException{
		
		
		String json = this.dir +"\\"+"zonas.txt";
		this.setZonas(new ArrayList<Zona>());
		JsonParser parser = new JsonParser();
		JsonArray gsonArr = parser.parse(new FileReader(json)).getAsJsonArray();
		for (JsonElement obj: gsonArr){
			JsonObject unaZona = obj.getAsJsonObject();
			String nombre = unaZona.get("nombre").getAsString();
			int id = unaZona.get("id").getAsInt();
			JsonObject coordenadas = unaZona.getAsJsonObject("coordenadas");
			double latitud = coordenadas.get("latitud").getAsDouble();
			double longitud = coordenadas.get("longitud").getAsDouble();
			int radio = unaZona.get("radio").getAsInt();
			Zona zona = new Zona(id,nombre,new Coordenadas(latitud,longitud),radio);
			this.getZonas().add(zona);
		
		}
	}
	
	public  void importarTransformadores() throws JsonIOException, JsonSyntaxException, FileNotFoundException{
		
		String json = this.dir +"\\"+"transformadores.txt";
		JsonParser parser = new JsonParser();
		JsonArray gsonArr = parser.parse(new FileReader(json)).getAsJsonArray();
		for (JsonElement obj: gsonArr){
			JsonObject unTransf = obj.getAsJsonObject();
			int id = unTransf.get("id").getAsInt();
			JsonObject coordenadas = unTransf.getAsJsonObject("coordenadas");
			double latitud = coordenadas.get("latitud").getAsDouble();
			double longitud = coordenadas.get("longitud").getAsDouble();
			int zona = unTransf.get("zona").getAsInt();
			Transformador tf = new Transformador(id, new Coordenadas(latitud, longitud), zona);
		
			this.agregarTransformador(tf);
		}
			
		}

	private  void agregarTransformador(Transformador tf) {

		//recorrer la lista y agregar el transformador segun la zona que corresponda
		for (Zona obj: this.getZonas()){
				
			if(obj.getId() == tf.getZona()){
				
				obj.getTransformadores().add(tf);
				break;
			}
		}
	}
}