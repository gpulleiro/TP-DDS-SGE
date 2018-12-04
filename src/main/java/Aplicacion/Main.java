package Aplicacion;

import java.io.IOException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import TipoDato.Log;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import com.google.maps.errors.ApiException;

import Acciones.AccionApagar;
import Controller.DispositivosController;
import Controller.HomeController;
import Controller.LoginController;
import Controller.ReglaController;
import Controller.ReportesController;
import Controller.SimplexController;
import Controller.TransformadorController;
import Controller.UsuarioController;
import Dao.AbstractDAO;
import Dao.ClienteDAO;
import Dao.ConsumoDAO;
import Dao.DispositivoDAO;
import Dao.LogDAO;
import Dao.ReglaDAO;
import Dao.ReportesDAO;
import Dispositivo.Dispositivo;
import Dispositivo.Estandar;
import Dispositivo.Inteligente;
import Observer.Regla;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;	
import com.google.maps.model.GeocodingResult;




import Repositorio.Repositorio;
import Sensores.SensorDeMovimiento;
import Simplex.TimerSimplex;
import TipoDato.Log;
import Usuarios.Administrador;
import Usuarios.Cliente;
import Usuarios.Usuario;
import ZonaGeografica.Transformador;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateViewRoute;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static Helpers.RequestHelper.getQueryLoginRedirect;
import static Helpers.RequestHelper.getQueryPassword;
import static Helpers.RequestHelper.getQueryUsername;
import static Helpers.RequestHelper.removeSessionAttrLoggedOut;
import static Helpers.RequestHelper.removeSessionAttrLoginRedirect;
import static spark.Spark.*;
import static spark.debug.DebugScreen.*;


public class Main {
	
