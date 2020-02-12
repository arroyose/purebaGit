package control;
//import gui.Menu;
import datos.ImpDatos;
public class main {

	public static void main(String[] args) {
		//new movieflix().mostrarMovieflix();

		ImpDatos prueba=new ImpDatos();
		prueba.listaPeliculasNoPuedeVer(13);
		System.out.println("He terminado");
	}

}