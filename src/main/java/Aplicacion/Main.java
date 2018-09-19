package Aplicacion;

import java.io.IOException;
import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import com.google.maps.errors.ApiException;

import Dispositivo.Dispositivo;
import Dispositivo.Estandar;

//import com.google.maps.GeoApiContext;
//import com.google.maps.GeocodingApi;
//import com.google.maps.errors.ApiException;
//import com.google.maps.model.GeocodingResult;




import Repositorio.Repositorio;
import Simplex.TimerSimplex;
import Usuarios.Cliente;

public class Main {
	
public static void main( String[] args ) throws IOException, InterruptedException, ParseException, ApiException{
		
			Repositorio repositorio = Repositorio.getInstance();
//			repositorio.importarLog();
//			repositorio.importarDispositivos();
//			repositorio.importarZona();
//			repositorio.importarTransformadores();
//			repositorio.importarClientes();			
			
			Dispositivo licuadora = new Dispositivo("licuadora", 2,3,4,new Estandar(3));
			
			EntityManager entityManager =
					PerThreadEntityManagers.getEntityManager();
			
			EntityTransaction transaccion = 
					entityManager.getTransaction();
			
			transaccion.begin();

		//	Robo roboDB = entityManager.find(Robo.class, new Long(1));
			
			//robo.setDenunciante("pepe");
			
			entityManager.persist(licuadora);
			
			transaccion.commit();


	}
}
