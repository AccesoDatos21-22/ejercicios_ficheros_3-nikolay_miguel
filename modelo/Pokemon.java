package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Pokemon {
    private String nombre;
    private int vida, ataque, defensa, ataqueS, defensaS, velocidad;

    public boolean existe(String ruta, String name, int ataque, int defensa, int ataqueS, int defensaS, int velocidad){
        try(BufferedReader fichero = new BufferedReader(new FileReader(ruta))){
            ArrayList <Pokemon> lista = new ArrayList<Pokemon>();

            int cont = 0;

            
        } catch(Exception e){
            System.out.println(e.toString());
        }
        return true;
    }
}
