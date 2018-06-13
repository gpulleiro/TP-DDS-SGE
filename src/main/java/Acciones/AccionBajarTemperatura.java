package Acciones;

import java.io.IOException;

import Dispositivo.Dispositivo;

public class AccionBajarTemperatura implements Actuador{

	@Override
	public void actuar(Dispositivo dispositivo) throws IOException {
		
		System.out.println("Se baja la temperatura");
		
	}

}

