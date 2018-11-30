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
	
//Req simplex
	public static String getQuerySimplexPlayed(Request request) {
		return request.queryParams("simplexPlay");
	}
	
	public static String getQueryConsumoFecha(Request request) {
		return request.queryParams("fechaConsumo");
	}
    
//Requests ABM cliente
	
	
	public static String getQueryAgregarDispositivo(Request request) {
		return request.queryParams("agregarDispositivo");
	}
	
	public static String getQueryEliminarDispositivo(Request request) {
		return request.queryParams("eliminarDispositivo");
	}
	
	public static String getQueryEditarDispositivo(Request request) {
		return request.queryParams("editarDispositivo");
	}
	
	public static String getQueryBorrarDispositivo(Request request) {
		return request.queryParams("borrarDispositivo");
	}

//Request Reglas, sensores y actuadores	
	
	public static String getQueryRegla(Request request) {
		return request.queryParams("reglaNombre");
	}
	
	public static String getQueryCondicion(Request request) {
		return request.queryParams("reglaCondicion");
	}
	
	public static String getQueryFlag(Request request) {
		return request.queryParams("reglaFlag");
	}
	
	public static String getQueryActuador(Request request) {
		return request.queryParams("actuador");
	}
	
	public static String getQueryEliminarRegla(Request request) {
		return request.queryParams("eliminarRegla");
	}
	
	public static String getQueryEditarRegla(Request request) {
		return request.queryParams("editarRegla");
	}
	
	public static String getQueryJson(Request request) {
		return request.queryParams("json");
	}
	
	public static String getQueryMes(Request request) {
		return request.queryParams("mes");
	}
	
	public static String getQueryEncendido(Request request) {
		return request.queryParams("encenderDispositivo");
	}
	
	public static String getQueryApagado(Request request) {
		return request.queryParams("apagarDispositivo");
	}
}
