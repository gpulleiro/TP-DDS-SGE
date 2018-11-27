package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Conexion.ConnectionMySQL;
import Reportes.Reporte1;
import Reportes.Reporte2;

public class ReportesDAO {

	public ArrayList<Reporte1> generarReporte1(){
		
		ConnectionMySQL objConexion = new ConnectionMySQL();		
		ArrayList<Reporte1> listaReporte = null;
		
		Reporte1 reporte = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;		
		
		String strQuery = "select U.ID_USU, U.NOMBRE, U.APELLIDO, C.fecha, SUM(D.CONS_FIJO * C.cant_horas) AS consumo from   usuario U join usuario_dispositivo UD on U.ID_USU = UD.USUARIO_ID_USU join dispositivo D  on UD.dispositivos_ID_DISP = D.ID_DISP join consumos C on UD.dispositivos_ID_DISP = C.id_dispositivo group by U.ID_USU, U.NOMBRE, U.APELLIDO, C.fecha;";
		try {
			con = objConexion.getConnectionMySQL();
			st = con.createStatement();
			rs = st.executeQuery(strQuery);			
			while(rs.next()) {
			 
				reporte = new Reporte1();
				
				reporte.setId_usuario(rs.getInt("U.ID_USU"));
				reporte.setNombre_usuario(rs.getString("U.NOMBRE"));
				reporte.setApellido_usuario(rs.getString("U.APELLIDO"));
	//			reporte.setId_dispositivo(rs.getInt("UD.dispositivos_ID_DISP"));
	//			reporte.setNombre_dispositivo(rs.getString("D.NOMBRE"));
				reporte.setFecha(rs.getString("C.fecha"));
				reporte.setConsumo(rs.getDouble("consumo"));
				
			if(listaReporte == null) {
					listaReporte = new ArrayList<Reporte1>();
				}
			
			listaReporte.add(reporte);
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(st != null){
					st.close();
				}				
				if(con != null) {
					con.close();
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		return listaReporte;
	}
	
	public ArrayList<Reporte2> generarReporte2(){
			
			ConnectionMySQL objConexion = new ConnectionMySQL();		
			ArrayList<Reporte2> listaReporte = null;
			
			Reporte2 reporte = null;
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;		
			
			String strQuery = "select U.ID_USU, U.NOMBRE, U.APELLIDO, D.TIPO, C.fecha, avg(D.CONS_FIJO * C.cant_horas) AS consumo_promedio from   usuario U join usuario_dispositivo UD on U.ID_USU = UD.USUARIO_ID_USU join dispositivo D  on UD.dispositivos_ID_DISP = D.ID_DISP join consumos C on UD.dispositivos_ID_DISP = C.id_dispositivo group by U.ID_USU, U.NOMBRE, U.APELLIDO, D.TIPO, C.fecha;";
			try {
				con = objConexion.getConnectionMySQL();
				st = con.createStatement();
				rs = st.executeQuery(strQuery);			
				while(rs.next()) {
				 
					reporte = new Reporte2();
					
					reporte.setId_usuario(rs.getInt("U.ID_USU"));
					reporte.setNombre_usuario(rs.getString("U.NOMBRE"));
					reporte.setApellido_usuario(rs.getString("U.APELLIDO"));
					reporte.setTipo(rs.getString("D.TIPO"));
					reporte.setFecha(rs.getString("C.fecha"));
					reporte.setConsumo(rs.getDouble("consumo_promedio"));
					
				if(listaReporte == null) {
						listaReporte = new ArrayList<Reporte2>();
					}
				
				listaReporte.add(reporte);
			}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(st != null){
						st.close();
					}				
					if(con != null) {
						con.close();
					}				
				} catch (Exception e) {
					e.printStackTrace();
				}			
			}
			return listaReporte;
	}
}