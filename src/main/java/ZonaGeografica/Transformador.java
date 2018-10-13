package ZonaGeografica;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import TipoDato.Coordenadas;
import Usuarios.Cliente;

import javax.persistence.*;


@Entity
@Table(name = "TRANSFORMADOR", uniqueConstraints = {@UniqueConstraint(columnNames = {"coordenadas_ID_COORD"})})
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public class Transformador {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Coordenadas coordenadas;
	
	@Column(name="ZONA")
	private int zona;
	
	
/*	@JoinTable(name="CLIENTE",
	joinColumns = {@JoinColumn(name = "ID")},
	inverseJoinColumns = {@JoinColumn(name = "ID_TRAFO")}
	)*/
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	//constructor
	public Transformador(int id, Coordenadas coordenadas, int zona) {
		super();
		this.id = id;
		this.coordenadas = coordenadas;
		this.clientes = new ArrayList<Cliente>();
		this.zona = zona;
	}
	
	public Transformador(Coordenadas coordenadas, int zona) {
		super();
		this.coordenadas = coordenadas;
		this.clientes = new ArrayList<Cliente>();
		this.zona = zona;
	}
	
	public Transformador() {
		// TODO Auto-generated constructor stub
	}

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Coordenadas getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenadas coordenadas) {
		this.coordenadas = coordenadas;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	//metodos 
	
	public int getZona() {
		return zona;
	}

	public void setZona(int zona) {
		this.zona = zona;
	}
	

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	
	public double consumo(String fecha) throws ParseException{
		
		double consumoTotal = 0;
		
		for (Cliente obj: this.getClientes()){
			
			consumoTotal = consumoTotal + obj.consumo(fecha);
		}
		
		return consumoTotal;
	}
	
	public String toString() {
		return "Transformador [id=" + id + ", coordenadas=" + coordenadas + ", zona="
				+ zona + ", clientes=" + clientes
				+ "]";
	}
	
}

