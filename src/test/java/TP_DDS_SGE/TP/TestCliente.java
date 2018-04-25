package TP_DDS_SGE.TP;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestCliente {

	ArrayList<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
	Categoria categoria = new Categoria("R1",18, 64,140);
	Cliente cliente = new Cliente("juan", "perez", "Cafayate 1234", null , "jp96", "1234","DNI", 38745236, 46014601, categoria, dispositivos);
	
	@Before
	public void clienteNuevo() {
		Dispositivo dispositivo = new Dispositivo("heladera",80,true);
		Dispositivo dispositivo2 = new Dispositivo("microondas",70,false);
		
		
		dispositivos.add(dispositivo);
		dispositivos.add(dispositivo2);
		
		
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
