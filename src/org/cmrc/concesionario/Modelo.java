package org.cmrc.concesionario;

import org.cmrc.rutinas.Rutinas;

public class Modelo  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8670963995631518254L;
	// Atributos
	private int _codigoModelo;
	private String _descripcion;
	private float _pvp;

	// Constructor vacío
	public Modelo() {

	}

	// Getters y setters

	public int get_codigoModelo() {
		return _codigoModelo;
	}

	public String get_descripcion() {
		return _descripcion;
	}

	public float get_pvp() {
		return _pvp;
	}

	public void set_codigoModelo(int _codigoModelo) {
		this._codigoModelo = _codigoModelo;
	}

	public void set_descripcion(String _descripcion) {
		this._descripcion = _descripcion;
	}

	public void set_pvp(float _pvp) {
		this._pvp = _pvp;
	}

	@Override
	public String toString() {
		return "Codigo modelo: " + get_codigoModelo() + "\nDescripcion: "
				+ get_descripcion() + "\nPVP: " + get_pvp() + "\n";
	}

	// Pide los datos al usuario
	public void datos(Modelos modelos, Concesionarios concesionarios) {
		int codigoModelo = -1;
		String descripcion = "";
		float pvp = 0;

		boolean error = true;

		while (error) {
			error = false;
			codigoModelo = Rutinas
					.leeEntero("Introduce el codigo del modelo: ");
			if (modelos.existeModelo(codigoModelo)) {
				error = true;
				System.out.println("El codigo introducido ya existe");
			}
		}
		descripcion = Rutinas
				.leeString("Introduce la descripción del modelo: ");
		pvp = Rutinas.leeFloat("Introduce el precio del modelo: ");

		this.set_codigoModelo(codigoModelo);
		this.set_descripcion(descripcion);
		this.set_pvp(pvp);

		modelos.add(this);
		int codConc = -1;
		Concesionario concesionario = new Concesionario();
		codConc = Rutinas
				.leeEntero("Código del concesionario en el que se añadirá el coche: ");
		error = true;

		while (error) {
			error = false;
			if (concesionarios.existeConcesionario(codConc)) {
				concesionario = concesionarios.buscar(codConc);
			} else {
				error = true;
				System.out
						.println("Ese código no corresponde a ningún concesionario");
			}
		}
		
		
		concesionario.addModelo(this);
	}

}