package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
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

	public PokemonDAOImp() {

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
	public void escribirPokemon(String ruta, String name, int life, int atack, int defense, int specialAttack, int specialdefense, int speed){
		try {
			File ficheroPkms = new File(ruta);

			if(ficheroPkms.exists()){
				BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroPkms,true));
				bw.newLine();
				bw.write(name+";"+life+";"+atack+";"+defense+";"+specialAttack+";"+specialdefense+";"+speed);
				bw.close();
			}else if(ficheroPkms.createNewFile()){
				BufferedWriter bw1 = new BufferedWriter(new FileWriter(ficheroPkms));
				bw1.write(name+";"+life+";"+atack+";"+defense+";"+specialAttack+";"+specialdefense+";"+speed);
				bw1.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

    @Override
    public void imprimirPokemon(String ruta) {
        String[] linea = null;
        String[] datos = {"Name: ", "Life: ", "Attack: ", "Defense: ", "Special attack: ", "Special defense: ", "Speed: "};
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            linea = br.readLine().split(";");
            for (int i = 0; i < linea.length; i++) {
                System.out.println(datos[i] + linea[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
	public List<Pokemon> leerPokemon(String ruta, String nombre){
    return null;
  }
}
