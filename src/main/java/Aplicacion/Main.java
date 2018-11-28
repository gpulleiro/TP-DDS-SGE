package Aplicacion;

import java.io.IOException;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import Dao.DispositivoDAO;
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
	
	public static void main( String[] args ) throws Exception{
		
		Repositorio repositorio = Repositorio.getInstance();
		repositorio.importarLog();
		repositorio.importarDispositivos();
		repositorio.importarZona();
		repositorio.importarTransformadores();
		repositorio.importarClientes();		
		
//		DispositivoDAO dao = new DispositivoDAO();
//		dao.cargaInicial();

		//Descomentar para asignarle el puerto de heroku y hacer el deploy
		//port(getHerokuAssignedPort());
		
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
        
        //Reglas
        
        get("/reglas",					ReglaController.reglasCliente);
        post("/reglas", 				ReglaController.agregarRegla);
        post("/reglas/eliminar", 		ReglaController.eliminarRegla);
       
        get("/editarRegla",				ReglaController.editarReglaMenu);
        post("/editarRegla", 			ReglaController.editarReglaMenu);
        post("/editarRegla/confirm", 	ReglaController.editarRegla);
        
        get("/sensores",				ReglaController.sensoresMenu);
        
        get("/reportes",				ReportesController.reportes);
        
        post("/dispositivos/importar", 	DispositivosController.importarDispositivos);
        
        
        
        
        
        
        
        
	
	}
	
	//Metodo que asigna puerto heroku
	static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}