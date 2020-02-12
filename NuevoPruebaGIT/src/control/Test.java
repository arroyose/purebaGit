package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import utilidades.CargarFichero;
import datos.ImpDatos;
import modelos.Socios;

public class Test {
	
	public void crearSocio() {
		ImpDatos objDatos = new ImpDatos();
		Socios socioPrueba = new Socios("German","Madrid");
		objDatos.addSocio(socioPrueba);
	}
	
	public void inicializar() {	
		try {
			CargarFichero objCargar = new CargarFichero(new FileReader(new File("peliculas_numCat.txt")));
			objCargar.cargarFichero();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void listarUsuario() {
		ImpDatos objDatos = new ImpDatos();
		try {
			objDatos.listadoUsuarios();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
