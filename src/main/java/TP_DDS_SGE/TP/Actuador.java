package TP_DDS_SGE.TP;

import java.io.IOException;

public class Actuador {

	public void apagar(Dispositivo dis) throws IOException{
		
		dis.apagar();
			
	}
	
	public void encender(Dispositivo dis) throws IOException{
		
		dis.encender();
	}
	
	public void bajarVolumen(Dispositivo dis) throws IOException{
		
		System.out.println("Se baja el volumen");
			
	}
	
	
}
