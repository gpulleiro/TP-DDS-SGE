package Usuarios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class UsuarioDAO implements WithGlobalEntityManager{
	
	EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
	
	EntityTransaction transaccion = entityManager.getTransaction();
	
	public void registrarUsuario(Usuario usuario) {
		entityManager().persist(usuario);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios(){
		return entityManager().createQuery("from Usuarios.Usuario").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> filtrarPorNombre(String nombre) {
		return entityManager().createQuery("from Usuarios.Usuario where nombre = :nombre").setParameter("nombre", nombre).getResultList();
	}
}
