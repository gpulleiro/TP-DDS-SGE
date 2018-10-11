package Repositorio;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Log {
	
	@Id
	@GeneratedValue
	@Column(name = "ID_LOG")
	private long id;
	
	@Column(name = "ID_DISPOSITIVO")
	private long id_dispositivo;
	
	@Column(name = "FECHA")
	private Date fecha;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "ESTADO")
	private String estado;
	
	//constructor
	public Log(Date fecha, String nombre, String estado) {
		super();
		this.fecha = fecha;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Log() {};

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
	
	//metodos
	
	public String toString() {
		return "Log [id=" + id + ", fecha=" + fecha + ", id dispositivo=" + id_dispositivo + ", nombre=" + nombre +
				", estado=" + estado + "]";
	}
	
}
