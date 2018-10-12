package Acciones;
import java.io.IOException;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import Dispositivo.Dispositivo;
import Dispositivo.Inteligente;

@Entity
@DiscriminatorValue(value="ENCENDER")
public class AccionEncender extends Actuador{


	
	public AccionEncender() {}
	
	@Override
	public void actuar(Inteligente dispositivo) throws IOException {
		
		dispositivo.encender();
		
	}

}
