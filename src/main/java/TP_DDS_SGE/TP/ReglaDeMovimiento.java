package TP_DDS_SGE.TP;

import java.io.IOException;
import java.util.ArrayList;

public class ReglaDeMovimiento implements Observer {

	private ArrayList<SensorDeMovimiento>sensores;
	private ActuadorApagar actuador;
	
	public ReglaDeMovimiento(){
		sensores = new ArrayList<SensorDeMovimiento>();
	}
		
	//agrego un sensor a la lista de sensores y agrego a la regla como observador del sensor.
	public void agregarSensor(SensorDeMovimiento sen){
		sensores.add(sen);
		sen.agregarObservador(this);
	}
	
//getters y setters	
	public ActuadorApagar getActuador() {
		return actuador;
	}

	public void setActuador(ActuadorApagar actuador) {
		this.actuador = actuador;
	}
		
		//metodo update
	public void update() throws IOException {
	for(SensorDeMovimiento sen:sensores)
		{for(Inteligente dis:sen.getDispositivos())
			{if(sen.isMovimiento() == false){this.getActuador().actuar(dis);};
		}
	}
}}
