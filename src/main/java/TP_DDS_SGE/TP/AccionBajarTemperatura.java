package TP_DDS_SGE.TP;

import java.io.IOException;

public class AccionBajarTemperatura implements Actuador{

	@Override
	public void actuar(Dispositivo dispositivo) throws IOException {
		
		System.out.println("Se baja la temperatura");
		
	}

}

