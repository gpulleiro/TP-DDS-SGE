package ZonaGeografica;

import java.text.ParseException;
import java.util.ArrayList;

import TipoDato.Coordenadas;
import Usuarios.Cliente;

public class Transformador {
	
	private int id;
	private Coordenadas coordenadas;
	private int zona;
	private ArrayList<Cliente> clientes;
	
	//constructor
	public Transformador(int id, Coordenadas coordenadas, int zona) {
		super();
		this.id = id;
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

	public ArrayList<Cliente> getClientes() {
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

	public double consumo(String fecha) throws ParseException{
		
		double consumoTotal = 0;
		
		for (Cliente obj: this.getClientes()){
			
			consumoTotal = consumoTotal + obj.consumo(fecha);
		}
		
		return consumoTotal;
	}
	
}
