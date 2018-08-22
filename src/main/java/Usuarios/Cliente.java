package Usuarios;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import Dispositivo.Dispositivo;
import Dispositivo.Inteligente;
import Repositorio.Repositorio;
import TipoDato.Coordenadas;

public class Cliente extends Usuario {

	private String tipoDocumento;
	private int numeroDocumento;
	private int telefono;
	private Categoria categoria;
	private ArrayList <Dispositivo> dispositivos;
	private int puntos;
	private Coordenadas coordenadas;
	
	//constructor
	
	public Cliente(String nombre, String apellido, String domicilio, String fechaAlta, String usuario,
			String contrasenia, String tipoDocumento, int numeroDocumento, int telefono, Categoria categoria,
			ArrayList<Dispositivo> dispositivos, int puntos) {
		
		super(nombre, apellido, domicilio, fechaAlta, usuario, contrasenia);
		
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.telefono = telefono;
		this.categoria = categoria;
		this.dispositivos = dispositivos;
		this.puntos = puntos;
	}

	public Cliente() {
		super();
	}
	
	public Cliente(ArrayList<Dispositivo> dispositivos2) {
		// TODO Auto-generated constructor stub
	}


	//getters-setters
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Coordenadas getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenadas coordenadas) {
		this.coordenadas = coordenadas;
	}

	public Object getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ArrayList<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(ArrayList<Dispositivo> dispositivo) {
		this.dispositivos = dispositivo;
	} 
	
	public void aniadirDispositivo(Dispositivo unDispositivo) {
		this.dispositivos.add(unDispositivo);
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	//metodos
	
	public boolean algunDispositivoEncendido(){
		boolean estado = false;
		for (Dispositivo obj: dispositivos){
			if(obj.getEstado() == "encendido"){
				estado = true;
				break;
			}
		}
		return estado;
	}
	
	//cantidad de dispositivos encendidos
	public int cantDispositivosEncendidos(){
		int contador = 0;
		for (Dispositivo obj : dispositivos){
			if(obj.getEstado() == "encendido"){
				contador++;	
			}
		}
		return contador;
	}
	
	//cantidad de dispositivos apagados 
	public int cantDispositivosApagados(){
		int contador = 0;
		for (Dispositivo obj : dispositivos){
			if(obj.getEstado() == "apagado"){
				contador++;	
			}
		}
		return contador;
	}	
	//cantidad de dispositivos
	public int cantDispositivos(){
		
		return dispositivos.size();
	
	}

	//convertir un dispositivo a inteligente
	public void convertirDispositivo(Dispositivo dis) {
		
		dis.setTipo(new Inteligente("apagado"));
		
		this.puntos = this.getPuntos() + 10;
	}

	//registrar un dispositivo inteligente
	
	public void registrarDispositivo(String nombre, float consumo) throws IOException{
		
		boolean existe = false;
		
		Dispositivo dis;
				
		Iterator iterDis = Repositorio.getInstance().getClientes().iterator();
		
		//me fijo si existe el dispositivo en la lista de dispositivos para no agregar uno que ya exista
		while(iterDis.hasNext()){

			dis = (Dispositivo)iterDis.next();
				
			if(dis.getNombre() == nombre && dis.getConsumoFijo() == consumo){
				
				System.out.println("este dispositivo ya esta registrado");
				
				existe = true;
				
				break;
				
			}		
		}
		
		if (existe = false){ 
		
			Dispositivo dispositivoNuevo = new Dispositivo(nombre,consumo,new Inteligente("apagado"));
			
			Repositorio.getInstance().getDispositivos().add(dispositivoNuevo);
			
			this.puntos = this.puntos + 15;
		}	
	}
	
	public double consumo(String fecha) throws ParseException{
		
		double consumoTotal = 0;
		
		Calendar fechaActual = Calendar.getInstance();
		Calendar fechaInicio = Calendar.getInstance();
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		fechaInicio.setTime(formato.parse(fecha));
			
		fechaActual.setTime(new Date());
		
		long dif = fechaActual.getTimeInMillis() - fechaInicio.getTimeInMillis();
		
		//diferencia en dias 
		dif = dif/(1000*60*60*24);
		
		String fechaFin = fechaActual.toString();
		
		for (Dispositivo obj: dispositivos){
			
			if(obj.getTipo().obtenerFlag().equals("I")){
				
				consumoTotal = consumoTotal + obj.consumoPeriodo(fecha, fechaFin);
			} if (obj.getTipo().obtenerFlag().equals("E")){
				
				consumoTotal = consumoTotal + (obj.consumo()*dif);
			}
		}
		
		return consumoTotal;
	}
}

