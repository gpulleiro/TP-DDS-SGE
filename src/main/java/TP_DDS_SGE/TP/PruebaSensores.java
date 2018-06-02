package TP_DDS_SGE.TP;

import java.io.IOException;
import java.util.ArrayList;

public class PruebaSensores {

	public static void main(String[] args) throws IOException {
		
		Inteligente luz = new Inteligente("luz",20,"encendido");
		Inteligente luz1 = new Inteligente("luz",20,"encendido");
		Inteligente luz2 = new Inteligente("luz",20,"encendido");
		
		SensorDeMovimiento sensorLuces = new SensorDeMovimiento();
		ReglaDeMovimiento sinMovimientoApagar = new ReglaDeMovimiento();
		ActuadorApagar apagar = new ActuadorApagar();
		
		sensorLuces.agregarDispositivo(luz);
		sensorLuces.agregarDispositivo(luz1);
		sinMovimientoApagar.agregarSensor(sensorLuces); 
		sinMovimientoApagar.setActuador(apagar);
		
		sensorLuces.realizarMedicion();
		
		luz.imprimirEstado();
		luz1.imprimirEstado();
		luz2.imprimirEstado();
	}
}
