package TP_DDS_SGE.TP;

public class Dispositivo {

	private String nombre;
	private Tipo tipo;
	
	//constructor
	
	public Dispositivo(String nombre, int consumo, Estado estado, Tipo tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}

	//getters-setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	//metodos
		
}
