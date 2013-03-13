package org.cmrc.laboratorio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Pacientes {
	// ArrayList con los pacientes
	private ArrayList<Paciente> _pacientes;
	
	// Constructor vacío
	public Pacientes(){
		
	}

	// Getter y setter
	public ArrayList<Paciente> get_pacientes() {
		return _pacientes;
	}

//	public void set_pacientes(ArrayList<Paciente> pacientes) {
//		_pacientes = pacientes;
//	}
	
	public boolean existePaciente(String nif) {
		boolean existe = false;
		
		ArrayList<Paciente> pacientes = get_pacientes();
		int fin = pacientes.size();
		for(int i = 0; i < fin; i++){
			if(pacientes.get(i).get_nif() == nif){
				existe = true;
			}
		}
		
		return existe;
	}
	
	public void add(Paciente paciente){
		this._pacientes.add(paciente);
	}
	
	public void guardar(){
		ArrayList<Paciente> pacientes = this.get_pacientes();
		if(pacientes.size() == 0){
			System.out.println("No hay datos de pacientes para guardar");
		} else {
			try {
				ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("pacientes.obj"));
				salida.writeObject(pacientes);
				salida.close();
				System.out.println("-- Pacientes guardados con éxito --");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}