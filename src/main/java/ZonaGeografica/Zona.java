package ZonaGeografica;

import java.text.ParseException;
import java.util.ArrayList;

import TipoDato.Coordenadas;

public class Zona {
	
	private int id;
	private String nombre;
	private Coordenadas coordenadas;
	private int radio;
	private ArrayList<Transformador> transformadores;
	
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
	
	public ArrayList<Transformador> getTransformadores() {
		return transformadores;
	}
	
	public void setTransformadores(ArrayList<Transformador> transformadores) {
		this.transformadores = transformadores;
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
