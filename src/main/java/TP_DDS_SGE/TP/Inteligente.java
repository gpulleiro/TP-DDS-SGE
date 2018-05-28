package TP_DDS_SGE.TP;

import java.io.IOException;
import java.util.Calendar;

public class Inteligente implements Tipo {
	
	private String estado;
	
	//constructor	
	public Inteligente(String estado) {
		super();
		this.estado = estado;
	}
		
	//setters and getters
	@Override
	public String getEstado() {
		return estado;
	}
	@Override
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int getCantHoras() {
		
		System.out.println("los dispositivos inteligentes no poseen una cantidad de horas de consumo estimativo");
		
		return 0;
	}
	
	@Override
	public void setCantHoras(int cantHoras) {
		
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
			
			Calendar fechaActual = Calendar.getInstance();
			this.setEstado("encendido");
			Log log = new Log(fechaActual.getTime(),Dispositivo.nombre, this.getEstado());
			
			try {
				Repositorio.generarLog(log);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void apagar() {
		
		if(this.getEstado() == "apagado"){}
			else{
				
			Calendar fechaActual = Calendar.getInstance();
			this.setEstado("apagado");
			Log log = new Log(fechaActual.getTime(),Dispositivo.nombre, this.getEstado());
			try {
				Repositorio.generarLog(log);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void ahorro() {
		
		if(this.getEstado() == "ahorro"){}
			else{
				
			Calendar fechaActual = Calendar.getInstance();
			this.setEstado("ahorro");
			Log log = new Log(fechaActual.getTime(),Dispositivo.nombre, this.getEstado());
			try {
				Repositorio.generarLog(log);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void cambiarEstado(String estado) {
		
		if(this.getEstado() == estado){}
		else{
			
			Calendar fechaActual = Calendar.getInstance();
			this.setEstado(estado);
			Log log = new Log(fechaActual.getTime(),Dispositivo.nombre, estado);
			try {
				Repositorio.generarLog(log);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	
	//falta terminar
	public float consumoUltimasHoras(int horas){
		
		float consumo = 0;
		
		return consumo;
	}
	
}