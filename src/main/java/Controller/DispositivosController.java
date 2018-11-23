package Controller;
import Helpers.ViewHelper;
import Repositorio.Repositorio;
import Usuarios.Cliente;
import spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static Helpers.RequestHelper.*;
import static spark.Spark.get;

import java.util.*;
import java.util.stream.*;

import Dao.ClienteDAO;
import Dao.DispositivoDAO;
import Dispositivo.Dispositivo;
import Dispositivo.Estandar;
import Dispositivo.Inteligente;

public class DispositivosController {
		
		public static Route traerDispositivos = (Request request, Response response) -> {
	        LoginController.ensureUserIsLoggedIn(request, response);
//	        request.session().attribute("esAdmin");
	        HashMap<String, Object> model = new HashMap<>();
	       
	        DispositivoDAO dao = new DispositivoDAO();
	        List<Dispositivo> dispositivos = dao.obtenerDispositivos();
	        
	        model.put("dispositivos", dispositivos);

	        return ViewHelper.render(request, model, "dispositivos2.html");
	        
	        
		};
		
		public static Route crearDispositivo = (Request request, Response response) -> {
	        LoginController.ensureUserIsLoggedIn(request, response);
	        HashMap<String, Object> model = new HashMap<>();
	        DispositivoDAO dao = new DispositivoDAO();

	        if( getQueryTipoDispositivo(request).equals("estandar") ) {
	        Dispositivo nuevoDispositivo =
	        new Estandar (getQueryDispositivoName(request),
	        		Double.parseDouble(getQueryDispositivoConsumo(request)),
	        		Double.parseDouble(getQueryDispositivoMinHoras(request)),
	        		Double.parseDouble(getQueryDispositivoMaxHoras(request)),0);
	        
	        
	        dao.agregar(nuevoDispositivo);;
	        response.redirect("/dispositivos");
	        
	        }
	        else {
	        	Dispositivo nuevoDispositivo =
	        	        new Inteligente (getQueryDispositivoName(request),
	        	        Double.parseDouble(getQueryDispositivoConsumo(request)),
	        	        Double.parseDouble(getQueryDispositivoMinHoras(request)),
	        	        Double.parseDouble(getQueryDispositivoMaxHoras(request)),
	        	        "apagado");
	        	        
	        	        
	        	        dao.agregar(nuevoDispositivo);
	        	        response.redirect("/dispositivos");
	        	        
	        }
	        return null;
	        
		};
		
		public static Route borrarDispositivo = (Request request, Response response) -> {
			LoginController.ensureUserIsLoggedIn(request, response);
			Map<String, Object> model = new HashMap<>();
			
			
			DispositivoDAO dispositivoDao = new DispositivoDAO();
			Dispositivo dispositivoNuevo = dispositivoDao.obtenerDispositivoPorId(Long.parseLong(getQueryBorrarDispositivo(request)));
			
			
			try {
			
			dispositivoDao.borrar(dispositivoNuevo);
			
			

			response.redirect("/dispositivos");
			
			}
			catch(Exception e) {
				
				
				model.put("noSeBorra", true);
				return null;
			}
			
			return null;
	   
			
		};
		
		public static Route editarDispositivoMenu = (Request request, Response response) -> {
			LoginController.ensureUserIsLoggedIn(request, response);
			Map<String, Object> model = new HashMap<>();
			
			
			DispositivoDAO dispositivoDao = new DispositivoDAO();
			Dispositivo dispositivoRecuperado = dispositivoDao.obtenerDispositivoPorId(Long.parseLong(getQueryEditarDispositivo(request)));
			
			
			model.put("dispositivo", dispositivoRecuperado);

			
			return ViewHelper.render(request, model, "editarDispositivo.html");
	   
	        
		};
		
		
		public static Route editarDispositivo = (Request request, Response response) -> {
			LoginController.ensureUserIsLoggedIn(request, response);
			Map<String, Object> model = new HashMap<>();
			
	        DispositivoDAO dao = new DispositivoDAO();
	        
	        Dispositivo dispositivoRecuperado = dao.obtenerDispositivoPorId(Long.parseLong(getQueryEditarDispositivo(request)));
	        dispositivoRecuperado.setNombre(getQueryDispositivoName(request));
	        dispositivoRecuperado.setConsumoFijo(Double.parseDouble(getQueryDispositivoConsumo(request)));
	        dispositivoRecuperado.setMaximoHoras(Double.parseDouble(getQueryDispositivoMaxHoras(request)));
	        dispositivoRecuperado.setMinimoHoras(Double.parseDouble(getQueryDispositivoMinHoras(request)));
	        
	        
	        dao.actualizar(dispositivoRecuperado);;
	        response.redirect("/dispositivos");
	        
	        return null;
	        
	        
		};
		

		
}
