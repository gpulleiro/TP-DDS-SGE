package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import TipoDato.Log;

public class LogDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Log> obtenerLogs(String nombre, int mes, String estado) throws Exception {
		
		return entityManager.createQuery("from Repositorio.Log where month(fecha) = :mes and nombre = :nombre and estado = :estado" ).setParameter("mes", mes).setParameter("nombre", nombre).setParameter("estado", estado).getResultList();
	}
	
	public Log obtenerLogPorId(long id) throws Exception {

		return (Log) entityManager.createQuery("from TipoDato.Log where id = :id").setParameter("id", id).getSingleResult();

	}
	
	@SuppressWarnings("unchecked")
	public List<Log> obtenerLogsPorMes(int mes, long id_dispositivo, long id_cliente) throws Exception {
		
		return entityManager.createQuery("from TipoDato.Log where month(fecha) = :mes and id_dispositivo = :id_dispositivo and id_cliente = :id_cliente" ).setParameter("mes", mes).setParameter("id_dispositivo", id_dispositivo).setParameter("id_cliente", id_cliente).getResultList();
	} 
	
}
