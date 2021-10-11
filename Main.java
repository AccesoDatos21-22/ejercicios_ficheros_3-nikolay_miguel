
import dao.PokemonDAOImp;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import ficheros.Ejercicios1_3;
import modelo.Pokemon;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PokemonDAOImp poke = new PokemonDAOImp();

		System.out.println("------Ejercicio_1 Introducir pokemones------");
		poke.escribirPokemon("fichero.csv","Pikachu",0,0,0,0,0,0,0);
		poke.escribirPokemon("fichero.csv","Charmander",0,0,0,0,0,0,0);

		System.out.println();

		System.out.println("------Ejercicio_2 Imprimir fichero de pokemones------");
		poke.imprimirPokemon("fichero.csv");

		System.out.println();

		System.out.println("------Ejercicio del 3 al 6 refactorizado------");
		Ejercicios1_3 ejer = new Ejercicios1_3();
		Path ruta = ejer.getNombre(sc);
		if(!(ruta == null)){
			ArrayList <String> lista = (ArrayList<String>) ejer.getFrases(sc);
			ejer.escribefrases(lista, ruta);
		}

		System.out.println();

		System.out.println("------Ejercicio_8 Leer frases------");
		ejer.leerFrases(Path.of("ficheroTexto.txt"));

		System.out.println();

		System.out.println("------Ejercicio_9 Escribir Flotante------");
		ejer.escribirFlotante((float) 10.7, "ficheroFlotante.dat");
		ejer.escribirFlotante((float) 10.7, "ficheroFlotante.dat");
		ejer.escribirFlotante((float) 10.7, "ficheroFlotante.dat");

		System.out.println();

		System.out.println("------Ejercicio_10 Imprimir Flotante------");
		ejer.imprimirFlotante("ficheroFlotante.dat");

		System.out.println();

		System.out.println("------Ejercicio_11 Leer Flotante------");
		System.out.println(ejer.leerFlotante("ficheroFlotante.dat"));

		System.out.println();

		System.out.println("------Ejercicio_13 Escribir Pokemon------");
		Pokemon pk1 = new Pokemon("Charmander",0,0,0,0,0,0,0);
		poke.escribirPokemon("fichero.csv",pk1);

		System.out.println();

		System.out.println("------Ejercicio_14 Leer Pokemon------");
		System.out.println(poke.leerPokemon("fichero.csv"));

		System.out.println("");

		System.out.println("------Ejercicio_15 Leer Pokemon------");
		System.out.println(poke.leerPokemon("fichero.csv", "Pika"));
	}

}
