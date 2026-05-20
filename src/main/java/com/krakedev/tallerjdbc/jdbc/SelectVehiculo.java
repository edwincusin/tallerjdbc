package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.krakedev.tallerjdbc.entidades.Vehiculo;

public class SelectVehiculo {

	private static Logger log = LoggerFactory.getLogger(SelectVehiculo.class);

	public static ArrayList<Vehiculo> listar() {

		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = Conexion.getConnection();
			String sql = """
					SELECT  * FROM vehiculos;
										""";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				String placa = rs.getString("placa");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anio = rs.getInt("anio");
				double precio = rs.getDouble("precio");
				String color = rs.getString("color");
				boolean disponible = rs.getBoolean("disponible");
				int kilometraje = rs.getInt("kilometraje");
				// placa, marca, modelo, anio, precio, color, disponible, kilometraje
				log.info("PLACA: " + placa + ", MARCA: " + marca + ", " + ", MODELO: " + modelo + ", AÑO: " + anio
						+ ", PRECIO: " + precio + ", COLOR: " + color + ", DISPONIBLE: " + disponible
						+ ", KILOMETRAJE: " + kilometraje);

				Vehiculo vehiculo = new Vehiculo(placa, marca, modelo, anio, precio, color, kilometraje, disponible);
				vehiculos.add(vehiculo);

			}
			log.info("LISTA COMPLETA DE VEHICULOS");

			return vehiculos;
		} catch (Exception e) {
			log.error("Error al consultar : " + e.getMessage());
			throw new RuntimeException("ERROR AL CONSULTAR LISTA DE VEHICULOS");
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
	
	///
	///
	///
	///
	public static Vehiculo buscarPorPlaca(String placa) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = Conexion.getConnection();
			String sql = """
					SELECT  * FROM vehiculos
					WHERE placa=?;
										""";
			ps = con.prepareStatement(sql);
			ps.setString(1, placa);
			rs = ps.executeQuery();
			
			Vehiculo vehiculo =null;
			if (rs.next()) {

				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anio = rs.getInt("anio");
				double precio = rs.getDouble("precio");
				String color = rs.getString("color");
				boolean disponible = rs.getBoolean("disponible");
				int kilometraje = rs.getInt("kilometraje");
				// placa, marca, modelo, anio, precio, color, disponible, kilometraje
				log.info("PLACA: " + placa + ", MARCA: " + marca + ", " + ", MODELO: " + modelo + ", AÑO: " + anio
						+ ", PRECIO: " + precio + ", COLOR: " + color + ", DISPONIBLE: " + disponible
						+ ", KILOMETRAJE: " + kilometraje);

				vehiculo = new Vehiculo(placa, marca, modelo, anio, precio, color, kilometraje, disponible);	

			}
			log.info("VEHICULO ENCONTRADO CON LA PLACA "+placa);

			return vehiculo;
		} catch (Exception e) {
			log.error("Error al consultar por placa : " + e.getMessage());
			throw new RuntimeException("ERROR AL CONSULTAR VEHICULO POR PLACA");
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
