package TP_DDS_SGE.TP;

import java.io.IOException;

public class Dispositivo {
	
	static String nombre;
	static float consumoFijo;
	private Tipo tipo;
	
	//constructor
	public Dispositivo(String nombre, float consumoFijo, Tipo tipo) {
		super();
		Dispositivo.nombre = nombre;
		Dispositivo.consumoFijo = consumoFijo;
		this.tipo = tipo;
	}
	
	//getters and setters
	public String getNombre() {
		return nombre;
	}
		
	public void setNombre(String nombre) {
		Dispositivo.nombre = nombre;
	}
		
	public float getConsumoFijo() {
		return consumoFijo;
	}
		
	public void setConsumoFijo(float consumoFijo) {
		Dispositivo.consumoFijo = consumoFijo;
	}
		
	public Tipo getTipo() {
		return tipo;
	}
		
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	//al utilizar el patron state, los metodos de la clase dispositivo lo que hacen es decirle al tipo que invoque el metodo y dependiendo de que tipo sea
	//inteligente o estandar va a realizar una accion u otra
	

	public void estasEncendido(){
		
		this.getTipo().estasEncendido();
	}
	
	public void estasApagado(){
		
		this.getTipo().estasApagado();
	}
	
	public void estasAhorro(){
		
		this.getTipo().estasAhorro();
		
	}
	
	public void encender() throws IOException{
		
		this.getTipo().encender();
	}
	public void apagar() throws IOException{
		
		this.getTipo().apagar();
	}
	
	public void ahorro() throws IOException{

		this.getTipo().ahorro();
	}
	
	// opcion 2
	
	public void cambiarEstado(String estado) throws IOException{

		this.getTipo().cambiarEstado(estado);
	}
}


