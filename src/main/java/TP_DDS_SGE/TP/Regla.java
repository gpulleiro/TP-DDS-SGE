package TP_DDS_SGE.TP;

import java.io.IOException;
import java.util.ArrayList;

public class Regla implements Observer {

	private ArrayList<Sensor>sensores;
	private Actuador actuador;
	private double flag;
	private String condicion;
	
	//regla(condicion, flag, actuador)
	
	public Regla(String condicion, double flag, Actuador actuador){
		this.flag = flag;
		this.actuador = actuador;
		this.condicion = condicion;
		sensores = new ArrayList<Sensor>();
	}
		
	//agrego un sensor a la lista de sensores y agrego a la regla como observador del sensor.
	public void agregarSensor(Sensor sen){
		sensores.add(sen);
		sen.agregarObservador(this);
	}
	
//getters y setters	
	public Actuador getActuador() {
		return actuador;
	}

	public void setActuador(Actuador actuador) {
		this.actuador = actuador;
	}
		
		public ArrayList<Sensor> getSensores() {
		return sensores;
	}

	public void setSensores(ArrayList<Sensor> sensores) {
		this.sensores = sensores;
	}

	public double getFlag() {
		return flag;
	}

	public void setFlag(double flag) {
		this.flag = flag;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	
	//metodo que implementa la condicion del IF. Se podría hacer con un switch creo
	public boolean condicionD(Sensor sen){
	if (this.getCondicion() == "menor"){
	return sen.getMagnitud() < this.getFlag();
	}
	else if (this.getCondicion() == "igual"){
	return sen.getMagnitud() == this.getFlag();
	}
	else if (this.getCondicion() == "mayor") {}
	return sen.getMagnitud() > this.getFlag();
	}
	
	
	//metodo update
	public void update() throws IOException {
	for (Sensor sen:sensores)
	{if(condicionD(sen))
	{for(Dispositivo dis:sen.getDispositivos())
	{this.getActuador().actuar(dis);}}}
}
	
}

