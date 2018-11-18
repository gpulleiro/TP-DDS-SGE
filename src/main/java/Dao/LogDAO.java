package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import TipoDato.Log;

public class LogDAO extends AbstractDAO {

	EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
	
	EntityTransaction transaccion = entityManager.getTransaction();
	
	public void registrarLog(Log log) {
		entityManager.persist(log);
	}

	@SuppressWarnings("unchecked")
	public List<Log> obtenerLogs(String nombre, int mes, String estado) {
		
		return entityManager.createQuery("from Repositorio.Log where month(fecha) = :mes and nombre = :nombre and estado = :estado" ).setParameter("mes", mes).setParameter("nombre", nombre).setParameter("estado", estado).getResultList();
	}
}
