package TestUnitarios;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import Repositorio.Repositorio;
import ZonaGeografica.Zona;

public class TestEntrega2 {

//	@Before
//	public void importarRepositorio() throws IOException, ApiException, InterruptedException {
//		
//		Repositorio repositorio = Repositorio.getInstance();
//		repositorio.importarLog();
//		//repositorio.importarDispositivos();
//		repositorio.importarZona();
//		repositorio.importarTransformadores();
//		repositorio.importarClientes();
//	}
//	
//	@Test
//	public void statusOKApiGeolocation() throws ApiException, InterruptedException, IOException{
//		
//		String domicilio = "corrientes 1300";
//		GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyCK3gGazusuz7AM73gd0kdI3gitoMF_5Yk").build();
//		GeocodingResult[] result = GeocodingApi.geocode(context,domicilio).await();
//		
//		assertEquals(1,result.length);
//	}
//	
//	@Test
//	public void cantidadDeZonasEsIgualATres(){
//		
//		Repositorio repo = Repositorio.getInstance();
//		
//		assertEquals(3, repo.getZonas().size());
//		
//	}
//	
//	@Test
//	public void cantidadDeTransformadoresZonaUnoIgualATres(){
//		
//		Repositorio repo = Repositorio.getInstance();
//		
//		for(Zona zona: repo.getZonas()){
//			
//			if (zona.getId() == 1){
//				
//				assertEquals(3, zona.getTransformadores().size());
//			}
//		}
//	}
}

