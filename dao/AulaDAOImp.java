/**
 * AulaDAOImp.java
 *
 * @author Laura y Carlos
 * @version 1.0
 */

package dao;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import modelo.Alumno;

/**
 * @author Laura y Carlos
 * @version 1.0
 * @descrition AulaDAOImp
 * @date 18/9/2021
 * @license GPLv3
 */
public class AulaDAOImp implements AulaDAO {
    private List<Alumno> alumnos;
    private int numalumnos; // atributo para controlar el número real de
    // elementos que tiene nuestro almacén

    /**
     * Constructor del Almacén con un determinado tamano
     *
     * @param tamano
     */
    public AulaDAOImp(int tamano) {
        alumnos = new ArrayList<Alumno>(tamano);
        numalumnos = tamano;

    }

    /**
     * Comprueba si el almacén está vacio
     *
     * @return true si está vacio
     */
    public boolean estaVacio() {
        if (alumnos.isEmpty()) return true;
        else return false;
    }

    /**
     * Comprueba si el almacén está lleno
     *
     * @return
     */
    public boolean estaLLeno() {
        if (alumnos.get((numalumnos - 1)) != null) return true;
        else return false;
    }

    /**
     * Anade un nuevo elemento al almacén si hay sitio
     *
     * @param alumno a anadir al almacén
     */
    public void add(Alumno alumno) {
        alumnos.add(alumno);
    }

    /**
     * Elimina un elemento del almacén si está en el almacen
     *
     * @param alumno
     * @return true si elimina el elemento, false en caso contrario
     */
    public boolean eliminar(Alumno alumno) {
        alumnos.remove(alumno);
        return true;

    }

    /**
     * Imprime por pantalla los elementos del almacén
     */
    public void informacionAlumnos() {
        for (Alumno a : alumnos) {
            System.out.println(a.toString());
        }
    }

    /**
     * Método que escribe los alumnos en un archivo
     *
     * @param nombre
     */
    public void escribeAlumnos(String nombre) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombre, true))) {
            Files.write(Path.of(nombre), alumnos.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Método que lee alumnos de un archivo y los muestra por pantalla
     *
     * @param nombre
     */
    public void leeAlumnos(String nombre) {
        try {
            System.out.println(Files.readAllLines(Path.of(nombre)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
