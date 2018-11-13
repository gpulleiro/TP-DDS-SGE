package Controller;
import Helpers.ViewHelper;
import Repositorio.Repositorio;
import Usuarios.ClienteDAO;
import spark.Route;
import spark.ModelAndView;
import spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static Helpers.RequestHelper.*;

import java.util.*;
import java.util.stream.*;

import Dispositivo.Dispositivo;
import Dispositivo.DispositivoDAO;

public class DispositivosController {
		
		public static Route traerDispositivos = (Request request, Response response) -> {
	        LoginController.ensureUserIsLoggedIn(request, response);
//	        request.session().attribute("esAdmin");
	        HashMap<String, Object> model = new HashMap<>();
	        DispositivoDAO dao = new DispositivoDAO();
	        model.put("dispositivos", dao.obtenerDispositivos());

	        return ViewHelper.render(request, model, "dispositivos.html");
	        
	        
		};
		
}
