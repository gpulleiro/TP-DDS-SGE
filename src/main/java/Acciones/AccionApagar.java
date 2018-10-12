package Acciones;

import java.io.IOException;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import Dispositivo.Dispositivo;
import Dispositivo.Inteligente;

@Entity
@DiscriminatorValue(value="APAGAR")
public class AccionApagar extends Actuador {


	public AccionApagar() {}
	
	@Override
	public void actuar(Inteligente dispositivo) throws IOException {
		
		dispositivo.apagar();
	
	}
}
