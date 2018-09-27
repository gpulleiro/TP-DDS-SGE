package Dispositivo;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "STD")
public class Estandar extends Dispositivo {
	
	private int cantHoras;
	
	//constructor
	public Estandar(String nombre, double consumoFijo, double minimoHoras, double maximoHoras, int cantHoras) {
		super(nombre, consumoFijo, minimoHoras, maximoHoras);
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
	@Override
	public double consumo() {
		
		double consumo = this.consumoFijo * this.getCantHoras();
		
		return consumo;
	}


//	@SuppressWarnings("null")
//	@Override
//	public boolean estasEncendido() {
//		
//		System.out.println("este dispositivo es estandar, no puede saber su estado");
//		
//		return (Boolean) null;
//	}
//	@SuppressWarnings("null")
//	@Override
//	public boolean estasApagado() {
//		
//		System.out.println("este dispositivo es estandar, no puede saber su estado");
//		
//		return (Boolean) null;
//	}
//	
//	@SuppressWarnings("null")
//	@Override
//	public boolean estasAhorro() {
//		
//		System.out.println("este dispositivo es estandar, no puede saber su estado");
//		
//		return (Boolean) null;
//	}
//
//	@Override
//	public void encender() {
//		
//		System.out.println("este dispositivo es estandar, no se puede encender");		
//	}
//
//	@Override
//	public void apagar() {
//		
//		System.out.println("este dispositivo es estandar, no se puede apagar");
//	}
//
//	@Override
//	public void ahorro() {
//		
//		System.out.println("este dispositivo es estandar, no se puede poner en modo ahorro");
//	}
//
//	@Override
//	public void cambiarEstado(String estado) {
//		
//		System.out.println("este dispositivo es estandar, no puede cambiar de estado");
//	}
//
//	@Override
//	public double consumoUltimasHoras(Dispositivo unDispo, int horas) {
//		System.out.println("este dispositivo es estandar, no puede obtener el consumo en las ultimas horas");
//		return 0;
//	}
//
	@Override
	public double consumoPeriodo(String fecha1, String fecha2) {
		System.out.println("este dispositivo es estandar, no puede obtener el consumo en el periodo solicitado");
		return 0;
	}
	@Override
	public String obtenerFlag() {
		return "E";
	}

	@Override
	public String getEstado() {
		// TODO Auto-generated method stub
		return null;
	}

}
