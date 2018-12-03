package Controller;

import static spark.Spark.*;

import java.util.*;


import TipoDato.Log;

import Dao.ClienteDAO;
import Dao.DispositivoDAO;
import Dao.LogDAO;
import Dao.ReglaDAO;
import Dispositivo.Dispositivo;
import Dispositivo.Estandar;
import Dispositivo.Inteligente;
import Helpers.ViewHelper;
import Observer.Regla;
import Repositorio.Repositorio;
import Usuarios.Cliente;
import Usuarios.Usuario;
import spark.*;
import static Helpers.RequestHelper.*;

public class UsuarioController {

	public static boolean authenticate(String username, String password) {

		try {
			ClienteDAO dao = new ClienteDAO();
			Usuario user = dao.recuperarPorUsername(username);
			if (user == null) {
				return false;
			} else {
				return user.getContrasenia().equals(password.toString());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;

	}

	public static Route traerClientes = (Request request, Response response) -> {
		LoginController.ensureUserIsLoggedIn(request, response);
		HashMap<String, Object> model = new HashMap<>();

		ClienteDAO dao = new ClienteDAO();
		List<Cliente> clientes = dao.obtenerClientes();

		// lista que le mando a la vista
		ArrayList<Cliente> clientesMapeados = new ArrayList<Cliente>();
		for (Cliente cliente : clientes) {

			// cliente con el atributo necesario
			Cliente clienteMapeado = new Cliente(cliente.getNombre(), cliente.consumoGenerico(),
					cliente.getDispositivos());

			clientesMapeados.add(clienteMapeado);
		}

		model.put("clientes", clientesMapeados);

		return ViewHelper.render(request, model, "hogares.html");

	};

	public static Route clienteEstadoHogar = (Request request, Response response) -> {
		LoginController.ensureUserIsLoggedIn(request, response);
		Map<String, Object> model = new HashMap<>();
		String myUser = request.session().attribute("currentUser");

		return ViewHelper.render(request, model, "estadoHogar.html");
	};

	public static Route clienteConsumoPeriodo = (Request request, Response response) -> {
		LoginController.ensureUserIsLoggedIn(request, response);
		Map<String, Object> model = new HashMap<>();
		String myUser = request.session().attribute("currentUser");

		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = dao.obtenerCliente(myUser);

		double consumoPeriodo = cliente.consumo("02/11/2018 02:00:00");

		model.put("dispositivosCliente", cliente.getDispositivos());
		model.put("consumoPeriodo", consumoPeriodo);
		model.put("reglasCliente", cliente.getReglas());

		return ViewHelper.render(request, model, "estadoHogar.html");
	};

	public static Route traerDispositivos = (Request request, Response response) -> {
		LoginController.ensureUserIsLoggedIn(request, response);
//		        request.session().attribute("esAdmin");
		HashMap<String, Object> model = new HashMap<>();

		DispositivoDAO dao = new DispositivoDAO();
		List<Dispositivo> dispositivos = dao.obtenerDispositivos();

		model.put("dispositivos", dispositivos);

		return ViewHelper.render(request, model, "dispositivosAlta.html");

	};

	public static Route clienteMenuConsumo = (Request request, Response response) -> {
		LoginController.ensureUserIsLoggedIn(request, response);
		Map<String, Object> model = new HashMap<>();
		
		String myUser = request.session().attribute("currentUser");

		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = dao.obtenerCliente(myUser);
		
		LogDAO daoLog = new LogDAO();
		
		for (int i = 0; i < cliente.getDispositivos().size(); i++) {
			if(cliente.getDispositivos().get(i).esInteligente2()) {
				
				List<Log> listaLog = daoLog.obtenerLogsPorMes(new Date().getMonth(), cliente.getDispositivos().get(i).getId(), cliente.getId());
				Inteligente dispoInteligente = (Inteligente) cliente.getDispositivos().get(i);
				dispoInteligente.obtenerCantidadDeHorasUltimoMes(listaLog);
				
				dispoInteligente.consumoUltimoMesPorHoras(dispoInteligente.getCantidadHorasEncendido());
				
			}
			else {
				Estandar dispoEstandar = (Estandar) cliente.getDispositivos().get(i);
				dispoEstandar.consumoUltimoMesPorHoras(30);
				
				}
			
		}
		model.put("dispositivosCliente", cliente.getDispositivos());

		return ViewHelper.render(request, model, "consumo.html");
	};

	public static Route clienteConsultaConsumo = (Request request, Response response) -> {
		LoginController.ensureUserIsLoggedIn(request, response);
		Map<String, Object> model = new HashMap<>();
		String myUser = request.session().attribute("currentUser");

		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = dao.obtenerCliente(myUser);

		// model.put("dispositivosCliente" , cliente.getDispositivos());

		if (getQueryConsumoFecha(request).isEmpty()) {

			return ViewHelper.render(request, model, "consumo.html");
		}
		String fecha = getQueryConsumoFecha(request) + " 00:00:00";
		try {
		double consumoFecha = cliente.consumo(fecha);
		model.put("fechaConsumo", consumoFecha);
		
		}catch (Exception e) {
		
		model.put("fechaInvalida", true);
		}
		
		return ViewHelper.render(request, model, "consumo.html");
//		model.put("fechaConsumo", consumoFecha);
//		return ViewHelper.render(request, model, "consumo.html");
	};

	public static Route clienteBajaYModificacion = (Request request, Response response) -> {
		LoginController.ensureUserIsLoggedIn(request, response);

		Map<String, Object> model = new HashMap<>();
		String myUser = request.session().attribute("currentUser");

		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = dao.obtenerCliente(myUser);
		List<Dispositivo> dispositivos = cliente.getDispositivos();

		model.put("dispositivos", dispositivos);
		return ViewHelper.render(request, model, "dispositivosByM.html");

	};

	public static Route clienteAgregarDispositivo = (Request request, Response response) -> {
			LoginController.ensureUserIsLoggedIn(request, response);
			Map<String, Object> model = new HashMap<>();
			
			String myUser = request.session().attribute("currentUser");
			
			ClienteDAO dao = new ClienteDAO();
			Cliente cliente = dao.obtenerCliente(myUser);
			
			DispositivoDAO dispositivoDao = new DispositivoDAO();
			Dispositivo dispositivoNuevo = dispositivoDao.obtenerDispositivoPorId(Long.parseLong(getQueryAgregarDispositivo(request)));
			
			cliente.aniadirDispositivo(dispositivoNuevo);
			dao.actualizarCliente(cliente);
			
			response.redirect("/dispositivosByM");
			return null;
			
		};
		
	public static Route clienteEliminarDispositivo = (Request request, Response response) -> {
		LoginController.ensureUserIsLoggedIn(request, response);
		Map<String, Object> model = new HashMap<>();
		
		String myUser = request.session().attribute("currentUser");
		
		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = dao.obtenerCliente(myUser);
		
		DispositivoDAO dispositivoDao = new DispositivoDAO();
		Dispositivo dispositivoNuevo = dispositivoDao.obtenerDispositivoPorId(Long.parseLong(getQueryEliminarDispositivo(request)));
		
		cliente.eliminarDispositivo(dispositivoNuevo);
		dao.actualizarCliente(cliente);
		
		response.redirect("/home");
		return null;
		
		};
		
	public static Route apagarDispositivo = (Request request, Response response) -> {
		LoginController.ensureUserIsLoggedIn(request, response);
		Map<String, Object> model = new HashMap<>();
		
		String myUser = request.session().attribute("currentUser");
		
		ClienteDAO dao = new ClienteDAO();
		DispositivoDAO disDao = new DispositivoDAO();
		LogDAO daoLog = new LogDAO();
		
		try {
			Cliente cliente = dao.obtenerCliente(myUser);
			Inteligente dispo = (Inteligente) disDao.obtenerDispositivoPorId(Long.parseLong(getQueryApagado(request)));
			
			// SI ESTA APAGADO, NO HACE NADA
			if("apagado".equals(dispo.getEstado())) {
				response.redirect("/estadoHogar");
				return null;
			}
			
			@SuppressWarnings("deprecation")
			List<Log> listaLog = daoLog.obtenerLogsPorMes((new Date().getMonth() +1), dispo.getId(), cliente.getId());
			dispo.obtenerCantidadDeHorasEnUnMes(listaLog);
			
			dispo.apagar();
			Log logApagado = new Log(Long.parseLong(getQueryApagado(request)), new Date(), dispo.getNombre(), "apagado", cliente.getId());
			daoLog.agregar(logApagado);
			
			if(dispo.estasEncendido()) {
				Log logEncendido = new Log(Long.parseLong(getQueryApagado(request)), new Date(), dispo.getNombre(), "encendido", cliente.getId());
				daoLog.agregar(logEncendido);
				response.redirect("/estadoHogar");
				return null;
			}
			
			dispo.setEstado("apagado");
			disDao.actualizar(dispo);
			response.redirect("/home");
			return null;
		
		}	
		catch(Exception e) {
			response.redirect("/home");
			e.printStackTrace();
			return null;
		}
		
	};
	
	public static Route encenderDispositivo = (Request request, Response response) -> {
		LoginController.ensureUserIsLoggedIn(request, response);
		Map<String, Object> model = new HashMap<>();
		Repositorio repo = Repositorio.getInstance();
		String myUser = request.session().attribute("currentUser");
		
		ClienteDAO dao = new ClienteDAO();
		DispositivoDAO disDao = new DispositivoDAO();
		LogDAO daoLog = new LogDAO();
		Date fechaActual = new Date();
		
		
		try {
			Cliente cliente = dao.obtenerCliente(myUser);
			Inteligente dispo = (Inteligente) disDao.obtenerDispositivoPorId(Long.parseLong(getQueryEncendido(request)));
			if(dispo.estasEncendido()) {
				response.redirect("/estadoHogar");
				return null;
			}
			
			@SuppressWarnings("deprecation")
			List<Log> listaLog = daoLog.obtenerLogsPorMes((new Date().getMonth() -1), dispo.getId(), cliente.getId());
			dispo.obtenerCantidadDeHorasEnUnMes(listaLog);
			
			// SE ENCIENDE EL DISPOSITIVO Y SE AGREGA AL LOG
			dispo.encender();
			Log logEncendido = new Log(Long.parseLong(getQueryEncendido(request)), new Date(), dispo.getNombre(), "encendido", cliente.getId());
			daoLog.agregar(logEncendido);
			
			//SE EVALUA SI SE APAGA EL DISPOSITIVO POR LA REGLA Y SE LA AGREGA AL LOG
			if(!dispo.estasEncendido()) {
				Log logApagado = new Log(Long.parseLong(getQueryEncendido(request)), new Date(), dispo.getNombre(), "apagado", cliente.getId());
				daoLog.agregar(logApagado);
				response.redirect("/estadoHogar");
				return null;
			}
			
			dispo.setEstado("encendido");
			disDao.actualizar(dispo);				
			response.redirect("/home");
			return null;
		}
		catch(Exception e) {
			response.redirect("/home");
			return null;
		}
		
		
		
	};
			
			

}
