package dao;

import java.io.*;
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
	public boolean estaVacio(){
    return false;
  }

	@Override
	public boolean estaLLeno(){
    return false;
  }


	@Override
	public void add(Pokemon pokemon) {

  }


  @Override
	public boolean eliminar(Pokemon pokemon){
    return false;
  }


	@Override
	public void escribirPokemon(String ruta, String name, int life, int atack, int defense, int specialAttack, int specialdefense, int speed){

  }
	
	
	@Override
	public void imprimirPokemon (String ruta){

  }
	
	@Override
	public void escribirPokemon(String ruta, Pokemon pokemon){
		File f = new File(ruta);
		try(ObjectOutputStream fichero = new ObjectOutputStream(new FileOutputStream(f,true))){
			if(!f.exists()){
				System.out.println("El fichero no existe...");
			} else if(f.exists()){
				fichero.writeObject(pokemon);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Pokemon> leerPokemon(String ruta){
    return null;
  }

  @Override
	public List<Pokemon> leerPokemon(String ruta, String nombre){
    return null;
  }
}
