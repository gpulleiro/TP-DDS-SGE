package Acciones;

import java.io.IOException;

import Dispositivo.Dispositivo;
import Dispositivo.Inteligente;

public class AccionApagar implements Actuador {

	@Override
	public void actuar(Inteligente dispositivo) throws IOException {
		
		dispositivo.apagar();
	
	}
}
