package Observer;

import java.io.IOException;
import java.util.ArrayList;

import Dispositivo.Dispositivo;

public abstract class Sensor implements Subject{
	
	protected ArrayList<Observer>observadores;
	protected ArrayList<Dispositivo>dispositivos;
	private double magnitud;
	
	//metodos del patron Observer
	public void agregarObservador(Observer obs) {observadores.add(obs);};
	
	public void notificar() throws IOException {
		for(Observer obs:observadores) {obs.update();}
	}

	public ArrayList<Dispositivo> getDispositivos() {
		return dispositivos;
	}
	

	public ArrayList<Observer> getObservadores() {
		return observadores;
	}

	public void setObservadores(ArrayList<Observer> observadores) {
		this.observadores = observadores;
	}

	public void setDispositivos(ArrayList<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public void setMagnitud(double magnitud) {
		this.magnitud = magnitud;
	}

	public double getMagnitud() {
		return magnitud;
	}

	//agrega un dispositivo a la lista de dispositivos del sensor
	public void agregarDispositivo(Dispositivo dis){dispositivos.add(dis);};
	
	//hago que al medir el movimiento devuelva falso
	public void realizarMedicion() throws IOException{
//	this.setMovimiento(false);
//	notificar();
}

}
