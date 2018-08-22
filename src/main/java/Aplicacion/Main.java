package Aplicacion;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import Repositorio.Repositorio;
import Usuarios.Cliente;

public class Main {
	
	public static void main( String[] args ) throws IOException, ApiException, InterruptedException{
			Repositorio repositorio = Repositorio.getInstance();
			repositorio.importarLog();
			repositorio.importarDispositivos();
			repositorio.importarZona();
			repositorio.importarTransformadores();
			repositorio.importarClientes();
		
			
			System.out.println(repositorio.getClientes());
			System.out.println(repositorio.getZonas());			
			
			
	}
}
