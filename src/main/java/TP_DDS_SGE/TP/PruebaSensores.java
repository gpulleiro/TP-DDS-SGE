package TP_DDS_SGE.TP;

import java.io.IOException;
import java.util.ArrayList;

public class PruebaSensores {

	public static void main(String[] args) throws IOException {
		
		Repositorio.importarLog("log.txt");
		
		
		Dispositivo luz = new Dispositivo("luz",20,new Inteligente("encendido"));
		Dispositivo luz1 = new Dispositivo("luz1",20,new Inteligente("encendido"));
		Dispositivo luz2 = new Dispositivo("luz2",20,new Inteligente("encendido"));
		
		
		
//		try {
//			luz.encender();
//			luz.ahorro();
//			luz.apagar();
//			luz.apagar();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		SensorDeMovimiento sensorLuces = new SensorDeMovimiento();
		ReglaDeMovimiento sinMovimientoApagar = new ReglaDeMovimiento();
		ActuadorApagar apagar = new ActuadorApagar();
		
		sensorLuces.agregarDispositivo(luz);
		sensorLuces.agregarDispositivo(luz1);
		sinMovimientoApagar.agregarSensor(sensorLuces); 
		sinMovimientoApagar.setActuador(apagar);
		
		sensorLuces.realizarMedicion();
		
		System.out.println(luz.getEstado()+" "+luz1.getEstado()+" "+luz2.getEstado());
	}
}
