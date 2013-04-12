package org.cmrc.basedatos;

import java.sql.*;

public class DMysql {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://";
	private Connection con = null;

	// Conecta con una base de datos y devuelve true o false
	public boolean connect(String server, String database, String user,
			String pass) {
		boolean connect = false;
		url = url + server + "/" + database;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			connect = true;
		} catch (ClassNotFoundException e) {
			System.out.println("Controlador JDBC no encontrado: "
					+ e.toString());
		} catch (SQLException e) {
			System.out.println("Excepción capturada de SQL: " + e.toString());
		}

		return connect;
	}

	// Devuelve el ResultSet de la query dada
	public ResultSet query(String sentenciasql) {
		ResultSet rs = null;

		if (con == null) {
			return rs;
		} else {
			try {
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery(sentenciasql);
			} catch (SQLException e) {
				System.out.println("Excepción capturada de SQL: "
						+ e.toString());
			}
			return rs;
		}
	}
	
	public void update(String sentenciasql){
		if (this.con == null) {
			return;
		} else {
			try {
				Statement stmt = con.createStatement();
				stmt.executeUpdate(sentenciasql);
			} catch (SQLException e) {
				System.out.println("Excepción capturada de SQL: "
						+ e.toString());
			}
		}
	}
	
	// Muestra los datos de los conductores de la tabla FacturaMecanica de la
	// base de datos TallerMecanico
	public void showConductores(String server, String database, String user,
			String pass, String sentenciasql) {
		if (this.connect(server, database, user, pass)) {
			ResultSet rs = this.query(sentenciasql);
			try {
				while (rs.next()) {
					String conductores = rs.getString("Nombre");
					String marcas = rs.getString("Marca");
					int importes = rs.getInt("Importe");
					System.out.println("Conductor: " + conductores
							+ ". Marca: " + marcas + ". Importe: " + importes);
				}
			} catch (SQLException e) {
				System.out.println("Excepción capturada de SQL: "
						+ e.toString());
			} finally {
				try {
					if (this.con != null)
						this.con.close();
				} catch (SQLException e) {
					System.out.println("No se puede cerrar la conexión: "
							+ e.toString());
				}
			}
		}
	}
	
	// Crea una base de datos en el servidor dado con el nombre proporcionado
	public void createDatabase(String server, String database, String user, String pass){
		if(this.connect(server, "", user, pass)) {
			this.update("CREATE DATABASE " + database);
		}
	}
	
	public void createTable(String server, String database, String user, String pass, String table){
		if(this.connect(server, database, user, pass)) {
			this.update("CREATE TABLE " + table);
		}
	}
}