package Aplicacion;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import com.google.maps.errors.ApiException;

import Dispositivo.Dispositivo;
import Dispositivo.DispositivoDAO;
import Dispositivo.Estandar;
import Dispositivo.Inteligente;
import Repositorio.Log;

//import com.google.maps.GeoApiContext;
//import com.google.maps.GeocodingApi;
//import com.google.maps.errors.ApiException;
//import com.google.maps.model.GeocodingResult;




import Repositorio.Repositorio;
import Simplex.TimerSimplex;
import Usuarios.Administrador;
import Usuarios.Cliente;

public class Main {
	
	public static void main( String[] args ) throws IOException, InterruptedException, ParseException, ApiException{
		
		Repositorio repositorio = Repositorio.getInstance();
		repositorio.importarLog();
		repositorio.importarDispositivos();
//		repositorio.importarZona();
//		repositorio.importarTransformadores();
//		repositorio.importarClientes();		
	
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		EntityTransaction transaccion = entityManager.getTransaction();
		
		
		//correrlo una vez y despues comentarlo...
		//esto hace la carga inicial de todo lo que esta en el repo a la base y si se corre muchas veces 
		// se duplican los datos
		DispositivoDAO disDAO = new DispositivoDAO();
		
		transaccion.begin();
		
		disDAO.cargaInicial();
		
		transaccion.commit();
		
	}
}
