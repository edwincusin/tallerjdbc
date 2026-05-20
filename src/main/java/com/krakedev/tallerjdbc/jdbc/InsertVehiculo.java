package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.krakedev.tallerjdbc.entidades.Vehiculo;

public class InsertVehiculo {

	private static Logger log = LoggerFactory.getLogger(InsertVehiculo.class);

	public static boolean insertar(Vehiculo vehiculo) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = Conexion.getConnection();
			String sql = """
					INSERT INTO vehiculos (placa, marca, modelo, anio, precio, color, disponible, kilometraje)
					VALUES(?,?,?,?,?,?,?,?);
										""";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vehiculo.getPlaca());
			ps.setString(2, vehiculo.getMarca());
			ps.setString(3, vehiculo.getModelo());
			ps.setInt(4, vehiculo.getAnio());
			ps.setDouble(5, vehiculo.getPrecio());
			ps.setString(6, vehiculo.getColor());
			ps.setBoolean(7, vehiculo.isDisponible());
			ps.setInt(8, vehiculo.getKilometraje());
			
			int filas =ps.executeUpdate();
			
			log.info("Fila agregadas : "+filas);
			log.info("VEHICULO INSERTADO CON EXITO");
			
			return filas >0 ? true :false;

		} catch (Exception e) {
			log.error("Error al insertar : " + e.getMessage());
			throw new RuntimeException("ERROR AL INSERTAR VEHICULO");
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
