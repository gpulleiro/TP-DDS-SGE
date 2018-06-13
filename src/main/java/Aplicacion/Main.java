package Aplicacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import Dispositivo.Dispositivo;
import Repositorio.Log;
import Repositorio.Repositorio;
import Usuarios.Cliente;

public class Main {
	
	public static void main( String[] args ) throws FileNotFoundException{
		
		try {
			Repositorio.importarDispositivos();
			Repositorio.importarLog();
			Repositorio.importarClientes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//para comprovar que importo correctamente
		Dispositivo dis;
			
		Iterator iterdis = Repositorio.getDispositivos().iterator();
			
			while(iterdis.hasNext()){
				dis = (Dispositivo)iterdis.next();
				
				System.out.println("nombre dis: "+dis.getNombre()+ " consumo dis: "+ dis.getConsumoFijo() + "\n");
		

			}		
	}
}
