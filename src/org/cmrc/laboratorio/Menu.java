package org.cmrc.laboratorio;

import org.cmrc.rutinas.Rutinas;

public class Menu {

	private static void mostrarMenuP() {
		System.out.println("1 - Ver");
		System.out.println("2 - Crear");
		System.out.println("3 - Modificar");
		System.out.println("4 - Eliminar");
		System.out.println("5 - Guardar");
		System.out.println("6 - Cargar");
		System.out.println("0 - Salir");
	}

	private static void opcionesEstandar() {
		System.out.println("1 - Paciente");
		System.out.println("2 - Pacientes");
		System.out.println("3 - Medico");
		System.out.println("4 - Medicos");
		System.out.println("5 - Analisis");
		System.out.println("0 - Atrás");
	}

	public static void main(String[] args) {
		// Se usará para parar el programa
		boolean run = true;
		// Almacenará la última opción elegida por el usuario
		String opcion = "";
		// Señalará en el menú que se encuentra el usuario
		// p = Principal
		String menu = "p";

		// Objetos con los ArrayList
		Pacientes pacientes = new Pacientes();
		Medicos medicos = new Medicos();
		
		// Controlarán si hay pacientes 
		boolean pac = false;
		boolean med = false;

		while (run) {
			mostrarMenuP();
			if(!pac){
				pac = pacientes.hayPacientes();
			}
			if(!med){
				med = medicos.hayMedicos();
			}
			opcion = Rutinas.leeString("Elige una opción: ");
			switch (opcion) {
			case "1":
				menu = "ver";
				break;
			case "2":
				menu = "crear";
				break;
			case "3":
				menu = "modificar";
				break;
			case "4":
				menu = "eliminar";
				break;
			case "5":
				pacientes.guardar();
				medicos.guardar();
				break;
			case "6":
				pacientes.cargar();
				medicos.cargar();
				break;
			case "0":
				run = false;
				break;
			}

			// Así forzamos a que vuelva a empezar el loop y se cierre el
			// programa o vuelva a empezar
			// Estaría bien pensar una mejor forma para hacerlo
			if (!run || menu.equals("p")) {

			} else {
				opcionesEstandar();
				opcion = Rutinas.leeString("Elige una opción: ");
				boolean atras = false;
				switch (menu) {
				case "ver":
					atras = menuVer(pac, med, opcion, pacientes, medicos);
					break;
				case "crear":
//					menuCrear();
				}
				if(atras){
					menu = "p";
				}
			}
		}
		System.out.println("Fin del programa");
	}

	private static boolean menuVer(boolean pac, boolean med, String opcion, Pacientes pacientes, Medicos medicos) {
		String nif = "";
		boolean atras = false;
		
		String cod = "";
		switch(opcion){
		// Paciente
		case "1":
			if(!pac){
				System.out.println("No hay pacientes\n");
			} else {
				nif = Rutinas.leeString("Introduce el nif del paciente: ");
				System.out.println(pacientes.buscar(nif).toString());
			}
			break;
		// Pacientes
		case "2":
			if(!pac){
				System.out.println("No hay pacientes\n");
			} else {
				System.out.println(pacientes.devolverDatos());
			}
			break;
		// Medico
		case "3":
			if(!med){
				System.out.println("No hay médicos\n");
			} else {
				cod = Rutinas.leeString("Introduce el código del médico: ");
				System.out.println(medicos.buscar(cod).toString());
			}
			break;
		// Medicos
		case "4":
			if(!med){
				System.out.println("No hay médicos\n");
			} else {
				System.out.println(medicos.devolverDatos());
			}
			break;
		// Análisis
		case "5":
			
			break;
		case "0":
			atras = true;
			break;
		// Se crea uno nuevo
//		case "2":
//			paciente = new Paciente();
//			paciente.datos(pacientes);
//			break;
//		case "3":
//			nif = Rutinas.leeString("Introduce el nif del paciente: ");
//			paciente = pacientes.buscar(nif);
//			paciente.datos();
//			break;
		}
		return atras;
	}
}