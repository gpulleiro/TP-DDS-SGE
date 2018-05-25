package TP_DDS_SGE.TP;

public class Estandar extends Dispositivo {
	
	private int cantHoras;
	
	
	//constructor
	
	public Estandar(String nombre, char tipo, float consumoFijo, int cantHoras) {
		super(nombre, consumoFijo, tipo);
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
