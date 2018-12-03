package Dispositivo;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import Repositorio.Repositorio;
import TipoDato.Log;

import javax.persistence.*;

import Observer.Observer;
import Observer.Regla;
import Observer.Sensor;

@Entity
@DiscriminatorValue(value = "INT")
public class Inteligente extends Dispositivo {
	
	@Column(name="ESTADO")
	private String estado;
	
	@Transient
	private double consumoUltimoMes = 0;
	
//	@ManyToOne(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
//	private Sensor sensor;
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	private List<Regla> reglas = new ArrayList<Regla>();
	
	//constructor	
	public Inteligente(String nombre, double consumoFijo, double minimoHoras, double maximoHoras, String estado) {
		super(nombre, consumoFijo, minimoHoras, maximoHoras);
		this.estado = estado;
	}
	
	
	
	
	public Inteligente() {}
		
	//setters and getters
	
	public double getConsumoUltimoMes() {
		return consumoUltimoMes;
	}
	
	public void setConsumoUltimoMes(long consumoUltimoMes) {
		this.consumoUltimoMes =  consumoUltimoMes;
	}
	
	
	public String getEstado() {
		return estado;
	}
	
//	public Sensor getSensor() {
//		return sensor;
//	}
//
//
//	public void setSensor(Sensor sensor) {
//		this.sensor = sensor;
//	}


	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int getCantHoras() {
		System.out.println("los dispositivos inteligentes no poseen una cantidad de horas fijas de consumo");
		return 0;
	}
	
	
	//metodos
	public boolean estasEncendido() {

		boolean encendido = false;
		
		if(this.getEstado() == "encendido"){
			
			encendido = true; 
		}
		
		return encendido;
	}

	
	public boolean estasApagado() {
		
		boolean apagado = false;
		
		if(this.getEstado() == "apagado"){
			
			apagado = true; 
		}
		
		return apagado;	
	}


	public boolean estasAhorro() {
	
		boolean ahorro = false;
		
		if(this.getEstado() == "ahorro"){
			
			ahorro = true; 
		}
		
		return ahorro;		
	}
	
	public void notificar() throws IOException {
		for(Regla regla:reglas) {regla.update();}
	}

	public void encender() throws IOException {
		
		if(this.getEstado() == "encendido") {}
			else{
			this.setEstado("encendido");
		}
		this.notificar();
//		this.getSensor().realizarMedicion();
	}

	public void apagar() throws IOException {
		
		if(this.getEstado() == "apagado"){}
			else{
			this.setEstado("apagado");
		}
		this.notificar();
//		this.getSensor().realizarMedicion();
	}

	public void ahorro() {
		
		if(this.getEstado() == "ahorro"){}
			else{
			this.setEstado("ahorro");
		}
	}

	public void cambiarEstado(String estado) {
		
		if(this.getEstado() == estado){}
		else{
			this.setEstado(estado);
		}	
	}
	
	public double consumoInteligente(double consumoFijo, String estado, long horas){

		double consumoTotal = 0;
		
		switch(estado){
			
		case "encendido":
			
			consumoTotal = consumoFijo * horas;
		
			break;
			
		case "apagado": 
			
			consumoTotal = 0;
			
			break;
			
		case "ahorro":
			
			consumoTotal = (consumoFijo * horas) * 0.5;
			
			break;
			
		}
		
			return consumoTotal;
	
	}
	
