package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import Usuarios.Cliente;
import Usuarios.Usuario;

public class ClienteDAO extends AbstractDAO {

	public Cliente recuperarClientePorNombre(String nombre) {

		return (Cliente) entityManager.createQuery("from Usuarios.Cliente where nombre = :nombre")
				.setParameter("nombre", nombre).getSingleResult();
	}

	public void actualizarCliente(Cliente cliente) {
		transaccion.begin();
		entityManager.merge(cliente);
		transaccion.commit();
	}

	public Usuario recuperarPorUsername(String usuario) {
		// TODO Auto-generated method stub
		return (Usuario) entityManager.createQuery("from Usuario where usuario = :usuario")
				.setParameter("usuario", usuario).getSingleResult();
	}

	public Cliente obtenerCliente(String usuario) {
		// TODO Auto-generated method stub
		return (Cliente) entityManager.createQuery("from Usuarios.Cliente where usuario = :usuario")
				.setParameter("usuario", usuario).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> obtenerClientes() {

		return entityManager.createQuery("FROM Usuarios.Cliente").getResultList();

	}
	
	public Cliente obtenerClientePorId(long id) {
		
		return  (Cliente) entityManager.createQuery("from Usuarios.Cliente where id = :id").setParameter("id", id).getSingleResult();
		
	}

}
