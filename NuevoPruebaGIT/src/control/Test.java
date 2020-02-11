package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import utilidades.CargarFichero;

public class Test {
	
	public void inicializar() {
		
		try {
			CargarFichero objCargar = new CargarFichero(new FileReader(new File("peliculas_numCat.txt")));
			objCargar.cargarFichero();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