	@Override
	public double consumo(){
		
		System.out.println("este dispositivo es inteligente, debe especificar el consumo en un determinado rango horario o una cantidad de horas hacia atras");
		
		return 0;
	}
	
	
	public double consumoUltimasHoras(int horas){

		double consumoTotal = 0;
		
		//filtro la lista con el dispositivo deseado
		
		ArrayList<Log> listaLog = new ArrayList<Log>();
		
		Log log;
		
		Iterator iLog = Repositorio.getInstance().getLog().iterator();
		
		while(iLog.hasNext()){
		
			log = (Log)iLog.next();
		
			if(this.getNombre().equals(log.getNombre())){
				
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
					
					consumoTotal = consumoTotal + this.consumoInteligente(this.getConsumoFijo(), log.getEstado(), dif);
				}
				
				//sino se resta con la fecha actual ya que estamos en el ultimo registro del log, y no hay un siguiente
				//para comparar
				Calendar fechaActual = Calendar.getInstance();
				
				fechaActual.setTime(new Date());
				
				long dif = fechaActual.getTimeInMillis() - fechaInicio.getTimeInMillis();
				
				dif = dif/(1000*60*60);
				
				consumoTotal = consumoTotal + this.consumoInteligente(this.getConsumoFijo(),log.getEstado(), dif);
				
			}
			else{if(i == listaLog.size()-1){
				
				Calendar fechaActual = Calendar.getInstance();
				
				fechaActual.setTime(new Date());
				
				long dif = fechaActual.getTimeInMillis() - fechaInicio.getTimeInMillis();
				
				dif = dif/(1000*60*60);
				
				consumoTotal = consumoTotal + this.consumoInteligente(this.getConsumoFijo(),log.getEstado(), dif);
				
				}
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
		
		Iterator iLog = Repositorio.getInstance().getLog().iterator();
		
		while(iLog.hasNext()){
		
			log = (Log)iLog.next();
		
			if(this.getNombre().equals(log.getNombre())){
				
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
					
				consumoTotal = consumoTotal + this.consumoInteligente(this.getConsumoFijo(), estadoAnterior, dif);
				
			}  //pregunto si la fecha fin es menor que la fecha de comparacion para asi poder cambiar la condicion de calculo
				else{ if(fechaComparacion.getTimeInMillis() > fechaFin.getTimeInMillis()){
				
						fechaInicio.setTime(listaLog.get(i-1).getFecha());
						
						long dif = fechaFin.getTimeInMillis() - fechaInicio.getTimeInMillis();
						
						dif = dif/(1000*60*60);
						
						String estadoAnterior = listaLog.get(i-1).getEstado();
						
						consumoTotal = consumoTotal + this.consumoInteligente(this.getConsumoFijo(), estadoAnterior, dif);
						
						break;
				}
			}	
			
			
			//pregunto si es el ultimo y queda un rezago de horas 
			if(i == listaLog.size()-1 && fechaComparacion.getTimeInMillis() < fechaFin.getTimeInMillis()){
				
				long dif = fechaFin.getTimeInMillis() - fechaComparacion.getTimeInMillis();
				
				dif = dif/(1000*60*60);
				
				consumoTotal = consumoTotal + this.consumoInteligente(this.getConsumoFijo(), log.getEstado(), dif);
				
			}		
		}
			
	return consumoTotal;
	}
 	

 	
 	public void agregarObservador(Regla obs) {reglas.add(obs);};

	public String obtenerFlag() {
		return "I";
	}
	
	public String esInteligente() {
		
		return "SI";
	}
	
	public boolean esInteligente2() {
		
		return true;
	}




	public List<Regla> getReglas() {
		return reglas;
	}




	public void setReglas(List<Regla> reglas) {
		this.reglas = reglas;
	}
	
	public void obtenerCantidadDeHorasEnUnMes(List<Log> listaLog) {

		Date fecha1 = null;
		long cantidadHoras = 0;
				
		for (int i = 0; i < listaLog.size(); i = i+2) {
			
			if(("encendido").equals(listaLog.get(i).getEstado()) ) {
				fecha1 = listaLog.get(i).getFecha();
				
				if(listaLog.size() - 1 > listaLog.indexOf(listaLog.get(i))) {					
						
					cantidadHoras += DiferenciaDeHorasEntreFechas(fecha1, listaLog.get(i+1).getFecha());
					
				}
				else {
					cantidadHoras += DiferenciaDeHorasEntreFechas(fecha1,new Date());
				}
				
			}
		}
		this.setCantidadHorasEncendido(cantidadHoras);
	}
	
	public void obtenerCantidadDeHorasUltimoMes(List<Log> listaLog) throws ParseException {

		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		long cantidadHoras = 0;
		
		if(listaLog.size() == 0) {
			this.setCantidadHorasEncendido(cantidadHoras);
		}
		if(listaLog.size() > 0) {
			String strFecha = (listaLog.get(0).getFecha().getYear() + 1900) + "-" + (listaLog.get(0).getFecha().getMonth() + 1) + "-30 23:59:59";			
			Date fecha1 = null;
			Date fecha2 = null;
			
			for (int i = 0; i < listaLog.size(); i = i+2) {
				
				if(("encendido").equals(listaLog.get(i).getEstado()) ) {
					fecha1 = listaLog.get(i).getFecha();
					
					if(listaLog.size() - 1 > listaLog.indexOf(listaLog.get(i))) {					
						
						cantidadHoras += DiferenciaDeHorasEntreFechas(fecha1, listaLog.get(i+1).getFecha());
						
					}
					else {
						fecha2 = formatoDelTexto.parse(strFecha);
						cantidadHoras += DiferenciaDeHorasEntreFechas(fecha1,fecha2);
					}
					
				}
			}
			this.setCantidadHorasEncendido(cantidadHoras);
		}
	}
	
	public static long DiferenciaDeHorasEntreFechas(Date dinicio, Date dfinal){
		 
        long milis1, milis2, diff;
     
        //INSTANCIA DEL CALENDARIO GREGORIANO
        Calendar cinicio = Calendar.getInstance();
        Calendar cfinal = Calendar.getInstance();

        //ESTABLECEMOS LA FECHA DEL CALENDARIO CON EL DATE GENERADO ANTERIORMENTE
         cinicio.setTime(dinicio);
         cfinal.setTime(dfinal);


         milis1 = cinicio.getTimeInMillis();

         milis2 = cfinal.getTimeInMillis();


         diff = milis2-milis1;



 // 	calcular la diferencia en horas

         long diffHoras =   (diff / (60 * 60 * 1000)); 
 
         return diffHoras;
	}
	
	
	public void consumoUltimoMesPorHoras(long horasEncendido) {
		
		
		consumoUltimoMes = horasEncendido * consumoFijo;
		
	}
}