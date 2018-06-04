package TP_DDS_SGE.TP;

import java.io.IOException;
import java.util.ArrayList;

public class SensorDeMovimiento extends Sensor {

	
	
	public SensorDeMovimiento() {
		observadores = new ArrayList<Observer>();
		dispositivos = new ArrayList<Dispositivo>();
	}

	//metodos del patron Observer
	//getters y setters

//	public boolean isMovimiento() {
//		return movimiento;
//	}
//
//	public void setMovimiento(boolean movimiento) {
//		this.movimiento = movimiento;
//	}
	
		
	//hago que al medir el movimiento devuelva falso
	@Override
	public void realizarMedicion() throws IOException{
	super.setMagnitud(0); //la magnitud 0 significa que no se esta moviendo
	notificar();
}
}
