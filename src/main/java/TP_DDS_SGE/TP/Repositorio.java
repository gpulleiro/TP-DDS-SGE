package TP_DDS_SGE.TP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Repositorio {
	
	static String dir = "C:\\Users\\Gaston Adm\\Github TP DDS\\TP-DDS-SGE";
	static ArrayList<Cliente> clientes;
	static ArrayList<Dispositivo> dispositivos;
	static ArrayList<Log> log;
	private static Repositorio miRepositorio;
	
	
	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public static void setClientes(ArrayList<Cliente> clientes) {
		Repositorio.clientes = clientes;
	}

	public static ArrayList<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public static void setDispositivos(ArrayList<Dispositivo> dispositivos) {
		Repositorio.dispositivos = dispositivos;
	}

	public static ArrayList<Log> getLog() {
		return log;
	}

	public static void setLog(ArrayList<Log> log) {
		Repositorio.log = log;
	}

	//singleton para no instanciarlo mas de una vez
	public static Repositorio getRepositorio(){
		 
		 if (miRepositorio == null) {
		 
		 miRepositorio = new Repositorio();
		 
		 }
		 
		 return miRepositorio;
	}
	
	// metodos
	
	public static void generarLog(Log log) throws IOException {

		FileWriter archivo = new FileWriter(new File(dir+"\\"+"log.txt"),false);
		
		Gson gson = new GsonBuilder().setDateFormat("dd/MM/yy HH:mm:ss").create();
		
		Repositorio.log.add(log);
		
		String json = gson.toJson(Repositorio.log);
			
		archivo.write(json);
			
		archivo.close();
			
	}	
	
	public static void generarClientes(Cliente cli) throws IOException {
		
		FileWriter archivo = new FileWriter(new File(dir+"\\"+"clientes.txt"),false);
		
		Gson gson = new Gson();
		
		Repositorio.clientes.add(cli);
		
		String json = gson.toJson(cli);
		
		archivo.write(json);
		
		archivo.close();
		
	}	
	
	public static void generarDispositivos(Dispositivo dis) throws IOException {
		
		FileWriter archivo = new FileWriter(new File(dir+"\\"+"dispositivos.txt"),false);
		
		Gson gson = new Gson();
		
		Repositorio.dispositivos.add(dis);
		
		String json = gson.toJson(dis);
		
		archivo.write(json);
		
		archivo.close();
		
	}	
	
	//importar los archivos 
	public static ArrayList<Log> importarLog (String json) throws IOException {
		
		//pregunta si el archivo existe, de no ser asi crea uno con una lista vacia 
		if(new File(dir+"\\"+"log.txt").exists() == false){
			
			FileWriter archivo = new FileWriter(new File(dir+"\\"+"log.txt"),false);
			
			archivo.write("[]");
			
			archivo.close();
		}
		
		Type tipoListaLog = new TypeToken<ArrayList<Log>>(){}.getType();
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(json));
		
		Gson gson = new Gson();
		
		Repositorio.setLog(gson.fromJson(bufferedReader, tipoListaLog));
		
		return Repositorio.log;
		
	}
	
	
	public static ArrayList<Cliente> importarClientes (String json) throws IOException {
		
		//pregunta si el archivo existe, de no ser asi crea uno con una lista vacia 
		if(new File(dir+"\\"+"clientes.txt").exists() == false){
					
			FileWriter archivo = new FileWriter(new File(dir+"\\"+"clientes.txt"),false);
			
			archivo.write("[]");
					
			archivo.close();
		}
		
		Type tipoListaCliente = new TypeToken<ArrayList<Cliente>>(){}.getType();
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(json));
		
		Gson gson = new Gson();
		
		Repositorio.setClientes(gson.fromJson(bufferedReader, tipoListaCliente));
		
		return Repositorio.clientes;
	}
	
	public static ArrayList<Dispositivo> importarDispositivos (String json) throws IOException {
		
		//pregunta si el archivo existe, de no ser asi crea uno con una lista vacia 
		if(new File(dir+"\\"+"clientes.txt").exists() == false){
							
			FileWriter archivo = new FileWriter(new File(dir+"\\"+"clientes.txt"),false);
					
			archivo.write("[]");
							
			archivo.close();
		}
		
		Type tipoListaDispositivos = new TypeToken<ArrayList<Dispositivo>>(){}.getType();
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(json));
		
		Gson gson = new Gson();
		
		Repositorio.setDispositivos(gson.fromJson(bufferedReader, tipoListaDispositivos));
		
		return Repositorio.dispositivos;
	}
	
	//para comprobar que importo correctamente
//		
//		Cliente cli;
//		
//		Dispositivo dis;
//		
//		Iterator itercli = clientes.iterator();
//		
//		while(itercli.hasNext()){
//			cli = (Cliente)itercli.next();
//			
//			System.out.println("nombre: " + cli.getNombre() +" -apellido: " + cli.getApellido() +" -domicilio: " + cli.getDomicilio() +" -usuario: " + cli.getUsuario()+ " -contrasenia: " + cli.getContrasenia() + "\n");
//			
//			Iterator iterdis = cli.getDispositivos().iterator();
//			
//			while(iterdis.hasNext()){
//				dis = (Dispositivo)iterdis.next();
//				
//				System.out.println("nombre dis: "+dis.getNombre()+ " -consumo dis: "+ dis.getConsumoFijo() + " -estado dis: " + dis.getTipo() + "\n");
//				
//			}
//		}
	
}