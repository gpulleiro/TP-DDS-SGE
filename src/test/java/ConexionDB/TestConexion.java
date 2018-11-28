package ConexionDB;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

public class TestConexion extends AbstractPersistenceTest implements WithGlobalEntityManager{

//	@Test
//	public void contextUp() {
//		assertNotNull(entityManager()); //para hablar con el ORM
//	}
//
//	@Test
//	public void contextUpWithTransaction() throws Exception {
//		withTransaction(() -> {});
//	}

}
