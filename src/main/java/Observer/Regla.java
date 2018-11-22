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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import Acciones.Actuador;
import Dispositivo.Dispositivo;
import Dispositivo.Inteligente;

@Entity
@Table(name="REGLA")
public class Regla implements Observer {
	
	public Regla() {
	}
	
	public Regla(String nombre, String condicion, double flag, Actuador actuador, Sensor sensor){
		this.nombre = nombre;
		this.flag = flag;
		this.actuador = actuador;
		this.condicion = condicion;
		this.sensor = sensor;
		sensor.agregarObservador(this);
	}
	
	@Id
	@GeneratedValue
	@Column(name = "ID_REGLA")
	private long id;
	
	@ManyToOne(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	private Sensor sensor;
	//private ArrayList<Sensor>sensores;
	@OneToOne(cascade = {CascadeType.ALL})
	private Actuador actuador;
	@Column(name = "NOMBRE", unique=true)
	private String nombre;
	@Column(name = "FLAG")
	private double flag;
	@Column(name="CONDICION")
	private String condicion;
	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	private List<Inteligente> dispositivos = new ArrayList<Inteligente>();
		
	//agrego un sensor a la lista de sensores y agrego a la regla como observador del sensor.
	
public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
		sensor.agregarObservador(this);
	}

	//getters y setters	
	public Actuador getActuador() {
		return actuador;
	}

	public void setActuador(Actuador actuador) {
		this.actuador = actuador;
	}

	
//		public ArrayList<Sensor> getSensores() {
//		return sensores;
//	}

	public List<Inteligente> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Inteligente> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	if(condicionD(this.getSensor()))
	{for(Inteligente dis: this.getDispositivos())
	{this.getActuador().actuar(dis);}}
}
	
}

