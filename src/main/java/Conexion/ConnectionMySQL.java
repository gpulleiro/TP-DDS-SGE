package Conexion;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionMySQL {

	private String dbHost;
	private String dbPort;
	private String dbName;
	private String dbUser;
	private String dbPass;
	
	public Connection getConnectionMySQL(){
		Connection objConexion = null;		
		try {
			this.cargarPropiedades();
			Class.forName("com.mysql.jdbc.Driver");
			//String strURL = "jdbc:mysql://"+this.dbHost+":"+this.dbPort+";DatabaseName="+this.dbName+";user="+this.dbUser+";password="+this.dbPass;
			String strURL = "jdbc:mysql://"+this.dbHost+":"+this.dbPort+"/"+this.dbName+"?useSSL=false";
			objConexion = DriverManager.getConnection(strURL,this.dbUser,this.dbPass);
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error al realizar la conexion");
		}
		return objConexion;
	}
	
	
	
	
	public void cargarPropiedades() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dbHost = properties.getProperty("dbhostSQL");
		this.dbPort = properties.getProperty("dbportSQL");
		this.dbName = properties.getProperty("dbnameSQL");
		this.dbUser = properties.getProperty("dbuserSQL");
		this.dbPass = properties.getProperty("dbpassSQL");
	}




}
