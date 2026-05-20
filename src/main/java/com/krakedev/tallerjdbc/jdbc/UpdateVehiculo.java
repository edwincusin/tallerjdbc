package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.krakedev.tallerjdbc.entidades.Vehiculo;

public class UpdateVehiculo {

	private static Logger log = LoggerFactory.getLogger(UpdateVehiculo.class);
	
	public static boolean modificar(Vehiculo vehiculoNuevo, String placa){
		
		
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = Conexion.getConnection();
			String sql = """
					UPDATE vehiculos 
					SET marca=?, modelo=?, anio=?, precio=?, color=?, disponible=?, kilometraje=? 
					WHERE placa=?;
										""";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vehiculoNuevo.getMarca());
			ps.setString(2, vehiculoNuevo.getModelo());
			ps.setInt(3, vehiculoNuevo.getAnio());
			ps.setDouble(4, vehiculoNuevo.getPrecio());
			ps.setString(5, vehiculoNuevo.getColor());
			ps.setBoolean(6, vehiculoNuevo.isDisponible());
			ps.setInt(7, vehiculoNuevo.getKilometraje());
			
			ps.setString(8, placa); // PLACA
			
			int filasinsertadas = ps.executeUpdate();

			log.info("SE AGREGO FILAS "+filasinsertadas);
			log.info("VEHICULO ACTUALIZADO CON EXITO");
			
			return filasinsertadas >0 ?true :false;
			
		} catch (Exception e) {
			log.error("Error al ACTUALIZAR : " + e.getMessage());
			throw new RuntimeException("ERROR AL ACTUALIZAR VEHICULO ");
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
