package ficheros;

import java.nio.file.Files;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interfaces.InterfazEjercicios1_3;

/**
 * 
 * @author Escribe_aqui_tu_nombre
 * @date 
 * @version 
 * @license GPLv3
 *
 */
public class Ejercicios1_3 implements InterfazEjercicios1_3 {

	static Scanner sc = new Scanner(System.in);

	@Override
	public List<String> getFrases(Scanner escaner) {
		ArrayList <String> frases = new ArrayList<String>();

		boolean seguir = true;

		while(seguir){
			System.out.println("Introduce una frase: ");
			frases.add(escaner.nextLine());

			System.out.println("¿Quieres introducir más frases? (1-Sí 2-No)");
			if(!(Integer.parseInt(sc.nextLine()) == 1)){
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

		if(String.valueOf(fichero.getPath()).endsWith(".txt")){
			if(!fichero.exists()){
				System.out.println("El fichero no existe...");
			} else{
				System.out.println("El fichero si que existe!!!");
				ruta = Path.of(fichero.getAbsolutePath());
			}
		}else{
			System.out.println("El fichero no tiene la extensión correcta...");
		}

		return ruta;
	}
	
	@Override
	public void escribefrases(List<String> cadenas, Path ruta) {
		try{
			Files.write(ruta, cadenas);
		} catch(Exception e){
			System.out.println(e.toString());
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(String.valueOf(ruta),true))){
			for(int i = 0; i < cadenas.size(); i++){
				bw.write(cadenas.get(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.toString();
		}

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
	public List<Float> leerFlotante(String ruta) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
		
		


}
