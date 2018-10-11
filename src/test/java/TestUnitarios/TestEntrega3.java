package TestUnitarios;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import Dispositivo.Dispositivo;
import Repositorio.Log;
import Usuarios.Administrador;

public class TestEntrega3 {

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
