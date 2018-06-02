package TP_DDS_SGE.TP;

import java.io.IOException;

public class ActuadorApagar {

	public void actuar(Dispositivo dis) throws IOException{
		
		dis.getTipo().apagar();
		
	}
	
}
