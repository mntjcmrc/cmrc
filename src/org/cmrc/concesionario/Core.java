package org.cmrc.concesionario;

public class Core {
	private Modelos modelos;
	private Concesionarios concesionarios;
	
	// Contructor vacío
	public Core(){
		this.modelos = new Modelos();
		this.concesionarios = new Concesionarios();
	}
	
	// Getters y setters
	public Modelos getModelos() {
		return modelos;
	}
	public Concesionarios getConcesionarios() {
		return concesionarios;
	}
	public void setModelos(Modelos modelos) {
		this.modelos = modelos;
	}
	public void setConcesionarios(Concesionarios concesionarios) {
		this.concesionarios = concesionarios;
	}
	
	public void guardar(){
		this.modelos.guardar();
		this.concesionarios.guardar();
	}
	
	public void cargar(){
		this.modelos.cargar();
		this.concesionarios.cargar();
	}
	
	public String ver(String opcion){
		String datos = "";
		
		switch(opcion){
		
		case "modelo":
			if(modelos.hayModelos()){
				datos = modelos.devolverDatos();	
			} else {
				datos = "No hay modelos\n";
			}
			break;
			
		case "concesionario":
			if(concesionarios.hayConcesionarios()){
				datos = concesionarios.devolverDatos();
			} else {
				datos = "No hay concesionarios";
			}
			break;
		}
		
		return datos;
	}
}