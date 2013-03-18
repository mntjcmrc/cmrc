package org.cmrc.rutinas;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rutinas {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);

	// Lee un entero cualquiera
	public static int generaaleatorio(int vini, int vfin) {
		// Números entre vini y vfin
		return (int) (Math.random() * (vfin - vini + 1) + vini);
	}

	public static boolean continuar() {

		String conti = "";
		conti = leeString("Deseas continuar...").toUpperCase();
		if (conti.substring(0, 1).equals("S"))
			return true;
		else
			return false;

	}

	public static String leeString(String mensaje) {
		boolean error = false;
		String fra = "";
		do {
			error = false;
			try {
				System.out.println(mensaje);
				fra = br.readLine();
			} catch (IOException io) {
				System.out.println("Atencion problemas al leer desde teclado "
						+ io.getMessage());
				error = true;
			}
		} while (error);

		return (fra);
	}

	public static double leeDoble(String mensaje) {
		boolean error = false;
		double num = 0;
		String n="";
		do {
			error = false;
			try {
				System.out.println(mensaje);
				n = br.readLine().replace(",", ".");
				num = Double.parseDouble(n);
			} catch (IOException io) {
				System.out.println("Atencion problemas al leer desde teclado "
						+ io.getMessage());
				error = true;
			} catch (NumberFormatException nfe) {
				System.out.println("Ojito no es un numero real ");
				error = true;
			}
		} while (error);

		return (num);
	}
	
	public static float leeFloat(String mensaje) {
		boolean error = false;
		float num = 0;
		String n="";
		do {
			error = false;
			try {
				System.out.println(mensaje);
				n = br.readLine().replace(",", ".");
				num = Float.parseFloat(n);
			} catch (IOException io) {
				System.out.println("Atencion problemas al leer desde teclado "
						+ io.getMessage());
				error = true;
			} catch (NumberFormatException nfe) {
				System.out.println("Ojito no es un numero float");
				error = true;
			}
		} while (error);

		return (num);
	}

	// Lee un entero entre limites
	public static int leeEntero(String mensaje, int Inf, int Sup) {
		boolean error = false;
		int num = 0;
		do {
			error = false;
			try {
				System.out.println(mensaje);
				num = Integer.parseInt(br.readLine());
				if (num < Inf | num > Sup) {
					System.out.println("Nmuero incorrecto. Debe estar entre "
							+ Inf + " y " + Sup);
					error = true;
				}

			} catch (IOException io) {
				System.out.println("Atencion problemas al leer desde teclado "
						+ io.getMessage());
				error = true;
			} catch (NumberFormatException nfe) {
				System.out.println("Ojito no es un numero entero ");
				error = true;
			}
		} while (error);

		return (num);
	}

	public static int leeEntero(String mensaje) {
		boolean error = false;
		int num = 0;
		do {
			error = false;
			try {
				System.out.println(mensaje);
				num = Integer.parseInt(br.readLine());
			} catch (IOException io) {
				System.out.println("Atencion problemas al leer desde teclado "
						+ io.getMessage());
				error = true;
			} catch (NumberFormatException nfe) {
				System.out.println("Ojito no es un numero entero ");
				error = true;
			}
		} while (error);

		return (num);
	}
	public static Date leeFecha(String mensa){
		Date fecha= new Date();
		boolean valida=false;
		do{
		String sfec =Rutinas.leeString(mensa);
		valida=Rutinas.isFechaValida( sfec , fecha);
		if (! valida){
			System.out.print("Fecha incorrecta");
		}
		} while (! valida);
	return fecha;
	
	}
	private static boolean isFechaValida(String fechax ,Date fecha) {
		
		try {
		SimpleDateFormat formatoFecha = new
		SimpleDateFormat("dd/MM/yyyy");
		formatoFecha.setLenient(false);
		fecha=formatoFecha.parse(fechax);
		} catch (ParseException e) {
		return false;
		}
		return true;
		}
	public static void muestraelemento(int indice, double array[]) {
		if (indice != array.length - 1)
			System.out.print(array[indice] + ", ");
		else
			System.out.print(array[indice] + "]");
	}

	public static void muestraelemento(int indice, int array[]) {
		if (indice != array.length - 1)
			System.out.print(array[indice] + ", ");
		else
			System.out.print(array[indice] + "]");
	}

	public static void muestraelemento(int indice, String array[]) {
		if (indice != array.length - 1)
			System.out.print(array[indice] + ", ");
		else
			System.out.print(array[indice] + "]");
	}
	 //metodo para validar correo electronico
    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            return true;
        }else{
            return false;
        }
    }

}
