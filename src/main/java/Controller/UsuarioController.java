package Controller;
import static spark.Spark.*;

import Dao.ClienteDAO;
import Usuarios.Usuario;

public class UsuarioController {
	
		//ClienteDAO clieDAO = new ClienteDAO();
		
		public static boolean authenticate(String username, String password) {
//	        if (username.isEmpty() || password.isEmpty()) {
//	            return false;
//	        }
//			return true;

			ClienteDAO dao = new ClienteDAO();
			Usuario user = dao.recuperarPorUsername(username);
	        if (user == null) {
	            return false;
	        }else {
	        	return user.getContrasenia().equals(password.toString());
	        }
	        
/* Esto es para el HASHEO de la password, primero lo pruebo normal sin hashear        
 * String hashedPassword = BCrypt.hashpw(password, user.getSalt());
 * return hashedPassword.equals(user.getHashedPassword());*/
	    }

	    // This method doesn't do anything, it's just included as an example
	/*    public static void setPassword(String username, String oldPassword, String newPassword) {
	        if (authenticate(username, oldPassword)) {
	            String newSalt = BCrypt.gensalt();
	            String newHashedPassword = BCrypt.hashpw(newSalt, newPassword);
	            // Update the user salt and password
	        }
	
	    }
	*/	
	

}
