package Controller;
import static spark.Spark.*;

import java.util.*;

import Dao.ClienteDAO;
import Dao.DispositivoDAO;
import Dao.TransformadorDAO;
import Helpers.ViewHelper;
import spark.Route;
import spark.ModelAndView;
import spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static Helpers.RequestHelper.*;

public class LoginController {
	

	    public static Route serveLoginPage = (Request request, Response response) -> {
	        Map<String, Object> model = new HashMap<>();
	        model.put("loggedOut", removeSessionAttrLoggedOut(request));
	        model.put("loginRedirect", removeSessionAttrLoginRedirect(request));

	        return ViewHelper.render(request, model, "login2.html");
	    };

	    public static Route handleLoginPost = (Request request, Response response) -> {
	        Map<String, Object> model = new HashMap<>();
	        if (!UsuarioController.authenticate(getQueryUsername(request), getQueryPassword(request))) {
	            model.put("authenticationFailed", true);
	            
	            return ViewHelper.render(request, model, "login2.html");
	        }
	        model.put("authenticationSucceeded", true);
	        request.session().attribute("currentUser", getQueryUsername(request));

	        if (getQueryLoginRedirect(request) != null) {
	            response.redirect(getQueryLoginRedirect(request));
	        }
	        
	        response.redirect("/home");
	        return null;

	    };

	    public static Route handleLogoutPost = (Request request, Response response) -> {
	        request.session().removeAttribute("currentUser");
	        request.session().attribute("loggedOut", true);
	        response.redirect("/login");
	        return null;
	    };

	    // The origin of the request (request.pathInfo()) is saved in the session so
	    // the user can be redirected back after login
	    public static void ensureUserIsLoggedIn(Request request, Response response) {
	        if (request.session().attribute("currentUser") == null) {
	            request.session().attribute("loginRedirect", request.pathInfo());
	            response.redirect("/login");
	        }
	    };
	    
	    public static Route index = (Request request, Response response) -> {
	        Map<String, Object> model = new HashMap<>();
	        TransformadorDAO dao = new TransformadorDAO();
	        model.put("transformadores", dao.obtenerTransformadores());
	        return ViewHelper.render(request, model, "index.html");
	    };

}


