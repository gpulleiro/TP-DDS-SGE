package TP_DDS_SGE.TP;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException{
    	String path = "json.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        Gson gson = new Gson();
        Object json = gson.fromJson(bufferedReader, Object.class);

        System.out.println(json.getClass());
        System.out.println(json.toString());
    }
}

