package Sensores;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import Dispositivo.Inteligente;
import Observer.Observer;
import Observer.Sensor;


@Entity
@DiscriminatorValue(value = "TEMPERATURA")
public class SensorDeTemperatura extends Sensor {

	
	
	public SensorDeTemperatura() {
		observadores = new ArrayList<Observer>();
		mediciones = new ArrayList<Medicion>();
	}
		
	@Override
	public void realizarMedicion() throws IOException{
	int numero = (int) (Math.random() * 10) + 1;
	super.setMagnitud(numero); //la magnitud 0 significa que no se esta moviendo
	super.agregarMedicion(numero);
	notificar();
}
}

