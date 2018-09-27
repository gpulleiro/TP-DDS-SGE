package Sensores;

import java.io.IOException;
import java.util.ArrayList;

import Dispositivo.Inteligente;
import Observer.Observer;
import Observer.Sensor;

public class SensorDeMovimiento extends Sensor {

	
	
	public SensorDeMovimiento() {
		observadores = new ArrayList<Observer>();
		dispositivos = new ArrayList<Inteligente>();
	}

	//metodos del patron Observer
		
	//hago que al medir el movimiento devuelva falso
	@Override
	public void realizarMedicion() throws IOException{
	super.setMagnitud(0); //la magnitud 0 significa que no se esta moviendo
	notificar();
}
}
