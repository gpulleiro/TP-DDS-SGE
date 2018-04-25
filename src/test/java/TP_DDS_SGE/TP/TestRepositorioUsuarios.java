package TP_DDS_SGE.TP;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TestRepositorioUsuarios {
	
	private List<Cliente> clientes;
	 	
	@Before
	public void initApp() throws FileNotFoundException {
		
		clientes = RepositorioUsuarios.importarJSON("jsonList.txt");
	
	}

	
	@Test
	public void cantidadDeClientesEsIgualA2() {
		
		assertEquals(2,clientes.size());
		
	}
}