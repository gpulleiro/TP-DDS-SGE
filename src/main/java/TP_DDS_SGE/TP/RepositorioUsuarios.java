package TP_DDS_SGE.TP;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RepositorioUsuarios {
	
	private static List<Cliente> clientes;
	
	public static void inicializarRepositorio() throws FileNotFoundException{
		
		
		clientes = App.armarLista();
		
		
	}
	
	
	public static boolean existeUsuarioDeNombre(String nombre) {
		return clientes.stream().anyMatch(cliente -> cliente.getNombre().equals(nombre));
	}
	
	/*TODO
	public static Cliente getClienteDeNombre(String nombre) {
		
	
	}
	*/
	
	public static List<Cliente> getClientes(){
		
		return clientes;
	}
	
	public static void setClientes(List<Cliente> clientesNuevos){
		
		clientes = clientesNuevos;
	}
	

}
