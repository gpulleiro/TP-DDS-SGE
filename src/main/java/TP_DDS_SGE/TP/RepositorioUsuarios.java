package TP_DDS_SGE.TP;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RepositorioUsuarios {
	
	private  ArrayList<Cliente> clientes;

	//constructor
	public RepositorioUsuarios(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	//Getter and Setters
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	// metodos
	
	public static void importarJSON (String json) throws FileNotFoundException {
		
		Type tipoListaCliente = new TypeToken<ArrayList<Cliente>>(){}.getType();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(json));
		Gson gson = new Gson();
		ArrayList<Cliente> listaClientes = gson.fromJson(bufferedReader, tipoListaCliente);
		
		//para comprobar que importo correctamente
		Cliente cli;
		Dispositivo dis;
		
		Iterator itercli = listaClientes.iterator();
		
		while(itercli.hasNext()){
			cli = (Cliente)itercli.next();
			
			System.out.println("nombre: " + cli.getNombre() +" -apellido: " + cli.getApellido() +" -domicilio: " + cli.getDomicilio() +" -usuario: " + cli.getUsuario()+ " -contrasenia: " + cli.getContrasenia() + "\n");
			
			Iterator iterdis = cli.getDispositivos().iterator();
			
			while(iterdis.hasNext()){
				dis = (Dispositivo)iterdis.next();
				
				System.out.println("nombre dis: "+dis.getNombre()+ " -consumo dis: "+ dis.getConsumo() + " -estado dis: " + dis.isEstado() + "\n");
				
			}
		}
	}
	
}