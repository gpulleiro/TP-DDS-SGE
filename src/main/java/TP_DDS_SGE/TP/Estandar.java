package TP_DDS_SGE.TP;

public class Estandar extends Tipo {
	
	private float consumoFijo;
	private int cantHoras;
	
	
	//constructor
	
	public Estandar(float consumoFijo, int cantHoras) {
		super();
		this.consumoFijo = consumoFijo;
		this.cantHoras = cantHoras;
	}

	
	//Getters and Setters
	
	public float getConsumoFijo() {
		return consumoFijo;
	}


	public void setConsumoFijo(float consumoFijo) {
		this.consumoFijo = consumoFijo;
	}


	public int getCantHoras() {
		return cantHoras;
	}


	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}

	//Metodos
	
}
