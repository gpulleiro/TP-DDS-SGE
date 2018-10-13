package Observer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class ReglaDAO implements WithGlobalEntityManager {
	
	EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
	EntityTransaction transaccion = entityManager.getTransaction();

	public void ingresarRegla(Regla regla){
		
		transaccion.begin();
		entityManager().persist(regla);
		transaccion.commit();
	}
	
	public Regla obtenerRegla (String nombre){ 
		
		return (Regla) entityManager().createQuery("from Observer.Regla where nombre = :nombre").setParameter("nombre", nombre).getSingleResult();
		
	}
}
