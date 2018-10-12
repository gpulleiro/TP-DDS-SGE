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
		dispositivos = new ArrayList<Inteligente>();
	}

	//metodos del patron Observer
		
	//hago que al medir el movimiento devuelva falso
	@Override
	public void realizarMedicion() throws IOException{
	super.setMagnitud(15); //la magnitud 0 significa que no se esta moviendo
	notificar();
}
}

