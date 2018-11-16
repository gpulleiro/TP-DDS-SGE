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

public class UsuarioController {
			
		public static boolean authenticate(String username, String password) {

			ClienteDAO dao = new ClienteDAO();
			Usuario user = dao.recuperarPorUsername(username);
	        if (user == null) {
	            return false;
	        }else {
	        	return user.getContrasenia().equals(password.toString());
	        }
	        
	    }

		public static Route traerClientes = (Request request, Response response) -> {
	        LoginController.ensureUserIsLoggedIn(request, response);
	        HashMap<String, Object> model = new HashMap<>();
	        
	        ClienteDAO dao = new ClienteDAO();
	        List<Cliente> clientes = dao.obtenerClientes();

	        //lista que le mando a la vista
	        ArrayList<Cliente> clientesMapeados = new ArrayList<Cliente>();
	        for (Cliente cliente:clientes) {
	        	
	        	//cliente con el atributo necesario
	        	Cliente clienteMapeado = new Cliente(cliente.getNombre(),cliente.consumoGenerico(),cliente.getDispositivos());
	        	
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

	        	model.put("dispositivosCliente" , cliente.getDispositivos());
	        	model.put("consumoPeriodo", consumoPeriodo);
	        	
	        	return ViewHelper.render(request, model, "estadoHogar.html");
	        };
	        
	        
			public static Route traerDispositivos = (Request request, Response response) -> {
		        LoginController.ensureUserIsLoggedIn(request, response);
//		        request.session().attribute("esAdmin");
		        HashMap<String, Object> model = new HashMap<>();
		       
		        DispositivoDAO dao = new DispositivoDAO();
		        List<Dispositivo> dispositivos = dao.obtenerDispositivos();
		        
		        model.put("dispositivos", dispositivos);

		        return ViewHelper.render(request, model, "ABMdispositivos.html");
		        
		        
			};
	        
	    
	

}
