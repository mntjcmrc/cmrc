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

	// Comprueba que el código de un médico no existe ya en el ArrayList de
	// médicos
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

	// Añade el objeto de tipo Medico proporcionado al ArrayList
	// Usado para mantener privado el ArrayList
	public void add(Medico medico) {
		this._medicos.add(medico);
	}

	// Guarda el ArrayList de médicos en un archivo llamado "medicos.obj"
	// Cambiarlo para que guarde el archivo en una carpeta creada en la del
	// usuario llamada ".laboratiorio"
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

	// Carga el archivo "medicos.obj"
	// Cambiarlo para usar la carpeta ".laboratorio"
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
	
	public String devolverDatos(){
		String datos = "";
		ArrayList<Medico> medicos = get_medicos();
		
		for(int i = 0; i < medicos.size(); i++){
			datos += medicos.get(i).toString();
		}
		
		return datos;
	}
}