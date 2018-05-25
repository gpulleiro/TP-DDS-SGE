package TP_DDS_SGE.TP;

import java.io.IOException;

public class Inteligente extends Dispositivo {
	
	private String estado;

	//constructor
	
	public Inteligente(String nombre, float consumoFijo, char tipo, String estado) {
		super(nombre, consumoFijo, tipo);
		this.estado = estado;
	}
	
	//Getters and Setters

	public String getEstado() {
		return estado;
	}
	

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	//metodos
	
	public boolean estasEncendido(){
		
		boolean encendido = false;
		
		if(this.getEstado() == "encendido"){
			
			encendido = true; 
		}
		
		return encendido;
	}
	
	public boolean estasApagado(){
		
		boolean apagado = false;
		
		if(this.getEstado() == "apagado"){
			
			apagado = true; 
		}
		
		return apagado;
	}
	
	public boolean estasAhorro(){
		
		boolean ahorro = false;
		
		if(this.getEstado() == "ahorro"){
			
			ahorro = true; 
		}
		
		return ahorro;
	}
	
	//cuando se cambia el estado de un dispositivo hay que generar un log (puede ser un json)
	//que persista todos los cambios de estado, para luego cuando haya que calcular su consumo
	//poder determinar que que si estuvo apagado el consumo sea = 0 por ejemplo
	
	
	public void encender() throws IOException{
		
		if(this.getEstado() == "encendido"){}
		else{
			Log log = Log.getSingletonInstance("log");
			
			this.setEstado("encendido");
			
			log.generarLog(this.getNombre(), this.getEstado());
		}
	}
	public void apagar() throws IOException{
		
		if(this.getEstado() == "apagado"){}
		else{
		Log log = Log.getSingletonInstance("log");
		
		this.setEstado("apagado");
		
		log.generarLog(this.getNombre(), this.getEstado());
		}
	}
	public void ahorro() throws IOException{
		
		if(this.getEstado() == "ahorro"){}
		else{
		Log log = Log.getSingletonInstance("log");
		
		this.setEstado("ahorro");
		
		log.generarLog(this.getNombre(), this.getEstado());
		}
	}
	
	// opcion 2
	
	public void cambiarEstado(String estado) throws IOException{
		if(this.getEstado() == estado){}
		else{
			Log log = Log.getSingletonInstance("log");
			
			this.setEstado(estado);
			
			log.generarLog(this.getNombre(), this.getEstado());
			}
	}
}

