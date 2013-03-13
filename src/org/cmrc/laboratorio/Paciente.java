package org.cmrc.laboratorio;

import org.cmrc.rutinas.Rutinas;

public class Paciente implements java.io.Serializable {
	
	private static final long serialVersionUID = -6266004356461597963L;
	
	// Atributos
	private String _nif;
	private String _nombre;
	private String _direccion;
	
	// Constructor vacío
	public Paciente() {
		
	}
	
	// Constructor
//	private Paciente(String nif, String nombre, String direccion){
//		set_nif(nif);
//		set_nombre(nombre);
//		set_direccion(direccion);
//	}

	// Getters y setters
	public String get_nif() {
		return _nif;
	}

	public String get_nombre() {
		return _nombre;
	}

	public String get_direccion() {
		return _direccion;
	}

	public void set_nif(String _nif) {
		this._nif = _nif;
	}

	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}

	public void set_direccion(String _direccion) {
		this._direccion = _direccion;
	}

	@Override
	public String toString() {
		return "NIF: " + get_nif() + "\nNombre: " + get_nombre() + "\nDireccion: " + get_direccion() + "\n";
	}
	
	// Pide los datos al usuario
	public void datos(Pacientes pacientes){
		String nif = "";
		String nombre = "";
		String direccion = "";
		
		boolean error = true;
		
		while(error){
			error = false;
			nif = Rutinas.leeString("Introduce el nif del paciente: ");
			if(pacientes.existePaciente(nif)){
				error = true;
				System.out.println("El nif introducido ya existe");
			}
		}
		nombre = Rutinas.leeString("Introduce el nombre del paciente:");
		direccion = Rutinas.leeString("Introduce la dirección del paciente:");
		
		this.set_nif(nif);
		this.set_nombre(nombre);
		this.set_direccion(direccion);
		
		pacientes.add(this);
	}
}