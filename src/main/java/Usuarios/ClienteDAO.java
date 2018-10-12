package Usuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class ClienteDAO implements WithGlobalEntityManager{
	
	EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
	
	EntityTransaction transaccion = entityManager.getTransaction();
	

	public void registrarCliente(Cliente cliente) {
		
		transaccion.begin();
		entityManager.persist(cliente);
		transaccion.commit();
	}
	public Cliente recuperarClientePorNombre(String nombre) {

		return (Cliente) entityManager.createQuery("from Usuarios.Cliente where nombre = :nombre").setParameter("nombre", nombre).getSingleResult();		
	}
	
	public void actualizarCliente(Cliente cliente) {
		transaccion.begin();
		entityManager.merge(cliente);
		transaccion.commit();
	}
}
