package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertVehiculo {

	private static Logger log = LoggerFactory.getLogger(InsertVehiculo.class);

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = Conexion.getConnection();
			String sql = """
					INSERT INTO vehiculos (placa, marca, modelo, anio, precio, color, disponible)
					VALUES(?,?,?,?,?,?,?);
										""";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "THO1234");
			ps.setString(2, "TOYOTA");
			ps.setString(3, "COROLLA");
			ps.setInt(4, 2026);
			ps.setDouble(5, 20000);
			ps.setString(6, "GRIS");
			ps.setBoolean(7, true);
			
			int filas =ps.executeUpdate();
			
			log.info("Fila agregadas : "+filas);
			log.info("VEHICULO INSERTADO CON EXITO");

		} catch (Exception e) {
			log.error("Error al insertar : " + e.getMessage());
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
