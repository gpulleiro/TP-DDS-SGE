package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import Dispositivo.Dispositivo;
import Observer.Regla;

public class ReglaDAO extends AbstractDAO {
	
	public Regla obtenerRegla (String nombre){ 
		
		return (Regla) entityManager.createQuery("from Observer.Regla where nombre = :nombre").setParameter("nombre", nombre).getSingleResult();
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Regla> obtenerReglas(){
		
		return entityManager.createQuery("FROM Observer.Regla").getResultList();
		
	}
	
	public Regla obtenerReglaPorId(long id) {

		return (Regla) entityManager.createQuery("from Observer.Regla where id = :id").setParameter("id", id).getSingleResult();

	}
}
