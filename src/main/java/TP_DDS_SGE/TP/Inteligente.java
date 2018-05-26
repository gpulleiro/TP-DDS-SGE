package TP_DDS_SGE.TP;

import java.io.IOException;

public class Inteligente implements Tipo {
	
	private String estado;
	
	//constructor	
	public Inteligente(String estado) {
		super();
		this.estado = estado;
	}
		
	//setters and getters
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	//metodos
	@Override
	public boolean estasEncendido() {

		boolean encendido = false;
		
		if(this.getEstado() == "encendido"){
			
			encendido = true; 
		}
		
		return encendido;
	}

	@Override
	public boolean estasApagado() {
		
		boolean apagado = false;
		
		if(this.getEstado() == "apagado"){
			
			apagado = true; 
		}
		
		return apagado;	
	}

	@Override
	public boolean estasAhorro() {
	
		boolean ahorro = false;
		
		if(this.getEstado() == "ahorro"){
			
			ahorro = true; 
		}
		
		return ahorro;		
	}

	@Override
	public void encender() {
		
		if(this.getEstado() == "encendido"){}
		else{
			Log log = Log.getSingletonInstance("log");
			
			this.setEstado("encendido");
			
			try {
				log.generarLog(Dispositivo.nombre, this.getEstado());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void apagar() {
		
		if(this.getEstado() == "apagado"){}
		else{
		Log log = Log.getSingletonInstance("log");
		
		this.setEstado("apagado");
		
		try {
			log.generarLog(Dispositivo.nombre, this.getEstado());
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
	}

	@Override
	public void ahorro() {
		
		if(this.getEstado() == "ahorro"){}
		else{
		Log log = Log.getSingletonInstance("log");
		
		this.setEstado("ahorro");
		
		try {
			log.generarLog(Dispositivo.nombre , this.getEstado());
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
	}

	@Override
	public void cambiarEstado(String estado) {
		
		if(this.getEstado() == estado){}
		else{
			Log log = Log.getSingletonInstance("log");
			
			this.setEstado(estado);
			
			try {
				log.generarLog(Dispositivo.nombre, this.getEstado());
			} catch (IOException e) {
				e.printStackTrace();
			}
			}	
	}
	
}