package main;

public class Dispositivo {

	private String nombre;
	private int consumo;
	private boolean estado;

	//constructor
	
	public Dispositivo(String nombre, int consumo, boolean estado) {
		this.nombre = nombre;
		this.consumo = consumo;
		this.estado = estado;
	}

	//getters-setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getConsumo() {
		return consumo;
	}

	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	//metodos
		
}
