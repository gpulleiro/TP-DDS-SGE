package TP_DDS_SGE.TP;

public interface Tipo {
	
	//public abstract float consumo();
	
	public abstract boolean estasEncendido();
	
	public abstract boolean estasApagado();
	
	public abstract boolean estasAhorro();
	
	public abstract void encender();
		
	public abstract void apagar();
	
	public abstract void ahorro();
	
	// opcion 2
	
	public abstract void cambiarEstado(String estado);
}
