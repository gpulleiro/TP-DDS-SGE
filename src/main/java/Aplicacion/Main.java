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
import Usuarios.ClienteDAO;
import ZonaGeografica.Transformador;

public class Main {
	
	public static void main( String[] args ) throws IOException, InterruptedException, ParseException, ApiException{
		
		Repositorio repositorio = Repositorio.getInstance();
		repositorio.importarLog();
		repositorio.importarDispositivos();
		repositorio.importarZona();
		repositorio.importarTransformadores();
		repositorio.importarClientes();		

//		Inteligente licuadora = new Inteligente("licuadora",2,3,4,"encendido");
//		Inteligente licuadora1 = new Inteligente("licuadora",2,3,4,"encendido");
		
//		Estandar batidora = new Estandar ("batidora",2,3,4,45);

//		AccionEncender actuadorEncender = new AccionEncender();
//		AccionApagar actuadorApagar = new AccionApagar();

//		SensorDeMovimiento smov = new SensorDeMovimiento();
//		smov.agregarDispositivo(licuadora1);
//		smov.agregarDispositivo(licuadora);
//		SensorDeTemperatura stem = new SensorDeTemperatura();
		
//		Regla regla1 = new Regla("menor", 10, actuadorApagar);
//		regla1.agregarSensor(smov);
////		
//		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
//		EntityTransaction transaccion = entityManager.getTransaction();
//		
//		transaccion.begin();
//
//		
//		entityManager.persist(licuadora);
//		entityManager.persist(licuadora1);
//		entityManager.persist(smov);
//		entityManager.persist(actuadorApagar);
//		entityManager.persist(regla1);
//		
//		transaccion.commit();
		
		//correrlo una vez y despues comentarlo...
		//esto hace la carga inicial de todo lo que esta en el repo a la base y si se corre muchas veces 
		// se duplican los datos
//		DispositivoDAO disDAO = new DispositivoDAO();
//		
//		transaccion.begin();
//		
//		disDAO.cargaInicial();
//		
//		transaccion.commit();
		
//	  Cliente cli = repositorio.getClientes().get(0);
//	  
//	  System.out.println(cli.getNombre());
//		
	
		Repositorio repo = Repositorio.getInstance();
		
		ClienteDAO cliDAO = new ClienteDAO();
		
		Dispositivo dis1 = repo.getDispositivos().get(21);
		
		Cliente cli1 = repo.getClientes().get(1);
		
		cli1.aniadirDispositivo(dis1);
		
		cliDAO.registrarCliente(cli1);
		
		//muestro el consumo total de un hogar
		double consumoTotal = cli1.consumo("06/10/2018 02:30:00");
		
		System.out.println("consumo hogar: "+consumoTotal);
		
		//muestro el consumo total por dispositivo
		Dispositivo dis = repo.getDispositivos().get(21);
		
		double consumoDis = dis.consumoPeriodo("06/10/2018 02:30:00", "06/10/2018 17:00:00"); 
		
		System.out.println("consumo dispositivo: "+consumoDis);
		
		//muestro el consumo del transformador 
		
		Transformador trafo = repo.getTransformadores().get(0);
		
		double consumoTrafo = trafo.consumo("01/10/2018 10:00:00");
		
		System.out.println("consumo transformador: "+consumoTrafo);
		

	}
	
}
