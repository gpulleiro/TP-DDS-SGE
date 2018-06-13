package Dispositivo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import Repositorio.Log;
import Repositorio.Repositorio;

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
			this.setEstado("encendido");
		}
	}

	@Override
	public void apagar() {
		
		if(this.getEstado() == "apagado"){}
			else{
			this.setEstado("apagado");
		}
	}

	@Override
	public void ahorro() {
		
		if(this.getEstado() == "ahorro"){}
			else{
			this.setEstado("ahorro");
		}
	}

	@Override
	public void cambiarEstado(String estado) {
		
		if(this.getEstado() == estado){}
		else{
			this.setEstado(estado);
		}	
	}
	
	public double consumoInteligente(String estado, long horas){

		double consumoTotal = 0;
		
		switch(estado){
			
		case "encendido":
			
			consumoTotal = Dispositivo.consumoFijo * horas;
		
			break;
			
		case "apagado": 
			
			consumoTotal = 0;
			
			break;
			
		case "ahorro":
			
			consumoTotal = (Dispositivo.consumoFijo * horas) * 0.5;
			
			break;
			
		}
		
			return consumoTotal;
	
	}
	
	@Override
	public float consumo(){
		
		System.out.println("este dispositivo es inteligente, debe especificar el consumo en un determinado rango horario o una cantidad de horas hacia atras");
		
		return 0;
	}
	
	
	@Override
	public double consumoUltimasHoras(int horas){

		double consumoTotal = 0;
		
		//filtro la lista con el dispositivo deseado
		
		ArrayList<Log> listaLog = new ArrayList<Log>();
		
		Log log;
		
		Iterator iLog = Repositorio.log.iterator();
		
		while(iLog.hasNext()){
		
			log = (Log)iLog.next();
		
			if(Dispositivo.nombre.equals(log.getNombre())){
				
				listaLog.add(log);
			}
		}
		
		//creo la fecha de inicio para el calculo del consumo ACLARACION: la fechaFin es la actual
		Calendar fechaInicio = Calendar.getInstance();
		
		fechaInicio.setTime(new Date());
		
		fechaInicio.add(Calendar.HOUR, -horas);
		
		//se crea la fecha de comparacion la cual es la obtenida de cada registro del log
		Calendar fechaComparacion = Calendar.getInstance();
		
		for(int i=0; i<=listaLog.size()-1; i++){
			
			log = listaLog.get(i);
			
			fechaComparacion.setTime(log.getFecha());

			if((fechaInicio.getTimeInMillis() <= fechaComparacion.getTimeInMillis())){
				
				//obtengo la fecha siguiente para asi saber con la resta de las fechas la cantidad de horas que estuvo
				//en cada estado.
				Calendar fechaSiguiente = Calendar.getInstance();
								
				if(i+1 < listaLog.size()){

					Log logSiguiente = listaLog.get(i+1);
					
					fechaSiguiente.setTime(logSiguiente.getFecha());
					
					long dif = fechaSiguiente.getTimeInMillis() - fechaComparacion.getTimeInMillis();
					
					//paso de milisegundos a horas
					dif = dif/(1000*60*60);
					
					consumoTotal = consumoTotal + this.consumoInteligente(log.getEstado(), dif);
				}
				
				//sino se resta con la fecha actual ya que estamos en el ultimo registro del log, y no hay un siguiente
				//para comparar
				Calendar fechaActual = Calendar.getInstance();
				
				fechaActual.setTime(new Date());
				
				long dif = fechaActual.getTimeInMillis() - fechaComparacion.getTimeInMillis();
				
				dif = dif/(1000*60*60);
				
				consumoTotal = consumoTotal + this.consumoInteligente(log.getEstado(), dif);
				
			}
		}	
		return consumoTotal;
	}
	
	public double consumoPeriodo(String fecha1, String fecha2){
		
		double consumoTotal = 0;
	
		Calendar fechaInicio = Calendar.getInstance();
		
		Calendar fechaFin = Calendar.getInstance();
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		try {
			
			fechaInicio.setTime(formato.parse(fecha1));
			fechaFin.setTime(formato.parse(fecha2));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//filtro la lista con el dispositivo deseado		
		ArrayList<Log> listaLog = new ArrayList<Log>();
		
		Log log;
		
		Iterator iLog = Repositorio.log.iterator();
		
		while(iLog.hasNext()){
		
			log = (Log)iLog.next();
		
			if(Dispositivo.nombre.equals(log.getNombre())){
				
				listaLog.add(log);
			}
		}
		
		Calendar fechaComparacion = Calendar.getInstance();
		
		for(int i=0; i<=listaLog.size()-1; i++){
			
			log = listaLog.get(i);
			
			fechaComparacion.setTime(log.getFecha());
			
			//pregunto si la fecha de comparacion esta entre la fecha de inicio y la de fin
			if(fechaInicio.getTimeInMillis() <= fechaComparacion.getTimeInMillis()
					&& fechaComparacion.getTimeInMillis() <= fechaFin.getTimeInMillis()){
					
				long dif = fechaComparacion.getTimeInMillis() - fechaInicio.getTimeInMillis();
					
				dif = dif/(1000*60*60);
					
				String estadoAnterior = listaLog.get(i-1).getEstado();
					
				fechaInicio.setTime(log.getFecha());;
					
				consumoTotal = consumoTotal + this.consumoInteligente(estadoAnterior, dif);
				
			}  //pregunto si la fecha fin es menor que la fecha de comparacion para asi poder cambiar la condicion de calculo
				else{ if(fechaComparacion.getTimeInMillis() > fechaFin.getTimeInMillis()){
				
						fechaInicio.setTime(listaLog.get(i-1).getFecha());
						
						long dif = fechaFin.getTimeInMillis() - fechaInicio.getTimeInMillis();
						
						dif = dif/(1000*60*60);
						
						String estadoAnterior = listaLog.get(i-1).getEstado();
						
						consumoTotal = consumoTotal + this.consumoInteligente(estadoAnterior, dif);
						
						break;
				}
			}	
			
			
			//pregunto si es el ultimo y queda un rezago de horas 
			if(i == listaLog.size()-1 && fechaComparacion.getTimeInMillis() < fechaFin.getTimeInMillis()){
				
				long dif = fechaFin.getTimeInMillis() - fechaComparacion.getTimeInMillis();
				
				dif = dif/(1000*60*60);
				
				consumoTotal = consumoTotal + this.consumoInteligente(log.getEstado(), dif);
				
			}		
		}
			
	return consumoTotal;
	}
}