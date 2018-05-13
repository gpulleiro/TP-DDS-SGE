package TP_DDS_SGE.TP;

import java.util.ArrayList;

import java.util.Calendar;

public class Cliente extends Usuario {

	private String tipoDocumento;
	private int numeroDocumento;
	private int telefono;
	private Categoria categoria;
	private ArrayList <Dispositivo> dispositivos;

	//constructor
	
	public Cliente(String nombre, String apellido, String domicilio, Calendar fechaAlta, String usuario, String contrasenia,
			String tipoDocumento, int numeroDocumento, int telefono, Categoria categoria,
			ArrayList<Dispositivo> dispositivo){
		
		super(nombre, apellido, domicilio, fechaAlta, usuario, contrasenia);
		
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.telefono = telefono;
		this.categoria = categoria;
		this.dispositivos = dispositivo;
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
	
	//metodos
	
	//preguntar si alguno de sus dispositivos esta encendido quiere decir si alguno
	//de la lista esta encendido.. o algun objeto en particular de la lista ??
	
	public boolean algunDispositivoEncendido(){
		boolean estado = false;
		for (Dispositivo obj: dispositivos){
			if(obj.isEstado() == true){
				estado = true;
				break;
			}
		}
		return estado;
	}
	
	public boolean algunDispositivoEncendido2(){
	
		return (this.dispositivos.stream().anyMatch(dispositivo->dispositivo.isEstado())); 
	}
	
	//cantidad de dispositivos encendidos
	public int cantDispositivosEncendidos(){
		int contador = 0;
		for (Dispositivo obj : dispositivos){
			if(obj.isEstado()== true){
				contador++;	
			}
		}
		return contador;
	}
	
	public long cantDispositivosEncendidos2(){
		
		return ((this.dispositivos.stream().filter(dispositivo->dispositivo.isEstado()).count()));
		}
	
	//cantidad de dispositivos apagados 
	public int cantDispositivosApagados(){
		int contador = 0;
		for (Dispositivo obj : dispositivos){
			if(obj.isEstado()== false){
				contador++;	
			}
		}
		return contador;
	}
	
	public long cantDispositivosApagados2(){
		
		return ((this.dispositivos.stream().filter(dispositivo->!(dispositivo.isEstado())).count()));
	}
	
	//cantidad de dispositivos
	public int cantDispositivos(){
		return dispositivos.size();
	}
}
