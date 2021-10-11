package ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
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
	public void escribefrases(String cadena,Path ruta){
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta.toFile(),true))){
			bw.append(cadena);
		} catch (IOException e) {
			e.printStackTrace();
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
