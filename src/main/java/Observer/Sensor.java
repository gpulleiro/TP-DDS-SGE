package Observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import Dispositivo.Dispositivo;
import Dispositivo.Inteligente;
import Sensores.Medicion;

@Entity
@Table(name="SENSOR")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(name = "TIPO", discriminatorType = DiscriminatorType.STRING)
public abstract class Sensor implements Subject{
	@Id
	@GeneratedValue
	@Column(name = "ID_SENSOR")
	protected long id;

	
	@OneToMany(targetEntity=Regla.class, cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	protected List <Observer> observadores = new ArrayList<Observer>();
	//protected ArrayList<Observer>observadores;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	protected List <Medicion> mediciones = new ArrayList<Medicion>();
	
	@Column(name = "MAGNITUD")
	protected double magnitud;
	
	//metodos del patron Observer
	public void agregarObservador(Observer obs) {observadores.add(obs);};
	
	public void notificar() throws IOException {
		for(Observer obs:observadores) {obs.update();}
	}

	


	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Observer> getObservadores() {
		return observadores;
	}

	public void setObservadores(List<Observer> observadores) {
		this.observadores = observadores;
	}

	public double getMagnitud() {
		return magnitud;
	}

	public void setMagnitud(double magnitud) {
		this.magnitud = magnitud;
	}

	public void agregarMedicion(double magnitud){
		
		Medicion medicion = new Medicion();
		medicion.setMagnitud(magnitud);
		mediciones.add(medicion);
		
	}
	
	
	public void realizarMedicion() throws IOException{
//	this.setMovimiento(false);
//	notificar();
}

}
