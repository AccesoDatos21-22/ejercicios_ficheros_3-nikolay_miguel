package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	public void escribirPokemon(String ruta, String name, int level, int life, int atack, int defense, int specialAttack, int specialdefense, int speed){
		try {
			File ficheroPkms = new File(ruta);
            Pokemon temp = new Pokemon();

            int cont = 0;

			if(ficheroPkms.exists()){
                try{
                    BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroPkms,true));
                    bw.newLine();
                    bw.write(name+";"+level+";"+life+";"+atack+";"+defense+";"+specialAttack+";"+specialdefense+";"+speed);
                    bw.close();
                }catch(Exception e) {
                    System.out.println(e.toString());
                }
            }else if(ficheroPkms.createNewFile()){
				BufferedWriter bw1 = new BufferedWriter(new FileWriter(ficheroPkms));
                bw1.write(name+";"+level+";"+life+";"+atack+";"+defense+";"+specialAttack+";"+specialdefense+";"+speed);
				bw1.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

    @Override
    public void imprimirPokemon(String ruta) {
        String[] linea = null;
        String[] datos = {"Name: ", "Level: ","Life: ", "Attack: ", "Defense: ", "Special attack: ", "Special defense: ", "Speed: "};
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            linea = br.readLine().split(";");
            while(linea != null){
                for (int i = 0; i < linea.length; i++) {
                    System.out.println(datos[i] + linea[i]);
                }
                linea = br.readLine().split(";");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            System.out.println("Final del fichero");
        }

    }

    @Override
    public List<Pokemon> leerPokemon(String ruta) {
		List<Pokemon> listaP = new ArrayList<>();
		String[] linea;
		try (BufferedReader br = new BufferedReader(new FileReader(ruta))){
			String seguir = br.readLine();
            while(seguir != null){
                linea = seguir.split(";");
                Pokemon temp = new Pokemon(linea[0],Integer.parseInt(linea[1]),Integer.parseInt(linea[2]),Integer.parseInt(linea[3]),Integer.parseInt(linea[4]),Integer.parseInt(linea[5]),Integer.parseInt(linea[6]),Integer.parseInt(linea[7]));
                listaP.add(temp);
                seguir = br.readLine();
            }
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
        try(BufferedReader br = new BufferedReader(new FileReader(ruta))){
            ArrayList<String> lista = new ArrayList<>();

            String linea = br.readLine();

            int contP = 0;

            while(linea != null){
                String[] pokemones = linea.split(";");
                lista.add(pokemones[0]);
                linea = br.readLine();
                contP++;
            }

            int cont = 0;

            for(int i = 0; i < contP; i++){
                if(lista.get(i).equals(pokemon.getName())){
                   cont++;
                }
            }

            if(cont == 0){
                BufferedWriter bw = new BufferedWriter(new FileWriter(ruta,true));
                bw.newLine();
                bw.write(pokemon.getName()+";"+pokemon.getLevel()+";"+pokemon.getLife()+";"+pokemon.getAttack()+";"+pokemon.getDefense()+";"+pokemon.getSpecialAttack()+";"+pokemon.getSpecialDefense()+";"+pokemon.getSpeed());
                bw.close();
            }
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

  @Override
	public List<Pokemon> leerPokemon(String ruta, String nombre){
      List<Pokemon> listaFinal = new ArrayList<>();
      try(BufferedReader br = new BufferedReader(new FileReader(ruta))){
          ArrayList<Pokemon> lista = new ArrayList<>();

          String linea = br.readLine();

          int cont = 0;

          while(linea != null){
              String[] pokemones = linea.split(";");
              Pokemon temp = new Pokemon(pokemones[0],Integer.parseInt(pokemones[1]),Integer.parseInt(pokemones[2]),Integer.parseInt(pokemones[3]),Integer.parseInt(pokemones[4]),Integer.parseInt(pokemones[5]),Integer.parseInt(pokemones[6]),Integer.parseInt(pokemones[7]));
              lista.add(temp);
              cont++;
              linea = br.readLine();
          }

          for(int i = 0; i < cont; i++){
              if(lista.get(i).getName().contains(nombre)){
                  listaFinal.add(lista.get(i));
              }
          }

      } catch (Exception e){
          System.out.println(e.toString());
      }
    return listaFinal;
  }
}
