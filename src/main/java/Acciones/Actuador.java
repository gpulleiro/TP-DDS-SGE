package Acciones;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import Dispositivo.Inteligente;

@Entity
@Table(name="ACTUADOR")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO", discriminatorType = DiscriminatorType.STRING)
public abstract class Actuador {
	
	@Id
	@GeneratedValue
	@Column(name="ID_ACTUADOR")
	protected long id;
	
	@Column(name = "NOMBRE_ACTUADOR")
	private String nombre;

	public Actuador(String unNombre) {
		this.nombre = unNombre;
	}
	public Actuador() {}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void actuar (Inteligente dispositivo) throws IOException {
	}
	
}
