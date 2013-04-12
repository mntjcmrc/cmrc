package org.cmrc.basedatos;

import java.sql.*;

public class DMysql {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://";
	private Connection con = null;

	public Connection get_con() {
		return this.con;
	}

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

	public void update(String sentenciasql) {
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

	// Crea una base de datos en el servidor dado con el nombre proporcionado
	public void createDatabase(String server, String database, String user,
			String pass) {
		if (this.connect(server, "", user, pass)) {
			this.update("CREATE DATABASE " + database);
		}
	}

	// Crea una tabla en el servidor dado
	public void createTable(String server, String database, String user,
			String pass, String table) {
		if (this.connect(server, database, user, pass)) {
			this.update("CREATE TABLE " + table);
		}
	}

	public void close() {
		try {
			this.con.close();
		} catch (SQLException e) {
			System.out.println("Excepción capturada de SQL: " + e.toString());
		}
	}
}