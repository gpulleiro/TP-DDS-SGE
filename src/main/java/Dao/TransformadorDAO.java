package Dao;


import java.util.List;



import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;



import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import Dispositivo.Dispositivo;
import Repositorio.Repositorio;
import ZonaGeografica.Transformador;


public class TransformadorDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Transformador> listarTransformadores(){

		return entityManager.createQuery("FROM Transformador").getResultList();

	}

	
	public void cargaInicial() {

		Repositorio repo = Repositorio.getInstance();
		
		for(Transformador trafo : repo.getTransformadores()){
	
			entityManager.persist(trafo);
			
		}
//		for(Zona zona: repo.getZonas()){
//
//			entityManager().persist(zona);
//
//		}
	
	}
	
	@SuppressWarnings("unchecked")
	public List<Transformador> obtenerTransformadores(){
		
		return entityManager.createQuery("FROM ZonaGeografica.Transformador").getResultList();
		
	}

}