package Aplicacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import Dispositivo.Dispositivo;
import Dispositivo.Inteligente;
import Repositorio.Log;
import Repositorio.Repositorio;
import Usuarios.Cliente;

public class Main {
	
	public static void main( String[] args ) throws IOException{
	
			Repositorio.importarLog();
			Repositorio.importarDispositivos();
			Repositorio.importarClientes();

	}
}
