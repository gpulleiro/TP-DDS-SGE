package Acciones;

import java.io.IOException;

import Dispositivo.Dispositivo;
import Dispositivo.Inteligente;

public class AccionBajarTemperatura implements Actuador{

	@Override
	public void actuar(Inteligente dispositivo) throws IOException {
		
		System.out.println("Se baja la temperatura");
		
	}

}

