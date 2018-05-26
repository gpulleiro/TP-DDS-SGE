package TP_DDS_SGE.TP;

public class Estandar implements Tipo {
	
	private int cantHoras;
	
	//constructor
	public Estandar(int cantHoras) {
		super();
		this.cantHoras = cantHoras;
	}

	//getters and setters
	public int getCantHoras() {
		return cantHoras;
	}
	
	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}
	
	//metodos
	
//	@Override
//	public float consumo() {
//		// TODO Auto-generated method stub
//		return 0;
//	}

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

}
