package TP_DDS_SGE.TP;
import java.io.IOException;

import TP_DDS_SGE.TP.Actuador;
import TP_DDS_SGE.TP.Dispositivo;

public class AccionEncender implements Actuador{

	@Override
	public void actuar(Dispositivo dispositivo) throws IOException {
		
		dispositivo.encender();
		
	}

}
