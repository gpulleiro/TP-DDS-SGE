package Controller;
import spark.*;
import java.util.*;

import Dao.ClienteDAO;
import Helpers.*;
import Helpers.ViewHelper;
import Usuarios.Cliente;

import static spark.Spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static Helpers.RequestHelper.*;

public class HomeController {
	
	public static Route homeClientePage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        String myUser = request.session().attribute("currentUser");
        ClienteDAO dao = new ClienteDAO();
        if (dao.recuperarPorUsername(myUser).esAdmin()) {
        	
        	request.session().attribute("isAdmin",true);
        	
        	return ViewHelper.render(request, model, "homeAdmin.html");

        }
        else {
        	request.session().attribute("isAdmin",false);
        	return ViewHelper.render(request, model, "homeCliente.html");
        }
        
    };
    
    public static Route clienteMenuEficiencia = (Request request, Response response) -> {
		LoginController.ensureUserIsLoggedIn(request, response);
		Map<String, Object> model = new HashMap<>();

		return ViewHelper.render(request, model, "eficiencia.html");
	};
	
	
	public static Route clienteConsultaEficiencia = (Request request, Response response) -> {
		LoginController.ensureUserIsLoggedIn(request, response);
		Map<String, Object> model = new HashMap<>();
		String myUser = request.session().attribute("currentUser");

		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = dao.obtenerCliente(myUser);

		if(cliente.esEficiente(Integer.parseInt(getQueryMes(request)))) {
			
			
			model.put("eficiente", true);
			
		}else {
			
			model.put("noEficiente", true);
		}

		return ViewHelper.render(request, model, "eficiencia.html");
	};

}
