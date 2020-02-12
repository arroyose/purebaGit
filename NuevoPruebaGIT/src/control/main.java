package control;

import datos.ImpDatos;

//import gui.Menu;

public class main {

	public static void main(String[] args) {
		//new movieflix().mostrarMovieflix();
		ImpDatos d = new ImpDatos();
		d.listarPeliculasPuedeVer(13);
	}

}