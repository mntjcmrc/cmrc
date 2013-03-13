package org.cmrc.laboratorio;

import org.cmrc.rutinas.Rutinas;

public class Medico implements java.io.Serializable {

	private static final long serialVersionUID = 47966467676619016L;

	// Atributos
	private String _codigo;
	private String _nombre;
		
	// Constructor vacío
	public Medico() {
	
	}
	
//	public Medico(String codigo, String nombre) {
//		super();
//		_codigo = codigo;
//		_nombre = nombre;
//	}

	//Getters y setters
	public String get_codigo() {
		return _codigo;
	}

	public String get_nombre() {
		return _nombre;
	}

	public void set_codigo(String _codigo) {
		this._codigo = _codigo;
	}

	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}
	
	@Override
	public String toString() {
		return "Código: " + get_codigo() + "\nNombre: " + get_nombre() + "\n";
	}
	
	// Pide los datos al usuario
	public void datos(Medicos medicos){
		String codigo = "";
		String nombre = "";
		
		boolean error = true;
		
		while(error){
			error = false;
			codigo = Rutinas.leeString("Introduce el codigo del médico: ");
			if(medicos.existeMedico(codigo)){
				error = true;
				System.out.println("El codigo introducido ya existe");
			}
		}
		nombre = Rutinas.leeString("Introduce el nombre del médico:");
		
		this.set_codigo(codigo);
		this.set_nombre(nombre);
		
		medicos.add(this);

	}
	
	// Pide los datos del médico para modificarlos
	// No se permite modificar el NIF
	public void datos(){
		String nombre = "";
		System.out.println(this.toString());
		
		nombre = Rutinas.leeString("Introduce el nuevo nombre del paciente: ");
		
		this.set_nombre(nombre);
	}
}
