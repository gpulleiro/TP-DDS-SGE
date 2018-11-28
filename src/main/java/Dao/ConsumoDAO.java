package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Conexion.ConnectionMySQL;

public class ConsumoDAO {

	@SuppressWarnings("null")
	public double ObtenerConsumo (int mes, int dni) throws SQLException{
		
		ConnectionMySQL objConexion = new ConnectionMySQL();		
		
		double consumo = 0;
		Connection con = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;		

		String strQuery = "select SUM(D.CONS_FIJO * C.cant_horas) AS consumo from usuario U join usuario_dispositivo UD on U.ID_USU = UD.USUARIO_ID_USU join dispositivo D  on UD.dispositivos_ID_DISP = D.ID_DISP join consumos C on UD.dispositivos_ID_DISP = C.id_dispositivo where month(C.fecha) = " + mes + " and U.NUM_DOC = " + dni + " group by U.NUM_DOC;";
		
		try {
			con = objConexion.getConnectionMySQL();
			st = con.createStatement();
//			
//			pst = con.prepareStatement(strQuery);
//			
//			pst.setInt(1, mes);
//			pst.setInt(2, dni);
		
			rs = st.executeQuery(strQuery);
			while(rs.next()) {
			consumo = rs.getDouble("consumo");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(" \n fallo la query");
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
		
		return consumo;
			
		
	}
	
	
}
