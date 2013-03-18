package org.cmrc.concesionario;

import java.util.ArrayList;

import org.cmrc.rutinas.Rutinas;

public class Concesionario  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1836006377415745383L;
	// Atributos
	private int _codigoConcesionario; // de 01 a 52
	private ArrayList<Modelo> _modelos = new ArrayList<Modelo>();
	@SuppressWarnings("rawtypes")
	private ArrayList _cantidad = new ArrayList();

	// Constructor vacío
//	private Concesionario(){
//		
//	}

	// Getters y setters
	
	public int get_codigoConcesionario() {
		return _codigoConcesionario;
	}
	public ArrayList<Modelo> get_modelos() {
		return _modelos;
	}
	@SuppressWarnings("rawtypes")
	public ArrayList get_cantidad() {
		return _cantidad;
	}
	public void set_codigoConcesionario(int _codigoConcesionario) {
		boolean error = true;
		while(error){
			error = false;
			if(_codigoConcesionario < 1 || _codigoConcesionario > 52){
				error = true;
			} else {
				this._codigoConcesionario = _codigoConcesionario;				
			}
		}
	}
	public void set_modelos(ArrayList<Modelo> _modelos) {
		this._modelos = _modelos;
	}
//	public void set_cantidad(ArrayList _cantidad) {
//		this._cantidad = _cantidad;
//	}
	
	
	
	@Override
	public String toString() {
		return "Codigo concesionario: " + get_codigoConcesionario() + "\nModelos\n" + this.mostrarModelos();
	}
	
	// Devuelve una string con los datos de un concesionario
	public String devolverDatos(){
		String datos = "";
		ArrayList<Modelo> modelos = get_modelos();
		ArrayList cantidad = get_cantidad();
	
		for(int i = 0; i < modelos.size(); i++){
			datos += modelos.get(i).toString();
			datos += cantidad.get(i);
		}
		
		return datos;
	}
	
	public String mostrarModelos(){
		String sModelos = "";
		
		for(int i = 0; i < this._modelos.size(); i++){
			sModelos += this._modelos.get(i).toString();
		}
		
		return sModelos;
	}
			
	// Pide los datos al usuario
	public void datos(Concesionarios concesionarios){
		int codigoConcesionario = -1;
		
		boolean error = true;
		
		while(error){
			error = false;
			codigoConcesionario = Rutinas.leeEntero("Introduce el codigo del concesionario: ");
			if(concesionarios.existeConcesionario(codigoConcesionario)){
				error = true;
				System.out.println("El codigo introducido ya existe");
			}
		}

		this.set_codigoConcesionario(codigoConcesionario);
		
		concesionarios.add(this);
	}
	
	public void addModelo(Modelo modelo){
		this._modelos.add(modelo);
	}
	
	public Modelo buscarModelo(int codigo){
		Modelo modelo = new Modelo();
		
		for(int i = 0; i < this._modelos.size(); i ++){
			if(this._modelos.get(i).get_codigoModelo() == codigo){
				modelo = this._modelos.get(i);
			}
		}
		
		return modelo;
	}
	
	// Ventas de un concesionario
	public String ventas(){
		String ventas = "";
		
		for(int i = 0; i < this._modelos.size(); i++){
			ventas += this._modelos.get(i).toString() + "\n";
			ventas += "Vendidos: " + this._cantidad.get(i) + "\n";
		}
		
		return ventas;
	}
}