package org.cmrc.concesionario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Modelos {
	
	// Atributos
	private ArrayList<Modelo> _modelos = new ArrayList<Modelo>();
	
	// Constructor vacío
	public Modelos(){
		
	}

	// Getters y setters
	
	public ArrayList<Modelo> get_modelos() {
		return _modelos;
	}

//	private void set_modelos(ArrayList<Modelo> _modelos) {
//		this._modelos = _modelos;
//	}
	
	// Guarda el ArrayList de modelos en un archivo llamado "modelos.obj"
	public void guardar(){
		ArrayList<Modelo> modelos = this.get_modelos();
		if(modelos.size() == 0){
			System.out.println("No hay datos de concesionarios para guardar");
		} else {
			try {
				ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("modelos.obj"));
				salida.writeObject(modelos);
				salida.close();
				System.out.println("-- Modelos guardados con éxito --");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Carga el archivo "modelos.obj"
	@SuppressWarnings("unchecked")
	public void cargar() {
		File f = new File("modelos.obj");
		if (f.exists()) {
			try {
				ObjectInputStream entrada = new ObjectInputStream(
						new FileInputStream("modelos.obj"));
				this._modelos = (ArrayList<Modelo>) entrada.readObject();
				entrada.close();
				System.out.println("-- Modelos cargados con éxito --");
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("El fichero de modelos no existe");
		}
	}
	
	// Comprueba si el modelo del código dado existe
	public boolean existeModelo(int codigo) {
		boolean existe = false;
		
		ArrayList<Modelo> modelos = get_modelos();
		int fin = modelos.size();
		for(int i = 0; i < fin; i++){
			if(modelos.get(i).get_codigoModelo() == codigo){
				existe = true;
			}
		}
		
		return existe;
	}
	
	// Añade el modelo dado al ArrayList
	public void add(Modelo modelo){
		this._modelos.add(modelo);
	}
	
	// Devuelve una string con los datos de todos los modelos
	public String devolverDatos(){
		String datos = "";
		ArrayList<Modelo> modelos = get_modelos();
		
		for(int i = 0; i < modelos.size(); i++){
			datos += modelos.get(i).toString();
		}
		
		return datos;
	}

	// Devuelve el modelo
	public Modelo buscar(int codigo){
		Modelo modelo = new Modelo();
		ArrayList<Modelo> modelos = this._modelos;
		
		if(existeModelo(codigo)){
			for(int i = 0; i < modelos.size(); i++){
				if(modelos.get(i).get_codigoModelo() == codigo){
					modelo = modelos.get(i);
				}
			}
			return modelo;
		} else {
			System.out.println("No existe un modelo con ese código");
		}
		return modelo;
	}
	
	// Comprueba si el ArrayList tiene modelos
	public boolean hayModelos(){
		boolean hay = false;
		if(this._modelos.size() > 0){
			hay = true;
		}
		return hay;
	}
	
	public String ventas(Concesionarios concesionarios){
		String ventas = "";
		Concesionario concesionario = new Concesionario();
		
		for(int i = 0; i < concesionarios.get_concesionarios().size(); i++){
			concesionario = concesionarios.get_concesionarios().get(i);
			for(int j = 0; j < this._modelos.size(); j++){
				
			}
		}
		
		return ventas;
	}
}