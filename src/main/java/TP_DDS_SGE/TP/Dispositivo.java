package TP_DDS_SGE.TP;

public class Dispositivo {

	private String nombre;
	private float consumoFijo;
	private Tipo tipo;
	
	//constructor
	
	public Dispositivo(String nombre, float consumoFijo, Tipo tipo) {
		super();
		this.nombre = nombre;
		this.consumoFijo = consumoFijo;
		this.tipo = tipo;
	}
	
	//getters-setters

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getConsumoFijo() {
		return consumoFijo;
	}

	public void setConsumoFijo(float consumoFijo) {
		this.consumoFijo = consumoFijo;
	}
	
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	//metodos
	public float consumo(){
		
	return consumo();
	
	};
}
