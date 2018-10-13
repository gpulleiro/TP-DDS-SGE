package Sensores;

import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table(name="MEDICION")
public class Medicion {

	@Id
	@GeneratedValue
	@Column(name = "ID_MEDICION")
	long id;
	
	@Column(name = "MAGNITUD")
	private double magnitud;
	
	@Column(name = "FECHA_HORA")
	Calendar fecha_hora = Calendar.getInstance();

	public double getMagnitud() {
		return magnitud;
	}
	public void setMagnitud(double magnitud) {
		this.magnitud = magnitud;
	}
	
	
	
}
