package Usuarios;

import java.util.Calendar;
import java.util.GregorianCalendar;


public abstract class Usuario {

	protected String nombre;
	protected String apellido;
	protected String domicilio;
	protected String fechaAlta;
	protected String usuario;
	protected String contrasenia;
	
	//constructor

	public Usuario(String nombre, String apellido, String domicilio, String fechaAlta, String usuario,
			String contrasenia) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.fechaAlta = fechaAlta;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	
	public Usuario() {
	}

	//getters-setters
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}	

	//metodos
	
}
