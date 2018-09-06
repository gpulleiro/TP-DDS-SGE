package Helpers;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import Repositorio.Repositorio;
import TipoDato.Coordenadas;
import Usuarios.Cliente;
import ZonaGeografica.Transformador;
import ZonaGeografica.Zona;

public class FuncionesHelper {

	public static double calcularDistancia(Coordenadas coordCliente, Coordenadas coordTrafo) {
		// TODO Auto-generated method stub
		double diffLatitud = coordCliente.getLatitud() - coordTrafo.getLatitud();
		double diffLongitud = coordCliente.getLongitud() - coordTrafo.getLongitud();
		return Math.sqrt(Math.pow( diffLatitud, 2)  + Math.pow( diffLongitud,2));
	}
	
	public static Coordenadas obtenerCoordenadas(String domicilio) throws ApiException, InterruptedException, IOException {
		
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
	
	public static void asignarTransformador(Cliente cliente) {
		
		double cliLat = cliente.getCoordenadas().getLatitud();
		double cliLong = cliente.getCoordenadas().getLongitud();
		Transformador transformador = new Transformador();
		double distanciaMinima = 0;
		
		Repositorio repo = Repositorio.getInstance();
		
		ArrayList<Zona> zonas = repo.getZonas();
		
		for(Zona zona: zonas){
			
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

 
}
