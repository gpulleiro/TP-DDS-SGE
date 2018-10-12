package Observer;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import Acciones.Actuador;
import Dispositivo.Dispositivo;
import Dispositivo.Inteligente;

@Entity
@Table(name="REGLA")
public class Regla implements Observer {

	@Id
	@GeneratedValue
	@Column(name = "ID_REGLA")
	protected long id;
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name="ID_SENSOR")
	private ArrayList<Sensor>sensores;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "ID_ACTUADOR")
	private Actuador actuador;
	@Column(name = "FLAG")
	private double flag;
	@Column(name="CONDICION")
	private String condicion;
	
	//regla(condicion, flag, actuador)
	
	public Regla(String condicion, double flag, Actuador actuador){
		this.flag = flag;
		this.actuador = actuador;
		this.condicion = condicion;
		sensores = new ArrayList<Sensor>();
	}
		
	//agrego un sensor a la lista de sensores y agrego a la regla como observador del sensor.
	public void agregarSensor(Sensor sen){
		sensores.add(sen);
		sen.agregarObservador(this);
	}
	
//getters y setters	
	public Actuador getActuador() {
		return actuador;
	}

	public void setActuador(Actuador actuador) {
		this.actuador = actuador;
	}
		
		public ArrayList<Sensor> getSensores() {
		return sensores;
	}

	public void setSensores(ArrayList<Sensor> sensores) {
		this.sensores = sensores;
	}

	public double getFlag() {
		return flag;
	}

	public void setFlag(double flag) {
		this.flag = flag;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	
	//metodo que implementa la condicion del IF. Se podría hacer con un switch creo
	public boolean condicionD(Sensor sen){
	if (this.getCondicion() == "menor"){
	return sen.getMagnitud() < this.getFlag();
	}
	else if (this.getCondicion() == "igual"){
	return sen.getMagnitud() == this.getFlag();
	}
	else if (this.getCondicion() == "mayor") {}
	return sen.getMagnitud() > this.getFlag();
	}
	
	
	//metodo update
	public void update() throws IOException {
	for (Sensor sen:sensores)
	{if(condicionD(sen))
	{for(Inteligente dis: sen.getDispositivos())
	{this.getActuador().actuar(dis);}}}
}
	
}

