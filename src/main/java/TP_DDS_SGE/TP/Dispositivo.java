package TP_DDS_SGE.TP;

public class Dispositivo {

	private Tipo tipo;
	
	//constructor
	
	public Dispositivo(Tipo tipo) {
		super();
		this.tipo = tipo;
	}
	
	//getters-setters
	
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	//metodos
}
