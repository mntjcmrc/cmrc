package org.cmrc.concesionario;

import org.cmrc.rutinas.Rutinas;

public class ModeloPromocionado extends Modelo  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4882006570674107792L;
	// Atributos
	private float _descuento;
	
	// Constructor vacío
	public ModeloPromocionado(){
		
	}

	// Getters y setters
	
	public float get_descuento() {
		return _descuento;
	}

	public void set_descuento(float _descuento) {
		this._descuento = _descuento;
	}
	
	// Pide los datos al usuario
	public void datos(Modelos modelos){
		int codigoModelo = -1;
		String descripcion = "";
		float pvp = 0;
		float descuento = 0;
		
		boolean error = true;
		
		while(error){
			error = false;
			codigoModelo = Rutinas.leeEntero("Introduce el codigo del modelo: ");
			if(modelos.existeModelo(codigoModelo)){
				error = true;
				System.out.println("El codigo introducido ya existe");
			}
		}
		descripcion = Rutinas.leeString("Introduce la descripción del modelo: ");
		pvp = Rutinas.leeFloat("Introduce el precio del modelo: ");
		descuento = Rutinas.leeFloat("introduce el descuento: ");
		
		this.set_codigoModelo(codigoModelo);
		this.set_descripcion(descripcion);
		this.set_pvp(pvp);
		this.set_descuento(descuento);
	
		modelos.add(this);
	}

	@Override
	public String toString() {
		return super.toString() + "Descuento: " + get_descuento() + "\n" ;
	}
	
}