package Controller;
import spark.*;
import java.util.*;

import Acciones.Actuador;
import Dao.ClienteDAO;
import Dao.DispositivoDAO;
import Dao.ReglaDAO;
import Dispositivo.Dispositivo;
import Helpers.*;
import Helpers.ViewHelper;
import Observer.Regla;
import Usuarios.Cliente;

import static spark.Spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static Helpers.RequestHelper.*;

public class ReglaController {
	
	public static Route reglasCliente = (Request request, Response response) -> {
		LoginController.ensureUserIsLoggedIn(request, response);
		Map<String, Object> model = new HashMap<>();
		String myUser = request.session().attribute("currentUser");

		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = dao.obtenerCliente(myUser);
		
		model.put("reglas", cliente.getReglas());
		
		return ViewHelper.render(request, model, "reglas.html");
    };
    
    
    
	public static Route agregarRegla = (Request request, Response response) -> {
		LoginController.ensureUserIsLoggedIn(request, response);
		Map<String, Object> model = new HashMap<>();
		
		String myUser = request.session().attribute("currentUser");
		
		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = dao.obtenerCliente(myUser);
		
		ReglaDAO daoRegla = new ReglaDAO();
		
		model.put("actuadores", daoRegla.obtenerActuadores());
		
		if (getQueryActuador(request).equals("ENCENDER")) {
			
			Actuador encender = daoRegla.obtenerActuador(1); //el 1 es encender
			Regla reglaNueva = new Regla(getQueryRegla(request),Double.parseDouble(getQueryFlag(request)),getQueryCondicion(request));
			reglaNueva.setActuador(encender);
			//reglaNueva.setCliente(cliente);
			
			cliente.aniadirRegla(reglaNueva);
		}
		else {
			
				Actuador apagar = daoRegla.obtenerActuador(2); //el 2 es apagar
				Regla reglaNueva = new Regla(getQueryRegla(request),Double.parseDouble(getQueryFlag(request)),getQueryCondicion(request));
				reglaNueva.setActuador(apagar);
				//reglaNueva.setCliente(cliente);
				
				cliente.aniadirRegla(reglaNueva);
			
		}
		
		
		
		
		dao.actualizarCliente(cliente);
		
		response.redirect("/reglas");
		return null;
		
	};
	
	public static Route eliminarRegla = (Request request, Response response) -> {
		LoginController.ensureUserIsLoggedIn(request, response);
		Map<String, Object> model = new HashMap<>();
		
		String myUser = request.session().attribute("currentUser");
		
		
		
		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = dao.obtenerCliente(myUser);
		
		ReglaDAO daoRegla = new ReglaDAO();
		
		Regla reglaEliminada = daoRegla.obtenerReglaPorId(Long.parseLong(getQueryEliminarRegla(request)));
		
		reglaEliminada.setActuador(null);
		cliente.eliminarRegla(reglaEliminada);
		dao.actualizarCliente(cliente);
		
		daoRegla.borrar(reglaEliminada);
		
		response.redirect("/reglas");
		return null;
		
		};
		
		public static Route editarReglaMenu = (Request request, Response response) -> {
			LoginController.ensureUserIsLoggedIn(request, response);
			Map<String, Object> model = new HashMap<>();
			
			
			ReglaDAO daoRegla = new ReglaDAO();
			
			Regla reglaRecuperada = daoRegla.obtenerReglaPorId(Long.parseLong(getQueryEditarRegla(request)));
			
			model.put("regla", reglaRecuperada);

			System.out.println("--------------------------------------------------------------");
			System.out.println(getQueryEditarRegla(request));
			return ViewHelper.render(request, model, "reglaEditar.html");
	   
	        
		};
		
		
		public static Route editarRegla = (Request request, Response response) -> {
			LoginController.ensureUserIsLoggedIn(request, response);
			Map<String, Object> model = new HashMap<>();
			
			ReglaDAO daoRegla = new ReglaDAO();
			Regla reglaRecuperada = daoRegla.obtenerReglaPorId(Long.parseLong(getQueryEditarRegla(request)));
	        
		
	        
	        reglaRecuperada.setNombre(getQueryRegla(request));
	        reglaRecuperada.setCondicion(getQueryCondicion(request));
	        reglaRecuperada.setFlag(Double.parseDouble(getQueryFlag(request)));
	        
	        if(getQueryActuador(request).equals("ENCENDER")) {
	        	
	        	Actuador encender = daoRegla.obtenerActuador(1); //el 1 es encender
				reglaRecuperada.setActuador(encender);
	        }
	        else {
	        	
	        	Actuador apagar = daoRegla.obtenerActuador(2); //el 2 es encender
				reglaRecuperada.setActuador(apagar);
	        }
	        
	        
	        daoRegla.actualizar(reglaRecuperada);;
	        response.redirect("/reglas");
	        
	        return null;
	        
	        
		};
		
		public static Route sensoresMenu = (Request request, Response response) -> {
			LoginController.ensureUserIsLoggedIn(request, response);
			Map<String, Object> model = new HashMap<>();
			
			String myUser = request.session().attribute("currentUser");
			
			ClienteDAO dao = new ClienteDAO();
			Cliente cliente = dao.obtenerCliente(myUser);
			
			List<Regla> reglas = cliente.getReglas();
			model.put("reglas", cliente.getReglas());
			model.put("dispositivos", cliente.getDispositivos());
			
			for (Regla regla:reglas) {
				
				System.out.println(regla.getSensor());
			}
			
			return ViewHelper.render(request, model, "sensores.html");
			
		};
		
		

}
