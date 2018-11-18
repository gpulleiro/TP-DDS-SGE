package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import TipoDato.Coordenadas;

public class CoordenadasDAO extends AbstractDAO {

	public void registrarCoordenadas(Coordenadas coordenadas) {

		transaccion.begin();
		entityManager.persist(coordenadas);
		transaccion.commit();
	}
}
