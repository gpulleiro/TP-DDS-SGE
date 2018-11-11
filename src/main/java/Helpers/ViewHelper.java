package Helpers;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.*;
import spark.TemplateViewRoute;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.template.handlebars.*;
import java.util.*;

import static Helpers.RequestHelper.*;

public class ViewHelper {
	
    public static String render(Request request, Map<String, Object> model, String templatePath) {
//        model.put("msg", new MessageBundle(getSessionLocale(request)));
        model.put("currentUser", getSessionCurrentUser(request));
//        model.put("WebPath", Path.Web.class); // Access application URLs from templates
        return handlebarsEngine().render(new ModelAndView(model, templatePath));
    }
    
    private static TemplateEngine handlebarsEngine() {
        HandlebarsTemplateEngine configuredEngine = new HandlebarsTemplateEngine();
        
        return configuredEngine;
    }

}
