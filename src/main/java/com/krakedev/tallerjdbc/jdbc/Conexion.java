package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Conexion {
	private static final Logger log=LoggerFactory.getLogger(Conexion.class);
	private static final String URL="jdbc:postgresql://localhost:5432/tallerjdbc";
	private static final String USER="postgres";
	private static final String PASS="pgadmin4";
	
	public static Connection getConnection() {
		Connection con=null;
		
		try {
			con=DriverManager.getConnection(URL,USER,PASS);
			log.info("CONEXION EXITOSA: ");
			return con;
		} catch (SQLException e) {
			log.error("ERROR DE CONEXION: "+e.getMessage());
			throw new RuntimeException("Nose pudo establecer la conexion");
		}	

	}
}
