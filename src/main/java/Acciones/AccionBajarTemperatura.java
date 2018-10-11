package Acciones;

import java.io.IOException;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import Dispositivo.Dispositivo;
import Dispositivo.Inteligente;

@Entity
@DiscriminatorValue(value="BAJAR_TEMPERATURA")
public class AccionBajarTemperatura extends Actuador{

	@Override
	public void actuar(Inteligente dispositivo) throws IOException {
		
		System.out.println("Se baja la temperatura");
		
	}

}

