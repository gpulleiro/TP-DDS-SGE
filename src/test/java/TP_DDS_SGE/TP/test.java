package TP_DDS_SGE.TP;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class test {
	
	
	private List<Cliente> clientes;
	
 	
	@Before
	public void initApp() throws FileNotFoundException {
		
		RepositorioUsuarios.inicializarRepositorio();
		clientes = RepositorioUsuarios.getClientes();

	}

	
	@Test
	public void cantidadDeClientesEsIgualA2() {
		
		assertEquals(2,clientes.size());
		
	}
	
	@Test
	public void existeUsuarioDeNombreMauricio() {
		
		assertTrue(RepositorioUsuarios.existeUsuarioDeNombre("mauricio"));
		
	}
	
	@Test
	public void noExisteUsuarioDeNombreCarlos() {
		
		assertFalse(RepositorioUsuarios.existeUsuarioDeNombre("carlos"));
		
	}
	
	

}
