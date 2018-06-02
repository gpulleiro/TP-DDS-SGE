package TP_DDS_SGE.TP;

import java.io.IOException;
import java.util.ArrayList;

public class PruebaSensores {

	public static void main(String[] args) throws IOException {
		
		Dispositivo luz = new Dispositivo("luz",20,new Inteligente("encendido"));
		
		SensorDeMovimiento sensorLuces = new SensorDeMovimiento();
		ReglaDeMovimiento sinMovimientoApagar = new ReglaDeMovimiento();
		ActuadorApagar apagar = new ActuadorApagar();
		
		sensorLuces.agregarDispositivo(luz);
		sinMovimientoApagar.agregarSensor(sensorLuces); 
		sinMovimientoApagar.setActuador(apagar);
		
		sensorLuces.realizarMedicion();
		
		//luz.getTipo().imprimirEstado();
	}
}
