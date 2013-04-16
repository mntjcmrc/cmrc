package org.cmrc.basedatos;

import java.awt.EventQueue;

public class coches2 {
	public static Icoche fcoche;
	protected static Database bd;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				bd = new Database();
				bd.estableceConexion();
				try {
					fcoche = new Icoche();
					fcoche.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	);	
}
}
