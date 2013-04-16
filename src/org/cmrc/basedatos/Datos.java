package org.cmrc.basedatos;

import java.util.Vector;

public class Datos {

	private static Vector<Coche> datos = new Vector<Coche>();
	private static int position = 0;
	
	public static Vector<Coche> get_datos(){
		return datos;
	}
	
	public static int get_position(){
		return position;
	}
	
	public static void set_position(int position_){
		position = position_;
	}
}
