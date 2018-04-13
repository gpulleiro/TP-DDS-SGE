package main;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Administrador extends Usuario {

	private int ID;

	//constructor
	
	public Administrador(String nombre, String apellido, String domicilio, Calendar fechaAlta, String usuario,
			String contrasenia,int ID) {
		super(nombre, apellido, domicilio, fechaAlta, usuario, contrasenia);
	
		this.ID = ID;
			}

	
	//getters-setters
	
	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}

	//metodos
	
	//cantidad de meses
	public static int cantidadMeses(){	
		Calendar hoy = new GregorianCalendar();
		int difAnio = hoy.get(Calendar.YEAR)- fechaAlta.get(Calendar.YEAR);
		int difMes = difAnio * 12 + hoy.get(Calendar.MONTH)- fechaAlta.get(Calendar.MONTH);
		
		return difMes;
	}
	
}

