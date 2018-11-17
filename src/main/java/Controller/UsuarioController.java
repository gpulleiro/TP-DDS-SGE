package Controller;

import static spark.Spark.*;

import java.util.*;

import Dao.ClienteDAO;
import Dao.DispositivoDAO;
import Dispositivo.Dispositivo;
import Helpers.ViewHelper;
import Usuarios.Cliente;
import Usuarios.Usuario;
import spark.*;
import static Helpers.RequestHelper.*;

public class UsuarioController {

	public static boolean authenticate(String username, String password) {

		ClienteDAO dao = new ClienteDAO();
		Usuario user = dao.recuperarPorUsername(username);
		if (user == null) {
			return false;
		} else {
			return user.getContrasenia().equals(password.toString());
		}

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
		String fecha = getQueryConsumoFecha(request);
		double consumoFecha = cliente.consumo(fecha);
		model.put("fechaConsumo", consumoFecha);
		return ViewHelper.render(request, model, "consumo.html");
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
			
			

}
