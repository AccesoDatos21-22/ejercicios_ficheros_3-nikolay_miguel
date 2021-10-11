package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import modelo.Alumno;
import modelo.Pokemon;

public class PokemonDAOImp implements PokemonDAO {

    private List<Pokemon> pokemones;
    private int numPokemones; // atributo para controlar el numero real de
    // elementos que tiene nuestro almacen

    /**
     * Constructor del Almacen con un determinado tamano
     *
     * @param tamano
     */
    public PokemonDAOImp(int tamano) {
        pokemones = new ArrayList<Pokemon>(tamano);
        numPokemones = tamano;
    }

    @Override
    public boolean estaVacio() {
        return false;
    }

    @Override
    public boolean estaLLeno() {
        return false;
    }


    @Override
    public void add(Pokemon pokemon) {

    }


    @Override
    public boolean eliminar(Pokemon pokemon) {
        return false;
    }


    @Override
    public void escribirPokemon(String ruta, String name, int life, int atack, int defense, int specialAttack, int specialdefense, int speed) {

    }


    @Override
    public void imprimirPokemon(String ruta) {

    }

    @Override
    public void escribirPokemon(String ruta, Pokemon pokemon) {

    }

    @Override
    public List<Pokemon> leerPokemon(String ruta) {
		List<Pokemon> listaP = null;
		String[] linea;
		try (BufferedReader br = new BufferedReader(new FileReader(ruta))){
			linea = br.readLine().split(";");
			Pokemon p1 = new Pokemon(linea[0],Integer.parseInt(linea[1]),Integer.parseInt(linea[2]),Integer.parseInt(linea[3]),Integer.parseInt(linea[4]),Integer.parseInt(linea[5]),Integer.parseInt(linea[6]),Integer.parseInt(linea[7]));
			listaP.add(p1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return listaP;
		}
    }

    @Override
    public List<Pokemon> leerPokemon(String ruta, String nombre) {
        return null;
    }
}
