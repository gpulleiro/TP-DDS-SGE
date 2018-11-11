package Login;
import spark.*;
import java.util.*;
import Helpers.*;

public class HomeController {
	
	public static Route homeClientePage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        return ViewHelper.render(request, model, "homeCliente.html");
    };

}
