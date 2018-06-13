package Acciones;

import java.io.IOException;

import Dispositivo.Dispositivo;

public interface Actuador {

	void actuar (Dispositivo dispositivo) throws IOException;
	
}
