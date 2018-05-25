package TP_DDS_SGE.TP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;


public class Log {
	
	private String nombre;
	private String dir;
	private FileWriter archivo;
	private static Log log;
	
	
	//constructor
	
	private Log(String nombre) {
		super();
	}
	
	//setters and getters
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}

	//metodos
	
	public static Log getSingletonInstance(String nombre){
		
		if(log == null){
			log = new Log(nombre);
		}
		return log;
	}
	
	
	public void generarLog(String nombre, String estado) throws IOException{
		
		//seteo la dir del log
		setDir("C:\\Users\\Gaston Adm\\Github TP DDS\\TP-DDS-SGE");
		
		//pregunto si el archivo esta creado, sino lo creo
		if(new File(this.dir+"\\"+"log.txt").exists() == false){
			
			archivo = new FileWriter(new File(this.dir+"\\"+"log.txt"),false);
		}
			archivo = new FileWriter(new File(this.dir+"\\"+"log.txt"),true);
			
			Calendar fechaActual = Calendar.getInstance();
			
		//escribo el log
		archivo.write("["+ (String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH))
				+"/"+(String.valueOf(fechaActual.get(Calendar.MONTH)+1)
						+"/"+(String.valueOf(fechaActual.get(Calendar.YEAR))
								+" "+(String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY))
										+":"+(String.valueOf(fechaActual.get(Calendar.MINUTE))
												+":"+(String.valueOf(fechaActual.get(Calendar.SECOND))
														+" "+(nombre)
															+" "+(estado)))))))+"]\n");
		archivo.close();
	}
	
}
