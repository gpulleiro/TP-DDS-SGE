package TP_DDS_SGE.TP;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class App {
	
	public static BufferedReader leerArchivo() throws FileNotFoundException {
    	
    	BufferedReader bufferedReader = new BufferedReader(new FileReader("jsonList.txt"));
    	
    	return bufferedReader;
	}
        
	public static List<Cliente> armarLista() throws FileNotFoundException{
		Gson gson = new Gson();
        Type tipoListaclientesJSON = new TypeToken<List<Cliente>>(){}.getType();
        List<Cliente> usuarios = gson.fromJson(leerArchivo(), tipoListaclientesJSON);
        
        return usuarios;
	}
}

