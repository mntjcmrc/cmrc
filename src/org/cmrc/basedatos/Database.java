package org.cmrc.basedatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

	private DMysql dm = new DMysql();
	private ResultSet rs = null;

	// Crea la conexión con la base de datos usando un objeto de tipo DMysql
	private void estableceConexion() {
		dm.connect("localhost:3306", "bdcoches", "root", "abc123ABC");
		try {
			dm.get_con().setTransactionIsolation(
					Connection.TRANSACTION_READ_COMMITTED);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Hace una consulta sacando todos los datos de la tabla table y
	// los carga en el vector datos
	public void cargaInicial(String table) {
		try {
			estableceConexion();
			rs = dm.query("select MATRICULA,MARCA,MODELO,COLOR,ANIO,PRECIO "
					+ " from " + table);

			while (rs.next()) {
				Coche coche = createCoche();
				if (coche != null) {
					// Fallo por no crear el vector, herp
					Datos.get_datos().add(coche);
				}
			}
			rs.close();
			dm.close();

			if (Datos.get_datos().size() != 0) {
				proceso.cargadatoscoches();
				proceso.hab_botones();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Vuelve a pedir los datos a la base de datos, limpia el vector datos y
	// lo carga con la nueva información
	public void reloadAll(String table) throws SQLException {
		rs = dm.query("select MATRICULA,MARCA,MODELO,COLOR,ANIO,PRECIO "
				+ " from " + table);
		Datos.get_datos().clear();
		while (rs.next()) {
			Coche coche = createCoche();
			if (coche != null) {
				Datos.get_datos().add(coche);
			}
		}
		rs.close();
		dm.close();
	}

	// Recarga el registro en el que se encuentra el usuario
	public void reloadRow(String table) throws SQLException {
		estableceConexion();
		rs = dm.query("select MATRICULA,MARCA,MODELO,COLOR,ANIO,PRECIO "
				+ " from " + table + " WHERE MATRICULA == '"
				+ Icoche.txtmatricula.getText() + "'");
		Coche coche = createCoche();
		if(coche != null){
			Datos.get_datos().set(Datos.get_position(), coche);
			proceso.cargadatoscoches();	
		} else {
			System.out.println("No se ha podido crear el coche");
		}
		rs.close();
		dm.close();
	}

	public void updateRow() {
		estableceConexion();
	
	}

	// Devuelve un objeto de tipo Coche con los datos de un registro de la
	// base de datos
	private Coche createCoche() throws SQLException {
		Coche coche = null;

		String matricula = "", marca = "", modelo = "", color = "";
		int anio = 0;
		float precio = 0;

		matricula = rs.getString("MATRICULA");
		marca = rs.getString("MARCA");
		modelo = rs.getString("MODELO");
		color = rs.getString("COLOR");
		anio = rs.getInt("ANIO");
		precio = rs.getFloat("PRECIO");

		coche = new Coche(matricula, marca, modelo, color, anio, precio);

		return coche;
	}
}