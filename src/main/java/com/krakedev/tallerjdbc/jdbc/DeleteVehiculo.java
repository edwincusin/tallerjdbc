package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteVehiculo {
	private static Logger log = LoggerFactory.getLogger(DeleteVehiculo.class);

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = Conexion.getConnection();
			String sql = """
					DELETE FROM vehiculos 
					WHERE placa=?;
					""";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "HHH222"); // PLACA
			
			int filas =ps.executeUpdate();
			
			log.info("Fila eliminada : "+filas);
			log.info("VEHICULO ELIMINADO CON EXITO");

		} catch (Exception e) {
			log.error("Error al eliminar : " + e.getMessage());
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
