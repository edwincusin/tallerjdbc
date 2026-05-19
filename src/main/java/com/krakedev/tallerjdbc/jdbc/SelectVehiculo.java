package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectVehiculo {

	private static Logger log = LoggerFactory.getLogger(SelectVehiculo.class);
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;

		try {
			con = Conexion.getConnection();
			String sql = """
					SELECT  * FROM vehiculos;
										""";
			ps = con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				String placa = rs.getString("placa");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anio = rs.getInt("anio");
				double precio= rs.getDouble("precio");
				String color = rs.getString("color");
				boolean disponible = rs.getBoolean("disponible");
				//placa, marca, modelo, anio, precio, color, disponible
				log.info("PLACA: "+placa+", MARCA: "+marca+", "+", MODELO: "+modelo+", AÑO: "+anio+", PRECIO: "+precio+", COLOR: "+color+", DISPONIBLE: "+disponible);
			}
			log.info("LISTA COMPLETA DE VEHICULOS");
		} catch (Exception e) {
			log.error("Error al consultar : " + e.getMessage());
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
