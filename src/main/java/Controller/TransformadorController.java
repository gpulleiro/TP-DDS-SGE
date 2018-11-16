package Controller;
import static spark.Spark.*;

import java.util.*;

import Dao.ClienteDAO;
import Dao.DispositivoDAO;
import Dao.TransformadorDAO;
import Helpers.ViewHelper;
import Usuarios.Cliente;
import ZonaGeografica.Transformador;
import spark.Route;
import spark.ModelAndView;
import spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static Helpers.RequestHelper.*;

public class TransformadorController {
	
	    public static Route mapa = (Request request, Response response) -> {
	        Map<String, Object> model = new HashMap<>();
	        String myUser = request.session().attribute("currentUser");
	        ClienteDAO usuario = new ClienteDAO();
	        
	        TransformadorDAO dao = new TransformadorDAO();
	        
	        List<Transformador> transformadores = dao.obtenerTransformadores();
	        ArrayList<Transformador> trafosMapeados = new ArrayList<Transformador>();
	        
	        for (Transformador trafo:transformadores) {
	        	
	        	//cliente con el atributo necesario
	        	Transformador trafoMapeado = new Transformador(trafo.getId(),trafo.getCoordenadas(),trafo.consumoGenerico());
	        	trafoMapeado.setClientes(trafo.getClientes());
	        	
	        	trafosMapeados.add(trafoMapeado);
	        }
	        model.put("transformadores", trafosMapeados);
	        
	        if (usuario.recuperarPorUsername(myUser).esAdmin()) {
	        	
	        	request.session().attribute("isAdmin",true);
	        	return ViewHelper.render(request, model, "mapaAdmin.html");

	        }
	        else {
	        	request.session().attribute("isAdmin",false);
	        	return ViewHelper.render(request, model, "mapaCliente.html");
	        }
	        
	        
	    };

}


