package Acciones;

import java.io.IOException;

import Dispositivo.Inteligente;

public interface Actuador {

	void actuar (Inteligente dispositivo) throws IOException;
	
}
