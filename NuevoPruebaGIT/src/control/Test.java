package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import datos.ImpDatos;
import modelos.Socios;

public class Test {
	
	public void inicializar() {
		
		ImpDatos objDatos = new ImpDatos();
		Socios socioPrueba = new Socios("German","Madrid");
		objDatos.addSocio(socioPrueba);
		
		
	}

}
