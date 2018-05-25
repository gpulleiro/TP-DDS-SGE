package TP_DDS_SGE.TP;

public class Estandar extends Tipo {
	
	private int cantHoras;
	
	
	//constructor
	
	public Estandar(String nombre, float consumoFijo, int cantHoras) {
		super(nombre, consumoFijo);
		this.cantHoras = cantHoras;
	}

	//Getters and Setters

	public int getCantHoras() {
		return cantHoras;
	}


	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}

	//Metodos
	public float consumo(){
		
		float consumoTotal = (this.getConsumoFijo() * this.getCantHoras());
		
		return consumoTotal;
	}
}
