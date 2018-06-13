package Repositorio;

import java.util.Date;

public class Log {
	
	private Date fecha;
	private String nombre;
	private String estado;
	
	//constructor
	public Log(Date fecha, String nombre, String estado) {
		super();
		this.fecha = fecha;
		this.nombre = nombre;
		this.estado = estado;
	}

	//getters and setters
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

	
}
