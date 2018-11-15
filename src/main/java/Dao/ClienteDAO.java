package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import Usuarios.Cliente;
import Usuarios.Usuario;

public class ClienteDAO extends AbstractDAO{
	
	static EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
	
	static EntityTransaction transaccion = entityManager.getTransaction();
	

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
	public Usuario recuperarPorUsername(String usuario) {
		// TODO Auto-generated method stub
		return (Usuario) entityManager.createQuery("from Usuario where usuario = :usuario").setParameter("usuario", usuario).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> obtenerClientes() {
		
		return entityManager.createQuery("FROM Usuarios.Cliente").getResultList();
		
	}
	
	
}
