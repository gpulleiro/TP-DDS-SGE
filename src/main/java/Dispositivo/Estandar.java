package Dispositivo;

public class Estandar implements Tipo {
	
	private int cantHoras;
	
	//constructor
	public Estandar(int cantHoras) {
		super();
		this.cantHoras = cantHoras;
	}

	//getters and setters
	@Override
	public int getCantHoras() {
		return cantHoras;
	}
	
	@Override
	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}
	
	@Override
	public String getEstado() {
		
		System.out.println("los dispositivos estandar no poseen estado");
		
		return "";
	}
	
	@Override
	public void setEstado(String estado) {
		
	}
	
	//metodos
	
	@Override
	public float consumo(float consumoFijo) {
		
		float consumo = consumoFijo * this.getCantHoras();
		
		return consumo;
	}

	@SuppressWarnings("null")
	@Override
	public boolean estasEncendido() {
		
		System.out.println("este dispositivo es estandar, no puede saber su estado");
		
		return (Boolean) null;
	}
	@SuppressWarnings("null")
	@Override
	public boolean estasApagado() {
		
		System.out.println("este dispositivo es estandar, no puede saber su estado");
		
		return (Boolean) null;
	}
	
	@SuppressWarnings("null")
	@Override
	public boolean estasAhorro() {
		
		System.out.println("este dispositivo es estandar, no puede saber su estado");
		
		return (Boolean) null;
	}

	@Override
	public void encender() {
		
		System.out.println("este dispositivo es estandar, no se puede encender");		
	}

	@Override
	public void apagar() {
		
		System.out.println("este dispositivo es estandar, no se puede apagar");
	}

	@Override
	public void ahorro() {
		
		System.out.println("este dispositivo es estandar, no se puede poner en modo ahorro");
	}

	@Override
	public void cambiarEstado(String estado) {
		
		System.out.println("este dispositivo es estandar, no puede cambiar de estado");
	}

	@Override
	public double consumoUltimasHoras(Dispositivo unDispo, int horas) {
		System.out.println("este dispositivo es estandar, no puede obtener el consumo en las ultimas horas");
		return 0;
	}

	@Override
	public double consumoPeriodo(Dispositivo unDispo, String fecha1, String fecha2) {
		System.out.println("este dispositivo es estandar, no puede obtener el consumo en el periodo solicitado");
		return 0;
	}

	@Override
	public String obtenerFlag() {
		// TODO Auto-generated method stub
		return "E";
	}

}
