package Sensores;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import Dispositivo.Inteligente;
import Observer.Observer;
import Observer.Sensor;

@Entity
@DiscriminatorValue(value= "CONSUMO")
public class SensorDeConsumo extends Sensor {

	
	
	public SensorDeConsumo() {
		observadores = new ArrayList<Observer>();
		mediciones = new ArrayList<Medicion>();
		dispositivos = new ArrayList<Inteligente>();
	}
		
	@Override
	public void realizarMedicion() throws IOException{
	
	double suma = 0;
	
	for(Inteligente dis:this.getDispositivos()) {
	suma = suma + dis.getConsumoActual();//acá habría que poner dis.consumoUltimasHoras(horas)
	}
	
	//la medicion que obtengo es el promedio de los consumos de todos los dispositivos
	double medicion = suma/this.getDispositivos().size();
		
	super.setMagnitud(medicion);
	super.agregarMedicion(medicion);
	notificar();
}
}
