package TP_DDS_SGE.TP;

import java.io.FileNotFoundException;

public class App {
	
	public static void main( String[] args ) throws FileNotFoundException{
		
		RepositorioUsuarios.importarJSON("jsonList.txt");
	}
}
