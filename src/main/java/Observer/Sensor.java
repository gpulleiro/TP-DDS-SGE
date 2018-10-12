package Observer;

import java.io.IOException;
import java.util.ArrayList;

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
import javax.persistence.Table;

import Dispositivo.Dispositivo;
import Dispositivo.Inteligente;

@Entity
@Table(name="SENSOR")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(name = "TIPO", discriminatorType = DiscriminatorType.STRING)
public abstract class Sensor implements Subject{
	@Id
	@GeneratedValue
	@Column(name = "ID_SENSOR")
	protected long id;
	
	@ManyToMany(mappedBy ="sensores",fetch = FetchType.LAZY)
	protected ArrayList<Observer>observadores;
	protected ArrayList<Inteligente>dispositivos;
	private double magnitud;
	
	//metodos del patron Observer
	public void agregarObservador(Observer obs) {observadores.add(obs);};
	
	public void notificar() throws IOException {
		for(Observer obs:observadores) {obs.update();}
	}

	public ArrayList<Inteligente> getDispositivos() {
		return dispositivos;
	}
	

	public ArrayList<Observer> getObservadores() {
		return observadores;
	}

	public void setObservadores(ArrayList<Observer> observadores) {
		this.observadores = observadores;
	}

	public void setDispositivos(ArrayList<Inteligente> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public void setMagnitud(double magnitud) {
		this.magnitud = magnitud;
	}

	public double getMagnitud() {
		return magnitud;
	}

	//agrega un dispositivo a la lista de dispositivos del sensor
	public void agregarDispositivo(Inteligente dis){dispositivos.add(dis);};
	
	//hago que al medir el movimiento devuelva falso
	public void realizarMedicion() throws IOException{
//	this.setMovimiento(false);
//	notificar();
}

}
