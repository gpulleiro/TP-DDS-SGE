package TP_DDS_SGE.TP;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
	
	public static void main( String[] args ) throws FileNotFoundException{
		
		RepositorioUsuarios.importarJSON("jsonList.txt");
		
		// prueba generar log
		Cliente pepe = new Cliente();
		
		Dispositivo licuadora = new Dispositivo("licuadora",20,new Estandar(3));
		
		//pepe.convertirDispositivo(licuadora);

		try {
			licuadora.encender();
			licuadora.ahorro();
			licuadora.apagar();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
