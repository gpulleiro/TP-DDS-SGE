package ZonaGeografica;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import TipoDato.Coordenadas;

import javax.persistence.*;

import Dispositivo.Dispositivo;

@Entity
@Table(name = "ZONA")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public class Zona {
	
	@Id
	@GeneratedValue
	@Column( name = "ID_ZONA")
	private int id;
	
	@Column(name = "NOMBRE" )
	private String nombre;
	
	@OneToOne
	private Coordenadas coordenadas;
	
	@Column( name = "RADIO" )
	private int radio;
	

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List <Transformador> transformadores = new ArrayList<Transformador>();
	
	//constructor
	public Zona(int id, String nombre,Coordenadas coordenadas,
			int radio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.coordenadas = coordenadas;
		this.radio = radio;
		this.setTransformadores(new ArrayList<Transformador>());
	}
	
	
	public Zona(String nombre,int radio  ) {
		this.nombre = nombre;
		this.radio = radio;
		this.setTransformadores(new ArrayList<Transformador>());
	}
	
	
	public Zona() {
		super();
	}


	/*public Zona() {
		super();
		this.transformadores = new ArrayList<Transformador>();
	}*/
	
	public Zona(ArrayList<Transformador> transformadores2) {
		// TODO Auto-generated constructor stub
	}
	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Coordenadas getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenadas coordenadas) {
		this.coordenadas = coordenadas;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
	
	public List<Transformador> getTransformadores() {
		return transformadores;
	}
	
	public void setTransformadores(ArrayList<Transformador> transformadores) {
		this.transformadores = transformadores;
	}
	
	public void aniadirTransformador(Transformador unTrafo) {
		this.transformadores.add(unTrafo);
	}
	//metodos 
	public double consumo(String fecha) throws ParseException{
		
		double consumoTotal = 0;
		for (Transformador unTrafo : this.getTransformadores()){
			consumoTotal += unTrafo.consumo(fecha);
		}
		
		return consumoTotal;
	}

	
	
	
}