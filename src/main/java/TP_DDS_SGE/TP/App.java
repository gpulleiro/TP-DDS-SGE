package TP_DDS_SGE.TP;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class App {
	
	public static void main( String[] args ) throws FileNotFoundException{
		
		//pruebas importamos el repositorio 
		try {
			//Repositorio.importarDispositivos("dispositivos.txt");
			//Repositorio.importarClientes("clientes.txt");
			Repositorio.importarLog("log.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		// prueba cabiar dispositivo de estandar a inteligente y probamos que hace luego de la conversion
		Cliente pepe = new Cliente();
		
		Dispositivo licuadora = new Dispositivo("licuadora",20,new Estandar(3));
	//	Dispositivo licuadora = new Dispositivo("licuadora",20,new Inteligente("encendido"));
		
		pepe.convertirDispositivo(licuadora);

//		try {
//			licuadora.encender();
//			licuadora.ahorro();
//			licuadora.apagar();
//			licuadora.apagar();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
		
		//probamos las funciones de obtener el consumo
		
		
//		double consumo = licuadora.consumoUltimasHoras(8);
		double consumo = licuadora.consumoPeriodo("06/06/2018 02:30:00","06/06/2018 11:00:00");
		
		System.out.println("el consumo fue: " + consumo +" Kw/H");
		
		//para comprobar que importo correctamente
		
//		Log log;
//		
//		
//		Iterator iLog = Repositorio.log.iterator();
//		
//		while(iLog.hasNext()){
//			
//			log = (Log)iLog.next();
//			
//			System.out.println(" fecha: " + log.getFecha() +" -nombre: " + log.getNombre() +" -estado: " + log.getEstado() + "\n");
//			
//		}
		
		// probamos los sensores
		
		Dispositivo luz = new Dispositivo("luz",20,new Inteligente("encendido"));
		Dispositivo luz1 = new Dispositivo("luz1",20,new Inteligente("encendido"));
		Dispositivo luz2 = new Dispositivo("luz2",20,new Inteligente("encendido"));
		Dispositivo luz3 = new Dispositivo("luz3",20,new Inteligente("apagado"));
		Dispositivo aire = new Dispositivo("luz3",20,new Inteligente("apagado"));
		
		
		
//		try {
//			luz3.encender();
//			luz.apagar();
//			luz.apagar();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		SensorDeMovimiento sensorLuces = new SensorDeMovimiento();
		AccionApagar apagar = new AccionApagar();
		Regla sinMovimientoApagar = new Regla("menor",1, apagar );
		
		SensorDeTemperatura sensorAire = new SensorDeTemperatura();
		AccionEncender encender = new AccionEncender();
		Regla haceFrio = new Regla("menor",20,encender);
		
		sensorAire.agregarDispositivo(aire);
		haceFrio.agregarSensor(sensorAire);
		haceFrio.setActuador(encender);
		
		try {
			sensorAire.realizarMedicion();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		sensorLuces.agregarDispositivo(luz);
		sensorLuces.agregarDispositivo(luz1);
//		sensorLuces.agregarDispositivo(luz2);
		sensorLuces.agregarDispositivo(luz3);
		
		
		sinMovimientoApagar.agregarSensor(sensorLuces); 
		sinMovimientoApagar.setActuador(apagar);
		
		try {
			sensorLuces.realizarMedicion();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
//		System.out.println(luz.getEstado()+" "+luz1.getEstado()+" "+luz2.getEstado()+" "+luz3.getEstado());
//		System.out.println(aire.getEstado());
	
		
		
		
	}
}
