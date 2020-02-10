package control;

import java.io.FileNotFoundException;

import utilidades.ConexionDB;

public class Test {
	
	public void inicializar() {
		
		ConexionDB conexion = new ConexionDB();
		try {
			conexion.cargarFicheroDB();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
