package Aplicacion;

import java.io.IOException;
import java.text.ParseException;

import com.google.maps.errors.ApiException;

import Dispositivo.Dispositivo;
import Dispositivo.Estandar;
import Repositorio.Repositorio;

public class Main {
	
	public static void main( String[] args ) throws IOException, ApiException, InterruptedException, ParseException{
			
			Repositorio repositorio = Repositorio.getInstance();
			repositorio.importarLog();
			repositorio.importarDispositivos();
			repositorio.importarZona();
			repositorio.importarTransformadores();
			repositorio.importarClientes();
	
	}
}
