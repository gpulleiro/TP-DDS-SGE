package TipoDato;

import java.util.Date;

import javax.persistence.*;

import Usuarios.Cliente;

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
	
	@Column(name = "ID_CLIENTE")
	private long id_cliente; 
	
	//constructor
	public Log(Date fecha, String nombre, String estado) {
		super();
		this.fecha = fecha;
		this.nombre = nombre;
		this.estado = estado;
	}
	
	public Log(long id_dispositivo, Date fecha, String nombre, String estado, long id_Cliente) {
		super();
		this.id_dispositivo = id_dispositivo;
		this.fecha = fecha;
		this.nombre = nombre;
		this.estado = estado;
		this.id_cliente = id_Cliente;
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
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId_dispositivo() {
		return id_dispositivo;
	}

	public void setId_dispositivo(long id_dispositivo) {
		this.id_dispositivo = id_dispositivo;
	}

	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String toString() {
		return "Log [id=" + id + ", fecha=" + fecha + ", id dispositivo=" + id_dispositivo + ", nombre=" + nombre +
				", estado=" + estado + "]";
	}
	
}
