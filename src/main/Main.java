package main;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {

		
		Calendar fecha = new GregorianCalendar();
		
		fecha.set(Calendar.DAY_OF_MONTH ,11);
		fecha.set(Calendar.MONTH ,0);
		fecha.set(Calendar.YEAR ,2017);
		
		Administrador a = new Administrador ("gaston","pulleiro","fabian onsari", fecha, "pepe","pepe",12);

		a.setFechaAlta(fecha);

		System.out.println(a.cantidadMeses());


	}

}
