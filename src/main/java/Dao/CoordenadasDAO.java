package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import TipoDato.Coordenadas;

public class CoordenadasDAO {

	EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
	
	EntityTransaction transaccion = entityManager.getTransaction();
	

	public void registrarCoordenadas(Coordenadas coordenadas) {
		
		transaccion.begin();
		entityManager.persist(coordenadas);
		transaccion.commit();
	}
}
