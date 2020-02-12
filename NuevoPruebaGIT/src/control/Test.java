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
		
		ImpDatos datos = new ImpDatos();
		
		datos.modificarUsuario();
		
	}

}
