package Usuarios;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


import Dispositivo.Dispositivo;
import Dispositivo.Inteligente;
import Repositorio.Repositorio;
import Simplex.SimplexMaximizacionAdapter;
import TipoDato.Coordenadas;

@Entity
@DiscriminatorValue(value="CLIENTE")
public class Cliente extends Usuario {

	@Column(name="TIPO_DOC")
	private String tipoDocumento;
	
	@Column(name="NUM_DOC")
	private int numeroDocumento;
	
	@Column(name="TELEFONO")
	private int telefono;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Categoria categoria;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List <Dispositivo> dispositivos = new ArrayList<Dispositivo>();
	
	@Column(name="PUNTOS")
	private int puntos;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Coordenadas coordenadas;
	
	//constructor
	
	public Cliente(String nombre, String apellido, String domicilio, String fechaAlta, String usuario,
			String contrasenia, String tipoDocumento, int numeroDocumento, int telefono, Categoria categoria, int puntos) {
		
		super(nombre, apellido, domicilio, fechaAlta, usuario, contrasenia);
		
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.telefono = telefono;
		this.categoria = categoria;
		this.puntos = puntos;
	}

	public Cliente(String nombre, String apellido, String domicilio, String fechaAlta, String usuario,
			String contrasenia, String tipoDocumento, int numeroDocumento, int telefono, int puntos) {
		
		super(nombre, apellido, domicilio, fechaAlta, usuario, contrasenia);
		
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.telefono = telefono;
		this.puntos = puntos;
	}
	
	public Cliente() {
		super();
		this.dispositivos = new ArrayList<Dispositivo>();
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

	public List<Dispositivo> getDispositivos() {
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
	public Inteligente convertirDispositivo(Dispositivo dis) {
		
		Inteligente convertido = new Inteligente(dis.getNombre(),dis.getConsumoFijo(),dis.getMinimoHoras(),dis.getMaximoHoras(),"apagado");
		
		this.puntos = this.getPuntos() + 10;
	
		return convertido;
	}

	//registrar un dispositivo inteligente
	
	public void registrarDispositivo(String nombre, double consumo, double min, double max) throws IOException{
		
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
		
			Inteligente dispositivoNuevo = new Inteligente(nombre, consumo, min, max, "apagado");
			
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
			
			if(obj.obtenerFlag().equals("I")){
				
				consumoTotal = consumoTotal + obj.consumoPeriodo(fecha, fechaFin);
			} if (obj.obtenerFlag().equals("E")){
				
				consumoTotal = consumoTotal + (obj.consumo()*dif);
			}
		}
		
		return consumoTotal;
	}
	

	public void mejorCombinacionDispositivos(){
		//se crea instancia del simplexMaximacion y se le delega la responsabilidad del calculo
		SimplexMaximizacionAdapter simplex = new SimplexMaximizacionAdapter();
		simplex.realizarCombinacionMaximizacion(this.getDispositivos());
	}

	@Override
	public String toString() {
		return "Cliente [tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", telefono="
				+ telefono + ", categoria=" + categoria + ", dispositivos=" + dispositivos + ", puntos=" + puntos
				+ ", coordenadas=" + coordenadas + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio="
				+ domicilio + ", fechaAlta=" + fechaAlta + ", usuario=" + usuario + ", contrasenia=" + contrasenia
				+ "]";
	}
	
	
	
}

