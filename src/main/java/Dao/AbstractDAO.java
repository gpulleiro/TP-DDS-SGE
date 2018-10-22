package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public abstract class AbstractDAO {
	
	static EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
	
	static EntityTransaction transaccion = entityManager.getTransaction();
	
	
	public static void agregar(Object objeto) {

		transaccion.begin();
		
		entityManager.persist(objeto);
		
		transaccion.commit();
		
	}
	
	
	public static void agregar(List<Object> objetos) {
		
		for (int i = 0; i < objetos.size(); i++) {
			agregar(objetos.get(i));
		}
		
	}
	
	public static Object buscarPorId(Object objeto, long id) {

		Object obj = entityManager.find(objeto.getClass(), id);
		
		return obj;
	}
	
	
	public static void borrarPorId(Object objeto, long id) {
		
		Object obj = buscarPorId(objeto,id);
		
		transaccion.begin();
		entityManager.remove(obj);
		transaccion.commit();
	}
	
	public static void borrar(Object objeto) {
		
		transaccion.begin();
		entityManager.remove(objeto);
		transaccion.commit();
		
	}
	
	public static void actualizar(Object objeto) {
		
		transaccion.begin();
		entityManager.merge(objeto);
		transaccion.commit();
	}
	
}