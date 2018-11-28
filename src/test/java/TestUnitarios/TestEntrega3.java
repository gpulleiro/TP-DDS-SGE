package TestUnitarios;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import com.google.maps.errors.ApiException;

import Acciones.AccionApagar;
import Dao.ClienteDAO;
import Dao.CoordenadasDAO;
import Dao.DispositivoDAO;
import Dao.ReglaDAO;
import Dao.TransformadorDAO;
import Dispositivo.Dispositivo;
import Dispositivo.Inteligente;
import Observer.Regla;
import Repositorio.Repositorio;
import Sensores.SensorDeMovimiento;
import TipoDato.Coordenadas;
import TipoDato.Log;
import Usuarios.Administrador;
import Usuarios.Cliente;
import ZonaGeografica.Transformador;

public class TestEntrega3 {
	
//	//Caso de Prueba 1
//	@Test
//	public void seRealizoElCambioDeGeolocalizacionDeC1AC2() throws Exception {
//		
//		//se crea nuevo cliente, y se le setea la nueva coordenada
//		Cliente cliente1 = new Cliente("gabi","mamani","beiro","11/10/2018","gabi23","contra123","DNI",22222,111,11);
//		Coordenadas c1 = new Coordenadas(10,20);
//		cliente1.setCoordenadas(c1);
//		
//		//se crea instancias de dao de cliente y coordenada
//		CoordenadasDAO coodao = new CoordenadasDAO();
//		ClienteDAO dao = new ClienteDAO();
//		
//		//registro en la base de datos
//		coodao.agregar(c1);
//		dao.agregar(cliente1);
//		
//		//se recupera de la base un cliente por nombre
//		Cliente clienteRecup = dao.recuperarClientePorNombre("gabi");
//		
//		//se crea nueva coordenada y se le setea la nueva al cliente recuperado de la base
//		Coordenadas c2 = new Coordenadas(25,30);
//		coodao.agregar(c2);
//		clienteRecup.setCoordenadas(c2);
//		
//		//se actualiza cliente con la nueva coordenada en la base
//		dao.actualizarCliente(clienteRecup);
//		
//		assertEquals(c2, clienteRecup.getCoordenadas());
//		
//	}
//	
//	// test N2
//	@Test
//	public void recuperarDispositivoMostrarLogModificarNombreYGrabarlo() throws Exception {
//		
//		Administrador admin = new Administrador();
//		
//		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
//		EntityTransaction transaccion = entityManager.getTransaction();
//		
//		DispositivoDAO disDAO = new DispositivoDAO();
//		
//		transaccion.begin();
//		
//		disDAO.cargaInicial();
//		
//		transaccion.commit();
//		
//		//obtengo el dispositivo
//		Dispositivo dis = admin.obtenerDispositivo("PC de escritorio");
//		
//		//obtengo la lista de logs encendidos 
//		List<Log> listaLog = admin.obtenerLogs("PC de escritorio",10,"encendido");
//		
//		//le cambio el nombre
//		dis.setNombre("Test N2");
//		
//		//lo persisto
//		admin.registrarDispositivo(dis);
//		
//		//lo obtengo nuevamente
//		dis = admin.obtenerDispositivo("Test N2");
//		
//		assertEquals("Test N2", dis.getNombre());
//		
//		//muestro la lista de logs por consola
//		for(Log log: listaLog){
//			
//			System.out.println(log.toString());
//		}
//		
//		//para volver la base a su estado original y que el test corra siempre bien
//		
////		Administrador admin = new Administrador();
////		Dispositivo dis = admin.obtenerDispositivo("Test N2");
////		dis.setNombre("PC de escritorio");
////		admin.registrarDispositivo(dis);
//	}
//	
//	
//
//	@Before
//	public void importarRepositorio() throws IOException, ApiException, InterruptedException {
//		
//		Repositorio repositorio = Repositorio.getInstance();
//		repositorio.importarLog();
//		repositorio.importarDispositivos();
//		repositorio.importarZona();
//		repositorio.importarTransformadores();
//		repositorio.importarClientes();
//		
//
//	}
//	
//	
//	//caso de prueba 3
//		@Test
//		public void creaReglaYCambiaSuCondicion() throws Exception{
//			
//				ReglaDAO rdao = new ReglaDAO();
//				
//				//crear una nueva regla
//				AccionApagar actuadorApagar = new AccionApagar();
//				SensorDeMovimiento senmov = new SensorDeMovimiento();
//				Regla regla = new Regla("apagar","igual", 0, actuadorApagar,senmov);
//				
//				//asociarla a un dispositivo
//				Inteligente televisor = new Inteligente("televisor",2,3,4,"encendido");
//				
////				regla.getDispositivos().add(televisor);
//				
//				//persistirla
//				rdao.agregar(regla);
//				
//				//recuperarla y ejecutarla
//				Regla reg = rdao.obtenerRegla("apagar");
//				reg.update();
//				
//				//modificar alguna condicion y persistirla
//				reg.setCondicion("mayor");
//				rdao.agregar(reg);
//				
//				//recuperarla y evaluar que la condicion modificada posea la ultima modificacion
//				reg = rdao.obtenerRegla("apagar");
//				assertEquals("mayor", reg.getCondicion());
//		}
//	
//	
//	//test 4
//	@Test
//	public void cantidadActualIgualALaAnteriorMasUno() throws Exception{
//		
//		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
//		EntityTransaction transaccion = entityManager.getTransaction();
//		
//		//leo todos los transformadores del json y los persisto
//		TransformadorDAO trafoDAO = new TransformadorDAO();
//		transaccion.begin();
//		
//		trafoDAO.cargaInicial();
//		
//		transaccion.commit();
//		
//		//me traigo todos los transformadores
//		List<Transformador> transformadores = trafoDAO.listarTransformadores();
//		
//		//obtengo la cantidad 
//		int cantidadTrafos = transformadores.size();
//		
//		System.out.println(cantidadTrafos);
//		
//		//agrego el nuevo transformador
//		Repositorio repositorio = Repositorio.getInstance();
//		
//		repositorio.importarTransformadoresNuevos();
//		
//		transaccion.begin();
//		
//		trafoDAO.cargaInicial();
//		
//		transaccion.commit();
//		
//		//obtengo la lista de transformadores actualizada
//		List<Transformador> transformadoresNuevos = trafoDAO.listarTransformadores();
//		
//		//obtengo la nueva cantidad
//		int cantidadNueva= transformadoresNuevos.size();
//		
//		System.out.println(cantidadNueva);
//		
//		assertEquals((cantidadTrafos +1) , cantidadNueva);
//			
//	}
//	
//	//test numero 5
//	@Test
//    public void consumoTotal() throws Exception{
//
//	Repositorio repo = Repositorio.getInstance();
//	
//	DispositivoDAO disDAO = new DispositivoDAO();
//	
//	ClienteDAO cliDAO = new ClienteDAO();
//	
//	Dispositivo dis1 = repo.getDispositivos().get(21);
//	
//	Cliente cli1 = repo.getClientes().get(1);
//	
//	cli1.aniadirDispositivo(dis1);
//	
//	cliDAO.agregar(cli1);
//	
//	//muestro el consumo total de un hogar
//	double consumoTotal = cli1.consumo("06/10/2018 02:30:00");
//	
//	System.out.println("consumo hogar: "+consumoTotal);
//	
//	//muestro el consumo total por dispositivo
//	Dispositivo dis = repo.getDispositivos().get(21);
//	
//	double consumoDis = dis.consumoPeriodo("06/10/2018 02:30:00", "06/10/2018 17:00:00"); 
//	
//	System.out.println("consumo dispositivo: "+consumoDis);
//	
//	//muestro el consumo del transformador 
//	
//	Transformador trafo = repo.getTransformadores().get(0);
//	
//	double consumoTrafo = trafo.consumo("06/10/2018 02:30:00");
//	
//	System.out.println("consumo transformador: "+consumoTrafo);
//	
//	//aumento el consumo del dispositivo	
//	Dispositivo dispoAumentado = cli1.getDispositivos().get(0);
//	
//	dispoAumentado.setConsumoFijo(dispoAumentado.getConsumoFijo()* 1000);
//	
////	disDAO.registrarDispositivo(dispoAumentado);
//	
//	//calculo nuevamente el consumo
//	consumoTrafo = trafo.consumo("06/10/2018 02:30:00");
//	
//	System.out.println("consumo transformador aumentado: "+consumoTrafo);
//	
//	
//	
//	
//}
	
}
