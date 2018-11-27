package Reportes;

public class Reporte1 {

	private int id_usuario;
	private String nombre_usuario;
	private String apellido_usuario;
//	private int id_dispositivo;
//	private String nombre_dispositivo;
	private String fecha;
	private double consumo;
	
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getApellido_usuario() {
		return apellido_usuario;
	}
	public void setApellido_usuario(String apellido_usuario) {
		this.apellido_usuario = apellido_usuario;
	}
//	public int getId_dispositivo() {
//		return id_dispositivo;
//	}
//	public void setId_dispositivo(int id_dispositivo) {
//		this.id_dispositivo = id_dispositivo;
//	}
//	public String getNombre_dispositivo() {
//		return nombre_dispositivo;
//	}
//	public void setNombre_dispositivo(String nombre_dispositivo) {
//		this.nombre_dispositivo = nombre_dispositivo;
//	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getConsumo() {
		return consumo;
	}
	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}
	
	
	
}
