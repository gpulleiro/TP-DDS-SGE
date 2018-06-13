package TestUnitarios;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Dispositivo.Dispositivo;
import Dispositivo.Inteligente;
import Repositorio.Repositorio;
import Usuarios.Categoria;
import Usuarios.Cliente;

public class TestEntrega0 {

	@Test
	public void cantidadDeClientesEsIgualA2() throws IOException {
		
		Repositorio.importarClientes();
		
		assertEquals(2,Repositorio.getClientes().size());
		
	}

	ArrayList<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
	
	Cliente cliente = new Cliente(dispositivos);
	
	@Before
	public void clienteNuevo() {
		Dispositivo dispositivo = new Dispositivo("heladera",80,new Inteligente("encendido"));
		Dispositivo dispositivo2 = new Dispositivo("microondas",70,new Inteligente("apagado"));
		
		cliente.getDispositivos().add(dispositivo);
		cliente.getDispositivos().add(dispositivo2);
		
		
	}
	
	@Test
	public void UnDispositivoEncendido() {
		
		assertEquals(1,cliente.cantDispositivosEncendidos());
	}
	@Test
	public void AlgunUnDispositivoEncendido() {
		
		assertTrue(cliente.algunDispositivoEncendido());
	}
	
	@Test
	public void cantidadDeDispositivosEsIgualA2() {
		
		assertEquals(2, cliente.cantDispositivos());
	}

}
