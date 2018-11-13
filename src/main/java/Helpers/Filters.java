package Helpers;

import spark.*;
import static Helpers.RequestHelper.*;

public class Filters {

	// Si el usuario cambia el path y se olvida de  agregar "/" redirije al usuario al path correcto
    public static Filter addTrailingSlashes = (Request request, Response response) -> {
        if (!request.pathInfo().endsWith("/")) {
            response.redirect(request.pathInfo() + "/");
        }
    };


}

