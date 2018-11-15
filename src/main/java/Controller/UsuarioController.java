package Controller;
import static spark.Spark.*;

import java.util.*;

import Dao.ClienteDAO;
import Helpers.ViewHelper;
import Usuarios.Cliente;
import Usuarios.Usuario;
import spark.*;

public class UsuarioController {
	
		//ClienteDAO clieDAO = new ClienteDAO();
		
		public static boolean authenticate(String username, String password) {
//	        if (username.isEmpty() || password.isEmpty()) {
//	            return false;
//	        }
//			return true;

			ClienteDAO dao = new ClienteDAO();
			Usuario user = dao.recuperarPorUsername(username);
	        if (user == null) {
	            return false;
	        }else {
	        	return user.getContrasenia().equals(password.toString());
	        }
	        
/* Esto es para el HASHEO de la password, primero lo pruebo normal sin hashear        
 * String hashedPassword = BCrypt.hashpw(password, user.getSalt());
 * return hashedPassword.equals(user.getHashedPassword());*/
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
	

}
