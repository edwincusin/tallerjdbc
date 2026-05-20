package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteVehiculo {
	private static Logger log = LoggerFactory.getLogger(DeleteVehiculo.class);

	public static boolean eliminar(String placa) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = Conexion.getConnection();
			String sql = """
					DELETE FROM vehiculos 
					WHERE placa=?;
					""";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, placa); // PLACA
			
			int filas =ps.executeUpdate();
			
			log.info("N° filas eliminadas : "+filas);
			log.info("VEHICULO FUE ELIMINADO CON EXITO");
			
			return filas>0?true:false;
			
		} catch (Exception e) {
			log.error("Error al eliminar : " + e.getMessage());
			throw new RuntimeException("ERROR AL ELIMINAR VEHICULO ");
		} finally {
			try {
				if (con != null) {
					con.close();
					log.info("CONEXION FINALIZADA");
				}					

			} catch (SQLException e) {
				log.error("Error al cerrar la conexion : " + e.getMessage());
			}
		}

	}

}
