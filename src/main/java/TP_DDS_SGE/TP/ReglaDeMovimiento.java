package TP_DDS_SGE.TP;

import java.io.IOException;
import java.util.ArrayList;

public class ReglaDeMovimiento implements Observer {

	private ArrayList<SensorDeMovimiento>sensores;
	private Actuador actuador;
	private double flag;
	
	public ReglaDeMovimiento(){
		sensores = new ArrayList<SensorDeMovimiento>();
	}
		
	//agrego un sensor a la lista de sensores y agrego a la regla como observador del sensor.
	public void agregarSensor(SensorDeMovimiento sen){
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
		
		//metodo update
	public void update() throws IOException {
	for(SensorDeMovimiento sen:sensores)
		{for(Dispositivo dis:sen.getDispositivos())
			{if(sen.getMagnitud() < 1){this.getActuador().apagar(dis);};
		}
	}
}}