	@SuppressWarnings("deprecation")
	public static void main( String[] args ) throws Exception{
		
		
		
//		
//		ClienteDAO cliDAO = new ClienteDAO();
//		Cliente cli = cliDAO.obtenerClientePorId(2);
//		
//		System.out.println(cli.esEficiente(1));
//		
//		//System.out.println(cli.getDispositivos());
//		System.out.println(cli.consumoGenerico());
//	
		
		Repositorio repositorio = Repositorio.getInstance();
		repositorio.importarLog();

//		
//		
//		LogDAO daolog= new LogDAO();
//		List<Log> lista = new ArrayList<Log>();
//		
//		List<Log> listaLog = daolog.obtenerLogsPorMes(new Date().getMonth() + 1, 9, 1);
//		
//		Date fecha1 = null;
//		Date fecha2 = null;
//		int cantidadHoras = 0;
//				
//		for (int i = 0; i < listaLog.size(); i++) {
//			
//			if(listaLog.get(i).getEstado() == "encendido" ) {
//				fecha1 = listaLog.get(i).getFecha();
//				
//				for (int j = i+1; j < listaLog.size(); j++) {
//					if(listaLog.get(i).getEstado() == "apagado" ) {
//						fecha2 = listaLog.get(i).getFecha();
//						
//						cantidadHoras = 
//					}
//				}
//			}
//			
//		}
//		
//		System.out.println(listaLog);
//		
//		
//		LogDAO dao = new LogDAO();
//		for (int i = 0; i < repositorio.getLog().size(); i++) {
//			dao.agregar(repositorio.getLog().get(i));
//			
//		}
//		repositorio.importarDispositivos();
//		repositorio.importarZona();
//		repositorio.importarTransformadores();
//		repositorio.importarClientes();		
//		
////		DispositivoDAO dao = new DispositivoDAO();
////		dao.cargaInicial();
				
//		DispositivoDAO dao = new DispositivoDAO();
//		Inteligente dis1 = (Inteligente) dao.obtenerDispositivoPorId(1);
//		Inteligente dis2 = (Inteligente) dao.obtenerDispositivoPorId(2);
//		
//		ReglaDAO reglaDao = new ReglaDAO();
//		Regla regla = reglaDao.obtenerReglaPorId(1);
//		
//
//		regla.aniadirDispositivo(dis1);
//		regla.aniadirDispositivo(dis2);
//		
//		reglaDao.actualizar(regla);
//
//		dis1.setCantidadHorasEncendido(400);
//		dis2.setCantidadHorasEncendido(300);
//		
//		dis1.encender();
//		dis2.encender();
//		
//		
//
//		System.out.println(dis1.getEstado());
//		System.out.println(dis2.getEstado());
		
//
//		//Descomentar para asignarle el puerto de heroku y hacer el deploy
//		//port(getHerokuAssignedPort());
//		
		port(8080);
        staticFiles.location("/templates");
        staticFiles.expireTime(600L);
        enableDebugScreen();
        
//		ReportesDAO reportes = new ReportesDAO();
//		System.out.println(reportes.generarReporte1().get(1).getFecha());
//		System.out.println(reportes.generarReporte2().get(1).getTipo());

    
        get("/login",			LoginController.serveLoginPage);
        post("/login",			LoginController.handleLoginPost);
        post("/logout",			LoginController.handleLogoutPost);
        get("/index",			LoginController.index);
        get("/home",			HomeController.homeClientePage);
        get("/dispositivos",	DispositivosController.traerDispositivos);
        post("/dispositivos",	DispositivosController.crearDispositivo);
        post("/dispositivos/borrar",	DispositivosController.borrarDispositivo);
        get("/editarDispositivo",		DispositivosController.editarDispositivoMenu);
        post("/editarDispositivo",		DispositivosController.editarDispositivoMenu);
        post("/editarDispositivo/confirm",		DispositivosController.editarDispositivo);
        get("/hogares",			UsuarioController.traerClientes);

        //menu del cliente
        get("/simplex",			SimplexController.simplexPage);
        post("/simplex",		SimplexController.simplexEjecutado);
        
//        get("/estadoHogar", 	UsuarioController.clienteEstadoHogar);
        get("/estadoHogar", 	UsuarioController.clienteConsumoPeriodo);
        get("/consumo", 		UsuarioController.clienteMenuConsumo);
        post("/consumo", 		UsuarioController.clienteConsultaConsumo);
        
        //ABM
        get("/dispositivosAlta",	UsuarioController.traerDispositivos);
        
        get("/mapa",				TransformadorController.mapa);
        get("/dispositivosByM",		UsuarioController.clienteBajaYModificacion);
        post("/dispositivosAlta", 	UsuarioController.clienteAgregarDispositivo);
        post("/dispositivosByM", 	UsuarioController.clienteEliminarDispositivo);
        
        post("/apagarDispositivo",	UsuarioController.apagarDispositivo);
        post("/encenderDispositivo",	UsuarioController.encenderDispositivo);
        
        //Reglas
        
        get("/reglas",					ReglaController.reglasCliente);
        post("/reglas", 				ReglaController.agregarRegla);
        post("/reglas/eliminar", 		ReglaController.eliminarRegla);
       
        get("/editarRegla",				ReglaController.editarReglaMenu);
        post("/editarRegla", 			ReglaController.editarReglaMenu);
        post("/editarRegla/confirm", 	ReglaController.editarRegla);
        
        get("/reglas/dispositivos",	ReglaController.reglaDispositivosMenu);
        post("/reglas/dispositivos",	ReglaController.reglaDispositivosMenu);
        post("/reglas/dispositivo/agregar",	ReglaController.reglaDispositivoAgregar);
        
        get("/reglas/dispositivosAsignados", ReglaController.reglaDispositivosAsignados);
        post("/reglas/dispositivosAsignados", ReglaController.reglaDispositivosAsignados);
        post("/reglas/dispositivosAsignados/eliminar", ReglaController.reglaDispositivosRemove);
        
        
        get("/reportes",				ReportesController.reportes);
        
        post("/dispositivos/importar", 	DispositivosController.importarDispositivos);
        
        get("/eficiencia",				HomeController.clienteMenuEficiencia);
        post("/eficiencia",				HomeController.clienteConsultaEficiencia);
        
        
        
        
        
        
        
	
	}
	
//	//Metodo que asigna puerto heroku
//	static int getHerokuAssignedPort() {
//        ProcessBuilder processBuilder = new ProcessBuilder();
//        if (processBuilder.environment().get("PORT") != null) {
//            return Integer.parseInt(processBuilder.environment().get("PORT"));
//        }
//        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
//    }
}