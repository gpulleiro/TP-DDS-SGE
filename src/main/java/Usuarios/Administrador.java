package Usuarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Administrador extends Usuario {

	private int ID;

	//constructor
	
	public Administrador(String nombre, String apellido, String domicilio, String fechaAlta, String usuario,
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
	public long cantidadMeses() throws ParseException{
		
		Calendar fechaInicio = Calendar.getInstance();
		Calendar hoy = Calendar.getInstance();
		hoy.setTime(new Date());
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		fechaInicio.setTime(formato.parse(this.fechaAlta));
		long meses = (hoy.getTimeInMillis() - fechaInicio.getTimeInMillis());
		meses = meses/(1000*60*60);
		
		return meses;
	}
	
}

