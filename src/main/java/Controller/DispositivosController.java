package Controller;
import Helpers.ViewHelper;
import Repositorio.Repositorio;
import Usuarios.Cliente;
import spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static Helpers.RequestHelper.*;
import static spark.Spark.get;

import java.io.FileReader;
import java.util.*;
import java.util.stream.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
		
		public static Route importarDispositivos = (Request request, Response response) -> {
			LoginController.ensureUserIsLoggedIn(request, response);
			Map<String, Object> model = new HashMap<>();
			
			
			ArrayList<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
			
			String json = getQueryJson(request);
			DispositivoDAO daoDispositivo = new DispositivoDAO();
			
			JsonParser parser = new JsonParser();
			try {
			JsonArray gsonArr = parser.parse(new FileReader(json)).getAsJsonArray();
			for (JsonElement obj: gsonArr){
				JsonObject unDispo = obj.getAsJsonObject();
				String nombre = unDispo.get("nombre").getAsString();
				double consumoFijo = unDispo.get("consumoFijo").getAsFloat();
				int minimoHoras = unDispo.get("minimoHoras").getAsInt();
				int maximoHoras = unDispo.get("maximoHoras").getAsInt();
				String flag = unDispo.get("flag").getAsString();
				Dispositivo unDispositivo = null;
				if (flag.equals("I")){
					 unDispositivo = new Inteligente(nombre, consumoFijo, minimoHoras, maximoHoras,unDispo.get("estado").getAsString());
				}else if(flag.equals("E")){
					unDispositivo = new Estandar(nombre, consumoFijo, minimoHoras, maximoHoras,unDispo.get("cantHoras").getAsInt()); 				
				}
				dispositivos.add(unDispositivo);
				
			}
			}catch (Exception e) {
				
//				e.printStackTrace();
				model.put("archivoInvalido", true);
				
			}
			
			for(Dispositivo dispositivo:dispositivos) {
				
				daoDispositivo.agregar(dispositivo);
			}
			
			response.redirect("/dispositivos");
			return null;
	        
	        
		};
		

		
}
