package Aplicacion;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import com.google.maps.errors.ApiException;

import Acciones.AccionApagar;
import Dispositivo.Dispositivo;
import Dispositivo.DispositivoDAO;
import Dispositivo.Estandar;
import Dispositivo.Inteligente;
import Observer.Regla;
import Repositorio.Log;

//import com.google.maps.GeoApiContext;
//import com.google.maps.GeocodingApi;
//import com.google.maps.errors.ApiException;
//import com.google.maps.model.GeocodingResult;




import Repositorio.Repositorio;
import Sensores.SensorDeMovimiento;
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

		Inteligente licuadora = new Inteligente("licuadora",2,3,4,"encendido");
		Inteligente licuadora1 = new Inteligente("licuadora",2,3,4,"encendido");
		
//		Estandar batidora = new Estandar ("batidora",2,3,4,45);

//		AccionEncender actuadorEncender = new AccionEncender();
		AccionApagar actuadorApagar = new AccionApagar();

		SensorDeMovimiento smov = new SensorDeMovimiento();
		smov.agregarDispositivo(licuadora1);
		smov.agregarDispositivo(licuadora);
//		SensorDeTemperatura stem = new SensorDeTemperatura();
		
		Regla regla1 = new Regla("menor", 10, actuadorApagar);
		regla1.agregarSensor(smov);
		
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		EntityTransaction transaccion = entityManager.getTransaction();
		
		transaccion.begin();

		
		entityManager.persist(licuadora);
		entityManager.persist(licuadora1);
		entityManager.persist(smov);
		entityManager.persist(actuadorApagar);
		entityManager.persist(regla1);
		
		transaccion.commit();
		
		//correrlo una vez y despues comentarlo...
		//esto hace la carga inicial de todo lo que esta en el repo a la base y si se corre muchas veces 
		// se duplican los datos
		DispositivoDAO disDAO = new DispositivoDAO();
		
		transaccion.begin();
		
		disDAO.cargaInicial();
		
		transaccion.commit();
		
	}
}
