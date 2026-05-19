package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateVehiculo {

	private static Logger log = LoggerFactory.getLogger(UpdateVehiculo.class);
	
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = Conexion.getConnection();
			String sql = """
					UPDATE vehiculos 
					SET marca=?, modelo=?, anio=?, precio=?, color=?, disponible=? 
					WHERE placa=?;
										""";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "NISSAN");
			ps.setString(2, "FRONTIER");
			ps.setInt(3, 2020);
			ps.setDouble(4, 20000);
			ps.setString(5, "AZUL");
			ps.setBoolean(6, false);
			
			ps.setString(7, "HHH222"); // PLACA
			
			int filas =ps.executeUpdate();
			
			log.info("Filas actualizadas : "+filas);
			log.info("VEHICULO ACTUALIZADO CON EXITO");

		} catch (Exception e) {
			log.error("Error al ACTUALIZAR : " + e.getMessage());
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
