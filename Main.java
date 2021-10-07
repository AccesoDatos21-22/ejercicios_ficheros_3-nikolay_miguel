import ficheros.Ejercicios1_3;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Ejercicios1_3 ejer = new Ejercicios1_3();
		Path ruta = ejer.getNombre(sc);
		if(!(ruta == null)){
			ArrayList <String> lista = (ArrayList<String>) ejer.getFrases(sc);
			ejer.escribefrases(lista, ruta);
		}

	}

}
