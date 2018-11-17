package Repositorio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.maps.errors.ApiException;

import Dispositivo.Dispositivo;
import Dispositivo.Estandar;
import Dispositivo.Inteligente;
import Helpers.FuncionesHelper;
import TipoDato.Coordenadas;
import TipoDato.Log;
import Usuarios.Cliente;
import ZonaGeografica.Transformador;
import ZonaGeografica.Zona;

public class Repositorio {
	
	private String dir = "C:\\TP-DDS-SGE";
//	private String dir = "C:\\Users\\Gaston Adm\\workspace\\TP-DDS-SGE";
//	private String dir = "D:\\Facu\\DDS\\2018\\Entrega-4\\TP-DDS-SGE";
	private ArrayList<Cliente> clientes;
	private ArrayList<Dispositivo> dispositivos;
	private ArrayList<Log> log;
	private ArrayList<Zona> zonas;
	private ArrayList<Transformador> transformadores = new ArrayList<Transformador>();
	private Dispositivo dispositivo;
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

	public ArrayList<Transformador> getTransformadores() {
		return transformadores;
	}


	public void setTransformadores(ArrayList<Transformador> transformadores) {
		this.transformadores = transformadores;
	}


	//importar los archivos 
	public  void importarLog() throws IOException {
		
		String json = this.dir +"\\"+"log.txt";
		
		Type tipoListaLog = new TypeToken<ArrayList<Log>>(){}.getType();
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(json));
		
//		Gson gson = new Gson();
		
		Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                String date = json.getAsString();
                SimpleDateFormat formatter = new SimpleDateFormat("d/M/yy hh:mm:ss");
                formatter.setTimeZone(TimeZone.getTimeZone("GMT-3:00"));
                try {
                    return formatter.parse(date);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return null;
                }
            }
            }).create();

		
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
			cli.setCoordenadas(FuncionesHelper.obtenerCoordenadas(cli.getDomicilio()));
			
			FuncionesHelper.asignarTransformador(cli);
		}
		
	}


	public  void importarDispositivos() throws IOException {
		
		String json = this.dir +"\\"+"dispositivos.txt";
		this.setDispositivos(new ArrayList<Dispositivo>());
		JsonParser parser = new JsonParser();
		JsonArray gsonArr = parser.parse(new FileReader(json)).getAsJsonArray();
		for (JsonElement obj: gsonArr){
			JsonObject unDispo = obj.getAsJsonObject();
			String nombre = unDispo.get("nombre").getAsString();
			double consumoFijo = unDispo.get("consumoFijo").getAsFloat();
			int minimoHoras = unDispo.get("minimoHoras").getAsInt();
			int maximoHoras = unDispo.get("maximoHoras").getAsInt();
			String flag = unDispo.get("flag").getAsString();
			Dispositivo unDispositivo = null;
			if (flag.equals("I")){
				 unDispositivo = new Inteligente(nombre, consumoFijo, minimoHoras, maximoHoras,unDispo.get("estado").getAsString());
			}else if(flag.equals("E")){
				unDispositivo = new Estandar(nombre, consumoFijo, minimoHoras, maximoHoras,unDispo.get("cantHoras").getAsInt()); 				
			}
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
		this.setTransformadores(new ArrayList<Transformador>());
		JsonParser parser = new JsonParser();
		JsonArray gsonArr = parser.parse(new FileReader(json)).getAsJsonArray();
		for (JsonElement obj: gsonArr){
			JsonObject unTransf = obj.getAsJsonObject();
//			int id = unTransf.get("id").getAsInt();
			JsonObject coordenadas = unTransf.getAsJsonObject("coordenadas");
			double latitud = coordenadas.get("latitud").getAsDouble();
			double longitud = coordenadas.get("longitud").getAsDouble();
			int zona = unTransf.get("zona").getAsInt();
			Transformador tf = new Transformador(new Coordenadas(latitud, longitud), zona);
		
			this.agregarTransformador(tf);
		}
			
	}
	
	public  void importarTransformadoresNuevos() throws JsonIOException, JsonSyntaxException, FileNotFoundException{
		
		String json = this.dir +"\\"+"transformadoresNuevos.txt";
		this.setTransformadores(new ArrayList<Transformador>());
		JsonParser parser = new JsonParser();
		JsonArray gsonArr = parser.parse(new FileReader(json)).getAsJsonArray();
		for (JsonElement obj: gsonArr){
			JsonObject unTransf = obj.getAsJsonObject();
//			int id = unTransf.get("id").getAsInt();
			JsonObject coordenadas = unTransf.getAsJsonObject("coordenadas");
			double latitud = coordenadas.get("latitud").getAsDouble();
			double longitud = coordenadas.get("longitud").getAsDouble();
			int zona = unTransf.get("zona").getAsInt();
			Transformador tf = new Transformador(new Coordenadas(latitud, longitud), zona);
		
			this.agregarTransformador(tf);
		}
	}
	
	
	
	private  void agregarTransformador(Transformador tf) {

		//recorrer la lista y agregar el transformador segun la zona que corresponda
		for (Zona obj: this.getZonas()){
				
			if(obj.getId() == tf.getZona()){
				
				obj.getTransformadores().add(tf);
				this.getTransformadores().add(tf);
				break;
			}
		}
	}
}