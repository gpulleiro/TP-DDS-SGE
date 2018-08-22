package TipoDato;

public class Coordenadas {
	
	private double latitud;
	private double longitud;
	
	//constructor
	public Coordenadas(double latitud, double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	
	//getters and setters
	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	
	

}
