//package TP_DDS_SGE.TP;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Iterator;
//
//public class App {
//	
//	public static void main( String[] args ) throws FileNotFoundException{
//		
//		try {
//			//Repositorio.importarDispositivos("dispositivos.txt");
//			Repositorio.importarClientes("clientes.txt");
//			Repositorio.importarLog("log.txt");
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		
//		
//		// prueba generar log
//		Cliente pepe = new Cliente();
//		
//		Dispositivo licuadora = new Dispositivo("licuadora",20,new Estandar(3));
//	//	Dispositivo licuadora = new Dispositivo("licuadora",20,new Inteligente("encendido"));
//		
//		pepe.convertirDispositivo(licuadora);
//
//		try {
//			licuadora.encender();
//			licuadora.ahorro();
//			licuadora.apagar();
//			licuadora.apagar();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
////		double consumo = licuadora.consumoUltimasHoras(8);
//		double consumo = licuadora.consumoPeriodo("04/06/2018 23:59:00","15/06/2018 00:00:00");
//		
//		System.out.println("el consumo fue: " + consumo +" Kw/H");
//		
//		//para comprobar que importo correctamente
//		
////		Log log;
////		
////		
////		Iterator iLog = Repositorio.log.iterator();
////		
////		while(iLog.hasNext()){
////			
////			log = (Log)iLog.next();
////			
////			System.out.println(" fecha: " + log.getFecha() +" -nombre: " + log.getNombre() +" -estado: " + log.getEstado() + "\n");
////			
////		}
//	}
//}
