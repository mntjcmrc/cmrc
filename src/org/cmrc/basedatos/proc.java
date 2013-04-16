package org.cmrc.basedatos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

class proceso {
	public static void cargadatoscoches() throws SQLException {
		Icoche.txtmatricula.setText(Datos.get_datos().get(Datos.get_position())
				.get_matricula());
		Icoche.txtmarca.setText(Datos.get_datos().get(Datos.get_position())
				.get_marca());
		Icoche.txtmodelo.setText(Datos.get_datos().get(Datos.get_position())
				.get_modelo());
		Icoche.txtcolor.setText(Datos.get_datos().get(Datos.get_position())
				.get_color());
		Icoche.txtanio.setText(Datos.get_datos().get(Datos.get_position())
				.get_anio()
				+ "");
		Icoche.txtprecio.setText(Datos.get_datos().get(Datos.get_position())
				.get_precio()
				+ "");
	}

	public static void hab_botones() throws SQLException {
		if (Datos.get_position() == 0)
			Icoche.btnAnterior.setEnabled(false);
		else
			Icoche.btnAnterior.setEnabled(true);
		if (Datos.get_position() == Datos.get_datos().size() - 1)
			Icoche.btnsiguiente.setEnabled(false);
		else
			Icoche.btnsiguiente.setEnabled(true);
	}
}

class PulsarBoton implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource().equals(Icoche.btnAnterior))
				Datos.set_position(Datos.get_position() - 1);
			else if (e.getSource().equals(Icoche.btnsiguiente))
				Datos.set_position(Datos.get_position() + 1);
			else if (e.getSource().equals(Icoche.btnPrimero))
				Datos.set_position(0);
			else if (e.getSource().equals(Icoche.btnUltimo))
				Datos.set_position(Datos.get_datos().size() - 1);
			else if (e.getSource().equals(Icoche.btnmodificar))

				proceso.cargadatoscoches();
			proceso.hab_botones();

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(Icoche.frame,
					"Error en Base de Datos");
			e1.printStackTrace();
		}

	}
}
