package org.cmrc.basedatos;

public class Coche {
	private String _matricula;
	private String _marca;
	private String _modelo;
	private String _color;
	private int _anio;
	private float _precio;
	
//	public Coche(){
//		
//	}
	
	public Coche(String _matricula, String _marca, String _modelo,
			String _color, int _anio, float _precio) {
		this._matricula = _matricula;
		this._marca = _marca;
		this._modelo = _modelo;
		this._color = _color;
		this._anio = _anio;
		this._precio = _precio;
	}

	public String get_matricula() {
		return _matricula;
	}

	public String get_marca() {
		return _marca;
	}

	public String get_modelo() {
		return _modelo;
	}

	public String get_color() {
		return _color;
	}

	public int get_anio() {
		return _anio;
	}

	public float get_precio() {
		return _precio;
	}

	public void set_matricula(String _matricula) {
		this._matricula = _matricula;
	}

	public void set_marca(String _marca) {
		this._marca = _marca;
	}

	public void set_modelo(String _modelo) {
		this._modelo = _modelo;
	}

	public void set_color(String _color) {
		this._color = _color;
	}

	public void set_anio(int _anio) {
		this._anio = _anio;
	}

	public void set_precio(float _precio) {
		this._precio = _precio;
	}	
}