package ficheros;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import interfaces.InterfazEjercicios1_3;

/**
 * @author Escribe_aqui_tu_nombre
 * @date
 * @license GPLv3
 */
public class Ejercicios1_3 implements InterfazEjercicios1_3 {


    @Override
    public List<String> getFrases(Scanner escaner) {

        return null;
    }

    @Override
    public Path getNombre(Scanner escaner) {

        return null;
    }

    @Override
    public void escribefrases(List<String> cadenas, Path ruta) {


    }

    @Override
    public void leerFrases(Path ruta) {
        // TODO Auto-generated method stub

    }


    @Override
    public void escribirFlotante(float numeroDecimal, String ruta) {
        // TODO Auto-generated method stub

    }

    @Override
    public void imprimirFlotante(String ruta) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(ruta))){
            while (true){
                System.out.println(dis.readFloat());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Float> leerFlotante(String ruta) {
        // TODO Auto-generated method stub
        return null;
    }


}
