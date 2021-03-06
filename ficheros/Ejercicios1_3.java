package ficheros;

import interfaces.InterfazEjercicios1_3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Escribe_aqui_tu_nombre
 * @date
 * @license GPLv3
 */
public class Ejercicios1_3 implements InterfazEjercicios1_3 {

    static Scanner sc = new Scanner(System.in);

    @Override
    public List<String> getFrases(Scanner escaner) {
        ArrayList<String> frases = new ArrayList<String>();

        boolean seguir = true;

        while (seguir) {
            System.out.println("Introduce una frase: ");
            frases.add(escaner.nextLine());

            System.out.println("¿Quieres introducir más frases? (1-Sí 2-No)");
            if (!(Integer.parseInt(sc.nextLine()) == 1)) {
                seguir = false;
            }
        }
        return frases;
    }

    @Override
    public Path getNombre(Scanner escaner) {
        System.out.println("Introduce el nombre del fichero (con la extensión .txt):");
        File fichero = new File(escaner.nextLine());

        Path ruta = null;

        if (String.valueOf(fichero.getPath()).endsWith(".txt")) {
            if (!fichero.exists()) {
                System.out.println("El fichero no existe...");
            } else {
                System.out.println("El fichero si que existe!!!");
                ruta = Path.of(fichero.getAbsolutePath());
            }
        } else {
            System.out.println("El fichero no tiene la extensión correcta...");
        }

        return ruta;
    }

    public void escribefrases(List<String> cadenas, Path ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta.toFile(), true))) {
            for(int i = 0; i < cadenas.size(); i++){
                bw.write(cadenas.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void leerFrases(Path ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta.toString()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void escribirFlotante(float numeroDecimal, String ruta) {
        File fichero = new File(ruta);
        try (DataOutputStream os = new DataOutputStream(new FileOutputStream(fichero,true))) {
            if (fichero.exists()) {
                os.writeFloat(numeroDecimal);
            } else if (!fichero.exists()) {
                fichero.createNewFile();
                os.write((int) numeroDecimal);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override
	public List<Float> leerFlotante(String ruta) {
		File f = new File(ruta);
		ArrayList<Float> listaF = new ArrayList<Float>();
		try(DataInputStream is = new DataInputStream(new FileInputStream(f))) {
            while (true) {
                listaF.add(is.readFloat());
            }
        } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (EOFException e) {

            } catch (IOException e) {
                e.printStackTrace();
            }
		return listaF;
	}

    @Override
    public void imprimirFlotante(String ruta) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(ruta))) {
            while (true) {
                System.out.println(dis.readFloat());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
