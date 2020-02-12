package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

<<<<<<< HEAD
import utilidades.CargarFichero;
=======
>>>>>>> baae20291b615d13d906f8e236fc8133ecb59e74
import datos.ImpDatos;
import modelos.Socios;

public class Test {
	
<<<<<<< HEAD
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
=======
	public void inicializar() {
		
		ImpDatos objDatos = new ImpDatos();
		Socios socioPrueba = new Socios("German","Madrid");
		objDatos.addSocio(socioPrueba);
		
>>>>>>> baae20291b615d13d906f8e236fc8133ecb59e74
		
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
