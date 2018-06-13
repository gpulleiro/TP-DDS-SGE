package Aplicacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import Dispositivo.Dispositivo;
import Dispositivo.Inteligente;
import Repositorio.Log;
import Repositorio.Repositorio;
import Usuarios.Cliente;

public class Main {
	
	public static void main( String[] args ) throws IOException{
	
			Repositorio.importarLog();
			Repositorio.importarDispositivos();
			Repositorio.importarClientes();
		
		//para comprovar que importo correctamente
//		Dispositivo dis;
//			
//		Iterator<Dispositivo> iterdis = Repositorio.getDispositivos().iterator();
//			
//			while(iterdis.hasNext()){
//				dis = (Dispositivo)iterdis.next();
//				
//				String nombre = dis.getNombre();
//							
//				System.out.println("nombre dis: "+nombre+ "\n");
//				
//			}		
//	
//			System.out.println(Repositorio.getDispositivos().size());
	}
}
