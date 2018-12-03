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
import Usuarios.Cliente;

@Entity
@Table(name="REGLA")
public class Regla implements Observer {
	
	@Id
	@GeneratedValue
	@Column(name = "ID_REGLA")
	private long id;
	
	@ManyToOne(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	private Sensor sensor;
	//private ArrayList<Sensor>sensores;
	@OneToOne(cascade = {CascadeType.ALL})
	private Actuador actuador;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "FLAG")
	private double flag;
	@Column(name="CONDICION")
	private String condicion;
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	private List<Inteligente> inteligentes = new ArrayList<Inteligente>();
	
//	@ManyToOne(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
//	private Cliente cliente;
		
	//agrego un sensor a la lista de sensores y agrego a la regla como observador del sensor.
	
	
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
	
	public Regla(String nombre, String condicion, double flag, Actuador actuador){
		this.nombre = nombre;
		this.flag = flag;
		this.actuador = actuador;
		this.condicion = condicion;
	}
	
	

	public Regla(String nombre, double flag, String condicion) {
		super();
		this.nombre = nombre;
		this.flag = flag;
		this.condicion = condicion;
	}
	
	
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


//	public Cliente getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}

	
	
	public long getId() {
		return id;
	}

	public List<Inteligente> getInteligentes() {
		return inteligentes;
	}

	public void setInteligentes(List<Inteligente> inteligentes) {
		this.inteligentes = inteligentes;
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
	
	public void aniadirDispositivo(Inteligente inteligente) {
		this.inteligentes.add(inteligente);
		inteligente.agregarObservador(this);
	}
	
	//metodo que implementa la condicion del IF. Se podría hacer con un switch creo
	public boolean condicionD(Inteligente dis){
	if ("menor".equals(this.getCondicion())){
	return dis.getCantidadHorasEncendido() < this.getFlag();
	}
	else if ("igual".equals(this.getCondicion())){
	return dis.getCantidadHorasEncendido() == this.getFlag();
	}
	else if ("mayor".equals(this.getCondicion())) {
		return dis.getCantidadHorasEncendido() > this.getFlag();		
	}
	return false;
	}
	
	
	//metodo update
	public void update() throws IOException {
	
		for(Inteligente dis:this.getInteligentes()) {
			
			if(condicionD(dis)) {
				
				this.getActuador().actuar(dis);
			}
		}
}
	
}

