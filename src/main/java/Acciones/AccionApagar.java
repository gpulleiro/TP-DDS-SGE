package Acciones;

import java.io.IOException;

import Dispositivo.Dispositivo;

public class AccionApagar implements Actuador {

	@Override
	public void actuar(Dispositivo dispositivo) throws IOException {
		
		dispositivo.apagar();
		
	}

}
