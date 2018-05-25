package TP_DDS_SGE.TP;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
	
	public static void main( String[] args ) throws FileNotFoundException{
		
		RepositorioUsuarios.importarJSON("jsonList.txt");
		
		// prueba generar log
		
		Inteligente licuadora = new Inteligente("licuadora",20,'I',"apagado");
		try {
			licuadora.encender();
			licuadora.ahorro();
			licuadora.apagar();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	
//		Estandar lavarropas = new Estandar("lavarropas",'E',30,3);
//		
//		Cliente pepe = new Cliente();
//		
//		pepe.convertirDispositivo(lavarropas);
//		
//		//lavarropas.encender();
//	
	}
}
