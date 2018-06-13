package Repositorio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import Dispositivo.Dispositivo;
import Usuarios.Cliente;

public class Repositorio {
	
	public static String dir = "C:\\Users\\Gaston Adm\\Github TP DDS\\TP-DDS-SGE";
	public static ArrayList<Cliente> clientes;
	public static ArrayList<Dispositivo> dispositivos;
	public static ArrayList<Log> log;
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
	
	//importar los archivos 
	public static void importarLog () throws IOException {
		
		String json = dir+"\\"+"log.txt";
		
		Type tipoListaLog = new TypeToken<ArrayList<Log>>(){}.getType();
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(json));
		
		Gson gson = new Gson();
		
		Repositorio.setLog(gson.fromJson(bufferedReader, tipoListaLog));
		
	}
	
	
	public static void importarClientes () throws IOException {

		String json = dir+"\\"+"clientes.txt";
		
		Type tipoListaCliente = new TypeToken<ArrayList<Cliente>>(){}.getType();
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(json));
		
		Gson gson = new Gson();
		
		Repositorio.setClientes(gson.fromJson(bufferedReader, tipoListaCliente));
	}
	
	public static void importarDispositivos () throws IOException {
		
		String json = dir+"\\"+"dispositivos.txt";
		
		Type tipoListaDispositivos = new TypeToken<ArrayList<Dispositivo>>(){}.getType();
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(json));
		
		Gson gson = new Gson();
		
		Repositorio.setDispositivos(gson.fromJson(bufferedReader, tipoListaDispositivos));
	
	}
}