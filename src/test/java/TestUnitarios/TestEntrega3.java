package TestUnitarios;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import Dispositivo.Dispositivo;
import Repositorio.Log;
import TipoDato.Coordenadas;
import TipoDato.CoordenadasDAO;
import Usuarios.Administrador;
import Usuarios.Cliente;
import Usuarios.ClienteDAO;

public class TestEntrega3 {
	
	//Caso de Prueba 1
	@Test
	public void seRealizoElCambioDeGeolocalizacionDeC1AC2() {
		
		//se crea nuevo cliente, y se le setea la nueva coordenada
		Cliente cliente1 = new Cliente("gabi","mamani","beiro","11/10/2018","gabi23","contra123","DNI",22222,111,11);
		Coordenadas c1 = new Coordenadas(10,20);
		cliente1.setCoordenadas(c1);
		
		//se crea instancias de dao de cliente y coordenada
		CoordenadasDAO coodao = new CoordenadasDAO();
		ClienteDAO dao = new ClienteDAO();
		
		//registro en la base de datos
		coodao.registrarCoordenadas(c1);
		dao.registrarCliente(cliente1);
		
		//se recupera de la base un cliente por nombre
		Cliente clienteRecup = dao.recuperarClientePorNombre("gabi");
		
		//se crea nueva coordenada y se le setea la nueva al cliente recuperado de la base
		Coordenadas c2 = new Coordenadas(25,30);
		coodao.registrarCoordenadas(c2);
		clienteRecup.setCoordenadas(c2);
		
		//se actualiza cliente con la nueva coordenada en la base
		dao.actualizarCliente(clienteRecup);
		
		assertEquals(c2, clienteRecup.getCoordenadas());
		
	}
	
	@Test
	public void recuperarDispositivoMostrarLogModificarNombreYGrabarlo(){
		
		Administrador admin = new Administrador();
		
		//obtengo el dispositivo
		Dispositivo dis = admin.obtenerDispositivo("PC de escritorio");
		
		//obtengo la lista de logs encendidos 
		List<Log> listaLog = admin.obtenerLogs("PC de escritorio",10,"encendido");
		
		//le cambio el nombre
		dis.setNombre("Test N2");
		
		//lo persisto
		admin.registrarDispositivo(dis);
		
		//lo obtengo nuevamente
		dis = admin.obtenerDispositivo("Test N2");
		
		assertEquals("Test N2", dis.getNombre());
		
		//muestro la lista de logs por consola
		for(Log log: listaLog){
			
			System.out.println(log.toString());
		}
		
		//para volver la base a su estado original y que el test corra siempre bien
		
//		Administrador admin = new Administrador();
//		Dispositivo dis = admin.obtenerDispositivo("Test N2");
//		dis.setNombre("PC de escritorio");
//		admin.registrarDispositivo(dis);
	}
	
}
