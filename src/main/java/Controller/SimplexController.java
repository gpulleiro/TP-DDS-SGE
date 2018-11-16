package Controller;
import static spark.Spark.*;

import java.util.*;

import Helpers.ViewHelper;
import Simplex.*;
import Usuarios.Cliente;
import Usuarios.Usuario;
import spark.*;
import Dao.*;
import Dispositivo.*;
import static Helpers.RequestHelper.*;

public class SimplexController {
	
	public static Route simplexPage = (Request request, Response response) -> {
		LoginController.ensureUserIsLoggedIn(request, response);
		
		Map<String, Object> model = new HashMap<>();
        String myUser = request.session().attribute("currentUser");
        
        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = dao.obtenerCliente(myUser);
        List<Dispositivo> dispositivos = cliente.getDispositivos();
        
        model.put("dSimplex", dispositivos);
        return ViewHelper.render(request, model, "simplex.hbs");
        
	};
       
       
   	public static Route simplexEjecutado = (Request request, Response response) -> {
   		LoginController.ensureUserIsLoggedIn(request, response);
   		Map<String, Object> model = new HashMap<>();
        String myUser = request.session().attribute("currentUser");
        
        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = dao.obtenerCliente(myUser);
        List<Dispositivo> dispositivos = cliente.getDispositivos();
        
	    SimplexMaximizacionAdapter sma = new SimplexMaximizacionAdapter();
	    sma.realizarCombinacionMaximizacion(dispositivos);
            
        model.put("dSimplex", dispositivos);
        return ViewHelper.render(request, model, "simplex.hbs");
        	
       };
        

        
        
    


}
