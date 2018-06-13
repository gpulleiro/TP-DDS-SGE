package Dispositivo;

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
	
	public String getEstado(){
		return this.tipo.getEstado();
	};
	
	public void setEstado(String estado){
		this.tipo.setEstado(estado);
	};

	
	
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
	
	public double consumoUltimasHoras(int horas){
		
		double consumo = this.getTipo().consumoUltimasHoras(horas);
		
		return consumo;
	}
	
	public double consumoPeriodo(String fecha1, String fecha2){
		
		double consumo = this.getTipo().consumoPeriodo(fecha1, fecha2);
		
		return consumo;
	}
	
	public float consumo(){
		
		float consumo = this.getTipo().consumo();
		
		return consumo;
		
	}
}


