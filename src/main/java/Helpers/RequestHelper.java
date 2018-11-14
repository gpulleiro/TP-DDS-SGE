package Helpers;

import spark.*;

public class RequestHelper {


    public static String getQueryUsername(Request request) {
        return request.queryParams("username");
    }

    public static String getQueryPassword(Request request) {
        return request.queryParams("password");
    }

    public static String getQueryLoginRedirect(Request request) {
        return request.queryParams("loginRedirect");
    }


    public static String getSessionCurrentUser(Request request) {
        return request.session().attribute("currentUser");
    }
    public static String getSessionIsAdmin(Request request) {
        return request.session().attribute("isAdmin");
    }

    public static boolean removeSessionAttrLoggedOut(Request request) {
        Object loggedOut = request.session().attribute("loggedOut");
        request.session().removeAttribute("loggedOut");
        return loggedOut != null;
    }

    public static String removeSessionAttrLoginRedirect(Request request) {
        String loginRedirect = request.session().attribute("loginRedirect");
        request.session().removeAttribute("loginRedirect");
        return loginRedirect;
    }
    
//Requests para el alta de dispositivo///
	public static String getQueryDispositivoName(Request request) {
		return request.queryParams("dispositivoNombre");
	}

	public static String getQueryDispositivoCantHoras(Request request) {
		return request.queryParams("dispositivoCantHoras");
	}

	public static String getQueryDispositivoMaxHoras(Request request) {
		return request.queryParams("dispositivoMaxHoras");
	}

	public static String getQueryDispositivoMinHoras(Request request) {
		return request.queryParams("dispositivoMinHoras");
	}

	public static String getQueryDispositivoConsumo(Request request) {
		return request.queryParams("dispositivoConsumo");
	}
	
	public static String getQueryTipoDispositivo(Request request) {
		return request.queryParams("tipo-dispositivo");
	}
    
    

}
