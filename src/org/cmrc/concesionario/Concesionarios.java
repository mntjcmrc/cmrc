package org.cmrc.concesionario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.cmrc.rutinas.Rutinas;

public class Concesionarios {

	// Atributos
	private ArrayList<Concesionario> _concesionarios = new ArrayList<Concesionario>();
	
	// Constructor vacío
	public Concesionarios(){
		
	}

	// Getters y setters
	
	public ArrayList<Concesionario> get_concesionarios() {
		return _concesionarios;
	}

	public void set_concesionarios(ArrayList<Concesionario> _concesionarios) {
		this._concesionarios = _concesionarios;
	}
	
	// Guarda el ArrayList de modelos en un archivo llamado "concesionarios.obj"
	public void guardar(){
		ArrayList<Concesionario> modelos = this.get_concesionarios();
		if(modelos.size() == 0){
			System.out.println("No hay datos de concesionarios para guardar");
		} else {
			try {
				ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("concesionarios.obj"));
				salida.writeObject(modelos);
				salida.close();
				System.out.println("-- Concesionarios guardados con éxito --");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Carga el archivo "concesionarios.obj"
	@SuppressWarnings("unchecked")
	public void cargar() {
		File f = new File("concesionarios.obj");
		if (f.exists()) {
			try {
				ObjectInputStream entrada = new ObjectInputStream(
						new FileInputStream("concesionarios.obj"));
				this._concesionarios = (ArrayList<Concesionario>) entrada.readObject();
				entrada.close();
				System.out.println("-- Concesionarios cargados con éxito --");
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("El fichero de concesionarios no existe");
		}
	}
	// Comprueba si el concesionario del código dado existe
		public boolean existeConcesionario(int codigo) {
			boolean existe = false;
			
			ArrayList<Concesionario> concesionarios = get_concesionarios();
			int fin = concesionarios.size();
			for(int i = 0; i < fin; i++){
				if(concesionarios.get(i).get_codigoConcesionario() == codigo){
					existe = true;
				}
			}
			
			return existe;
		}
		
		// Añade el concesionario dado al ArrayList
		public void add(Concesionario concesionario){
			this._concesionarios.add(concesionario);
		}
		
		// Devuelve una string con los datos de todos los concesionarios
		public String devolverDatos(){
		String datos = "";
		ArrayList<Concesionario> concesionarios = get_concesionarios();
		
		for(int i = 0; i < concesionarios.size(); i++){
			datos += concesionarios.get(i).toString() + "\n";
		}
		
		return datos;
	}

	// Devuelve el concesionario
	public Concesionario buscar(int codigo){
		Concesionario concesionario = new Concesionario();
		ArrayList<Concesionario> concesionarios = this._concesionarios;
		
		if(existeConcesionario(codigo)){
			for(int i = 0; i < concesionarios.size(); i++){
				if(concesionarios.get(i).get_codigoConcesionario() == codigo){
					concesionario = concesionarios.get(i);
				}
			}
			return concesionario;
		} else {
			System.out.println("No existe un concesionario con ese código");
		}
		return concesionario;
	}
	
	// Comprueba si el ArrayList tiene concesionarios
	public boolean hayConcesionarios(){
		boolean hay = false;
		if(this._concesionarios.size() > 0){
			hay = true;
		}
		return hay;
	}
	
	public void pedido(){
		ArrayList<Concesionario> concesionarios = this._concesionarios;
		Concesionario concesionario = new Concesionario();
		Modelo modelo = new Modelo();
		
		int codConc = -1;
		int codMod = -1;
		
		codConc = Rutinas.leeEntero("Código del concesionario en el que se hará el pedido: ");
		concesionario = this.buscar(codConc);
		System.out.println(concesionario.toString());
		
		System.out.println(concesionario.mostrarModelos());
		codMod = Rutinas.leeEntero("Código del modelo a vender: ");
		modelo = concesionario.buscarModelo(codMod);
		
	}
	
	// Ventas totales de todos los concesionarios
	public String ventasTotales(){
		String ventas = "";
		
		for(int i = 0; i < this._concesionarios.size(); i++){
			ventas += this._concesionarios.get(i).ventas();
		}
		
		return ventas;
	}
}