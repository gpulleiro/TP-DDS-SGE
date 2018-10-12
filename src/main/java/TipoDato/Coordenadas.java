package TipoDato;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COORDENADAS")
public class Coordenadas {
	
	@Id
	@GeneratedValue
	@Column(name="ID_COORD")
	private long id;
	
	@Column(name="LATITUD")
	private double latitud;
	
	@Column(name="LONGITUD")
	private double longitud;
	
	//constructor
	public Coordenadas(double latitud, double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	public Coordenadas() {}
	
	
	//getters and setters
	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	
	

}
