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

public class ReportesController {
	
	public static Route reportes = (Request request, Response response) -> {
		LoginController.ensureUserIsLoggedIn(request, response);
		
		Map<String, Object> model = new HashMap<>();
        String myUser = request.session().attribute("currentUser");
        
        ReportesDAO reportes = new ReportesDAO();

        
        model.put("reportes1", reportes.generarReporte1());
        model.put("reportes2", reportes.generarReporte2());
        return ViewHelper.render(request, model, "reportes.html");
        
	};
       
        

        
        
    


}
