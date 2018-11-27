package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import Acciones.Actuador;
import Dispositivo.Dispositivo;
import Observer.Regla;

public class ReglaDAO extends AbstractDAO {
	
	public Regla obtenerRegla (String nombre) throws Exception { 
		
		return (Regla) entityManager.createQuery("from Observer.Regla where nombre = :nombre").setParameter("nombre", nombre).getSingleResult();
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Regla> obtenerReglas() throws Exception {
		
		return entityManager.createQuery("FROM Observer.Regla").getResultList();
		
	}
	
	public Regla obtenerReglaPorId(long id) throws Exception {

		return (Regla) entityManager.createQuery("from Observer.Regla where id = :id").setParameter("id", id).getSingleResult();

	}
	
	@SuppressWarnings("unchecked")
	public List<Actuador> obtenerActuadores() throws Exception {
		
		return (List<Actuador>) entityManager.createQuery("from Acciones.Actuador").getResultList();
		
	}
	
	public Actuador obtenerActuador(long id) throws Exception {
		
		return (Actuador) entityManager.createQuery("from Acciones.Actuador where id = :id").setParameter("id", id).getSingleResult();
		
	}
}
