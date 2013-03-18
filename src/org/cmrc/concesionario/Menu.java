package org.cmrc.concesionario;

import org.cmrc.rutinas.Rutinas;

public class Menu {

	private static void mostrarMenuP() {
		System.out.println("1 - Ver");
		System.out.println("2 - Crear");
		System.out.println("3 - Guardar");
		System.out.println("4 - Cargar");
		System.out.println("0 - Salir");
	}

	private static void opcionesEstandar() {
		System.out.println("1 - Modelo");
		System.out.println("2 - Concesionario");
		System.out.println("3 - Pedido");
	}

	private static void opcionesVer() {
		System.out.println("1 - Modelo");
		System.out.println("2 - Modelos");
		System.out.println("3 - Concesionario");
		System.out.println("4 - Concesionarios");
		System.out.println("5 - Ventas de todos los concesionarios");
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
		Modelos modelos = new Modelos();
		Concesionarios concesionarios = new Concesionarios();

		// Se cargan los ArrayList
		modelos.cargar();
		concesionarios.cargar();

		// Controlarán si hay pacientes
		boolean modelo = false;
		boolean concesionario = false;

		while (run) {
			mostrarMenuP();
			if (!modelo) {
				modelo = modelos.hayModelos();
			}
			if (!concesionario) {
				concesionario = concesionarios.hayConcesionarios();
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
				modelos.guardar();
				concesionarios.guardar();
				menu = "p";
				break;
			case "4":
				modelos.cargar();
				concesionarios.cargar();
				menu = "p";
				break;
			case "0":
				run = false;
				break;
			}

			// Así forzamos a que vuelva a empezar el loop y se cierre el
			// programa o vuelva a empezar

			if (!run || menu.equals("p")) {

			} else {
				boolean atras = false;
				switch (menu) {
				case "ver":
					atras = menuVer(modelo, concesionario, modelos,
							concesionarios);
					break;
				case "crear":
					menuCrear(modelos, concesionarios);
				}
				if (atras) {
					menu = "p";
				}
			}
		}
		System.out.println("Fin del programa");
	}

	private static boolean menuVer(boolean mode, boolean conce,
			Modelos modelos, Concesionarios concesionarios) {
		String opcion = "";
		boolean atras = false;

		int codMode = -1;
		int codConc = -1;

		opcionesVer();
		opcion = Rutinas.leeString("Elige una opción: ");

		switch (opcion) {
		// Modelo
		case "1":
			if (!mode) {
				System.out.println("No hay modelos\n");
			} else {
				codMode = Rutinas.leeEntero("Introduce el código del modelo: ");
				Modelo modelo = modelos.buscar(codMode);
				if (modelo.get_codigoModelo() == -1) {

				} else {
					System.out.println(modelo.toString());
				}
			}
			break;
		// Modelos
		case "2":
			if (!mode) {
				System.out.println("No hay modelos\n");
			} else {
				System.out.println(modelos.devolverDatos());
			}
			break;
		// Concesionario
		case "3":
			if (!conce) {
				System.out.println("No hay médicos\n");
			} else {
				codConc = Rutinas
						.leeEntero("Introduce el código del concesionario: ");
				Concesionario concesionario = concesionarios.buscar(codConc);
				if (concesionario.get_codigoConcesionario() == -1) {

				} else {
					System.out.println(concesionario.toString());
				}
			}
			break;
		// Concesionarios
		case "4":
			if (!conce) {
				System.out.println("No hay concesionarios\n");
			} else {
				System.out.println(concesionarios.devolverDatos());
			}
			break;
		// Ventas por concesionario
		case "5":
			System.out.println(concesionarios.ventasTotales());
		case "0":
			atras = true;
			break;
		}
		return atras;
	}

	private static boolean menuCrear(Modelos modelos, Concesionarios concesionarios){
		String opcion = "";
		boolean atras = false;
		
		Modelo modelo = null;
		Concesionario concesionario = null;
		
		int codConc = -1;
		
		opcionesEstandar();
		opcion = Rutinas.leeString("Elige una opción: ");
		
		switch(opcion){
		//Modelo
		case "1":
			boolean error = true;
			String respuesta = "";
			while(error){
				error = false;
				respuesta = Rutinas.leeString("¿Modelo promocionado o no? (y/n)");
				if(respuesta.startsWith("y")){
					modelo = new ModeloPromocionado();
					modelo.datos(modelos, concesionarios);
				} else if(respuesta.startsWith("n")){
					modelo = new Modelo();
					modelo.datos(modelos, concesionarios);
				} else {
					error = true;
					System.out.println("Respuesta incorrecta, vuelve a responder");
				}
			}
			break;
		// Concesionario
		case "2":
			concesionario = new Concesionario();
			concesionario.datos(concesionarios);
			break;
		// Pedido
		case "3":
			codConc = Rutinas.leeEntero("Código del concesionario que hace el pedido: ");
			concesionario = concesionarios.buscar(codConc);
			System.out.println("Datos del concesionario");
			System.out.println(concesionario.toString());
			int codMod = Rutinas.leeEntero("Código del modelo a vender: ");
			int cantidad = Rutinas.leeEntero("Cantidad que se vende: ");
			modelo = concesionario.buscarModelo(codMod);
			int iCantidad = concesionario.get_modelos().indexOf(modelo);
			int cantidadOriginal = 0;
			if(!(concesionario.get_cantidad().size() < modelos.get_modelos().size())){
				cantidadOriginal = (int) concesionario.get_cantidad().get(iCantidad);	
			}
			concesionario.get_cantidad().add(iCantidad, cantidadOriginal + cantidad);
			System.out.println("Coste total:" + cantidad * modelo.get_pvp());
			break;
		}
		return atras;
	}
}