package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import TipoDato.Log;

public class LogDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Log> obtenerLogs(String nombre, int mes, String estado) {
		
		return entityManager.createQuery("from Repositorio.Log where month(fecha) = :mes and nombre = :nombre and estado = :estado" ).setParameter("mes", mes).setParameter("nombre", nombre).setParameter("estado", estado).getResultList();
	}
	
	public Log obtenerLogPorId(long id) {

		return (Log) entityManager.createQuery("from TipoDato.Log where id = :id").setParameter("id", id).getSingleResult();

	}
}
