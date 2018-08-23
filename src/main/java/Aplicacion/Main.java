package Aplicacion;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import Dispositivo.Dispositivo;
import Dispositivo.Estandar;
import Repositorio.Repositorio;
import Usuarios.Cliente;
import ZonaGeografica.Zona;

public class Main {
	
	public static void main( String[] args ) throws IOException, ApiException, InterruptedException, ParseException{

			Repositorio repositorio = Repositorio.getInstance();
			repositorio.importarLog();
			repositorio.importarDispositivos();
			repositorio.importarZona();
			repositorio.importarTransformadores();
			repositorio.importarClientes();

			String domicilio = "corrientes 1300";
			GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyCK3gGazusuz7AM73gd0kdI3gitoMF_5Yk").build();
			GeocodingResult[] result = GeocodingApi.geocode(context,domicilio).await();
			
			System.out.println(result[0].toString());
			
			
			//System.out.println(repositorio.getDispositivos());
			
//			Cliente pepe = new Cliente();
//			pepe.setDispositivos(repositorio.getDispositivos());
//			
//			pepe.mejorCombinacionDispositivos();
			
//			System.out.println(repositorio.getClientes());
//			System.out.println(repositorio.getZonas());			
//		
//		ArrayList<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
//
//		Cliente roberto = new Cliente(dispositivos);
//
//		Dispositivo aireAcondicionado = new Dispositivo("AA de 3500 frigorias",(float) 1.613 ,90,360,new Estandar(10));
//		Dispositivo lampara = new Dispositivo("lampara halogena de 40w",(float) 0.04,90,360,new Estandar(9));
//		Dispositivo lavarropas = new Dispositivo("lavarropas 5kg",(float) 0.175,6,40,new Estandar(6));
//
//
//		dispositivos.add(aireAcondicionado);
//		dispositivos.add(lampara);
//		dispositivos.add(lavarropas);
//		
//		roberto.setDispositivos(dispositivos);
//		
//		/*roberto.getDispositivos().add(aireAcondicionado);
//		roberto.getDispositivos().add(lampara);
//		roberto.getDispositivos().add(lavarropas);*/
//
//
//		System.out.println(roberto.getDispositivos());
//
//		roberto.mejorCombinacionDispositivos();
	}
}
