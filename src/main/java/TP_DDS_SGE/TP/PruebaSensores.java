package TP_DDS_SGE.TP;

import java.io.IOException;
import java.util.ArrayList;

public class PruebaSensores {

	public static void main(String[] args) throws IOException {
		
		Repositorio.importarLog("log.txt");
		
		
		Dispositivo luz = new Dispositivo("luz",20,new Inteligente("encendido"));
		Dispositivo luz1 = new Dispositivo("luz1",20,new Inteligente("encendido"));
		Dispositivo luz2 = new Dispositivo("luz2",20,new Inteligente("encendido"));
		Dispositivo luz3 = new Dispositivo("luz3",20,new Inteligente("apagado"));
		
		
		
//		try {
//			luz3.encender();
//			luz.apagar();
//			luz.apagar();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		SensorDeMovimiento sensorLuces = new SensorDeMovimiento();
		ReglaDeMovimiento sinMovimientoApagar = new ReglaDeMovimiento();
		Actuador apagar = new Actuador();
		
		sensorLuces.agregarDispositivo(luz);
		sensorLuces.agregarDispositivo(luz1);
//		sensorLuces.agregarDispositivo(luz2);
		sensorLuces.agregarDispositivo(luz3);
		
		
		sinMovimientoApagar.agregarSensor(sensorLuces); 
		sinMovimientoApagar.setActuador(apagar);
		
		sensorLuces.realizarMedicion();
		
		System.out.println(luz.getEstado()+" "+luz1.getEstado()+" "+luz2.getEstado()+" "+luz3.getEstado());
	}
}
