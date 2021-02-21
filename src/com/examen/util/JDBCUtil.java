package com.examen.util;

import java.sql.*;
public class JDBCUtil {
	/* MYSQL */
	String conxBd = "jdbc:mysql://localhost:3306/SEGUROSBD?useTimezOne=true&serverTimezone=UTC";
	String jdbcBd = "com.mysql.cj.jdbc.Driver";

	// Credenciales de Base de datos
	String userBd = "root";
	String passBd = "524566";

	Connection conexion;

	public JDBCUtil() {

		try {
			Class.forName(jdbcBd);
			conexion = DriverManager.getConnection(conxBd, userBd, passBd);
			if(conexion!= null) {
				DatabaseMetaData dm =(DatabaseMetaData) conexion.getMetaData();
				System.out.println(this.getClass().getName()+": Conexion correcta, !Perú, te quiero, por eso te defiendo¡");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public Connection getConexion() {
		return this.conexion;
	}
	
	// PARA PRUEBAS
	
	public static void main(String[] args) {
		JDBCUtil cn = new JDBCUtil();
	}
}
