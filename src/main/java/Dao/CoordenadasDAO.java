package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import TipoDato.Coordenadas;

public class CoordenadasDAO extends AbstractDAO {
	
	public Coordenadas obtenerCoordenadasPorId(long id) {

		return (Coordenadas) entityManager.createQuery("from TipoDato.Coordenadas where id = :id").setParameter("id", id).getSingleResult();

	}

}
