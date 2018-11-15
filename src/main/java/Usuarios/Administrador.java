package Usuarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import Dao.DispositivoDAO;
import Dao.LogDAO;
import Dispositivo.Dispositivo;
import TipoDato.Log;

@Entity
@DiscriminatorValue(value = "ADMIN")
public class Administrador extends Usuario {

	//constructor
	
	public Administrador(String nombre, String apellido, String domicilio, String fechaAlta, String usuario,
			String contrasenia) {
		super(nombre, apellido, domicilio, fechaAlta, usuario, contrasenia);
			}

	public Administrador() {}
	
	//getters-setters
	
	
	//metodos
	
	//cantidad de meses
	public long cantidadMeses() throws ParseException{
		
		Calendar fechaInicio = Calendar.getInstance();
		Calendar hoy = Calendar.getInstance();
		hoy.setTime(new Date());
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		fechaInicio.setTime(formato.parse(this.fechaAlta));
		long meses = (hoy.getTimeInMillis() - fechaInicio.getTimeInMillis());
		meses = meses/(1000*60*60);
		
		return meses;
	}

	@Override
	public String toString() {
		return "Administrador [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio
				+ ", fechaAlta=" + fechaAlta + ", usuario=" + usuario + ", contrasenia=" + contrasenia + "]";
	}
	
	public void registrarDispositivo(Dispositivo dis) {
		
		
		DispositivoDAO disDAO = new DispositivoDAO();
		
		disDAO.registrarDispositivo(dis);
		
	}
	
	public Dispositivo obtenerDispositivo (String nombre){
		
		DispositivoDAO disDAO = new DispositivoDAO();
		
		Dispositivo dis = disDAO.obtenerDispositivo(nombre);
		
		
		return dis;
		
	}

	public List<Log> obtenerLogs(String nombre, int mes, String estado) {
		
		LogDAO logDAO = new LogDAO();
		
		List<Log> lista = logDAO.obtenerLogs(nombre,mes,estado);
		
		return lista;
	}
	
	public boolean esAdmin() {
		
		return true;
	}
}

