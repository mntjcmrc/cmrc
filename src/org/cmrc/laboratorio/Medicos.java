package org.cmrc.laboratorio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Medicos {

	// ArrayList con los médicos
	private ArrayList<Medico> _medicos;

	// Constructor vacío
	public Medicos() {

	}

	// Getters y setters
	public ArrayList<Medico> get_medicos() {
		return _medicos;
	}

	// public void set_medicos(ArrayList<Medico> _medicos) {
	// this._medicos = _medicos;
	// }

	public boolean existeMedico(String codigo) {
		boolean existe = false;

		ArrayList<Medico> medicos = get_medicos();
		int fin = medicos.size();
		for (int i = 0; i < fin; i++) {
			if (medicos.get(i).get_codigo() == codigo) {
				existe = true;
			}
		}

		return existe;
	}

	public void add(Medico medico) {
		this._medicos.add(medico);
	}

	public void guardar() {
		ArrayList<Medico> medicos = this.get_medicos();
		if (medicos.size() == 0) {
			System.out.println("No hay datos de médicos para guardar");
		} else {
			try {
				ObjectOutputStream salida = new ObjectOutputStream(
						new FileOutputStream("medicos.obj"));
				salida.writeObject(medicos);
				salida.close();
				System.out.println("-- Medicos guardados con éxito --");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void cargar() {
		File f = new File("medicos.obj");
		if (f.exists()) {
			try {
				ObjectInputStream entrada = new ObjectInputStream(
						new FileInputStream("medicos.obj"));
				this._medicos = (ArrayList<Medico>) entrada.readObject();
				entrada.close();
				System.out.println("-- Medicos cargados con éxito --");
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("El fichero no existe");
		}
	}
}
