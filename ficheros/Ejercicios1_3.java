package ficheros;

import java.io.*;
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
	public List<Float> leerFlotante(String ruta) {
		File f = new File(ruta);
		ArrayList<Float> listaF = new ArrayList<Float>();
		try(DataInputStream is = new DataInputStream(new FileInputStream(f))){
			while(true){
				listaF.add(is.readFloat());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaF;
	}

	
	
		
		


}
