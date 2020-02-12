package control;

import servicios.ImpServicios;
import utilidades.LecturaDeDatos;

import java.sql.SQLException;
import java.util.InputMismatchException;

import gui.Menu;
import modelos.CategoriaPeliculas;
import modelos.Peliculas;

public class movieflix {

	private ImpServicios servicios = new ImpServicios();

	public void mostrarMovieflix() {
//mostramos el menu inicial
		
		int seleccion = 0;
		boolean correcto = false;
		do {
			Menu.menuInicial();

			try {

				seleccion = LecturaDeDatos.leerInteger();
				correcto = true;
			} catch (InputMismatchException e) {

				correcto = false;
			}

			if (seleccion < 1 || seleccion > 2) {
				correcto = false;
				System.out.println("Introduce un numero correcto");
			}
		} while (!correcto);

		switch (seleccion) {

		case 1:
			int intentos = 2;
			boolean correcto1 = false;
			String usuario = "admin";
			String password = "admin";
			
			do {
				String usuarioIntroducido = LecturaDeDatos.leerString("Introduce Usuario: ");
				String passwordIntroducido = LecturaDeDatos.leerString("Introduce Contraseña: ");
			if(usuario.equals(usuarioIntroducido) && password.equals(passwordIntroducido)) {
			correcto1 = true;
				Menu.menuAdministrador(); // Muestra menu administrador

			this.menuAdmin2();
			}
			else {
				if (intentos >= 0) {
				System.out.println("Credenciales incorrectas, intentos restantes  " +intentos);
				intentos--;
				
			}else {
				System.exit(0);
			}}
			
			}while(!correcto1);
			break;

		case 2:
			Menu.menuUsuario();
			this.menuSocios2();
			break;
		}

	}

	public void menuAdmin2() {

		int seleccion = 0;
		boolean correcto = false;

		do {

			try {

				seleccion = LecturaDeDatos.leerInteger();
				correcto = true;
			} catch (InputMismatchException e) {

				correcto = false;
			}

			if (seleccion < 1 || seleccion > 2) {
				correcto = false;
				System.out.println("Introduce un numero correcto");
			}
		} while (!correcto);
		switch (seleccion) {

		case 1:
			Menu.menuAdministradorPeliculas(); // Muestra menu administrador para peliculas
			this.adminPeliculas();

			break;

		case 2:
			Menu.menuAdministradorUsuarios();

			break;
		}

	}

	public void adminPeliculas() {

		int seleccion = 0;
		boolean correcto = false;

		do {

			try {

				seleccion = LecturaDeDatos.leerInteger();
				correcto = true;
			} catch (InputMismatchException e) {

				correcto = false;
			}

			if (seleccion < 1 || seleccion > 3) {
				correcto = false;
				System.out.println("Introduce un numero correcto");
			}
		} while (!correcto);
		switch (seleccion) {

		case 1:
			// esta parte deberia estar englobada en un metodo

			Peliculas pelicula = new Peliculas();
			pelicula.setNombre(LecturaDeDatos.leerString("Introduzca el nombre"));
			pelicula.setSinopsis(LecturaDeDatos.leerString("Introduzca la sinopsis"));
			pelicula.setYear(LecturaDeDatos.leerInteger("Introduzca el año de estreno"));

			System.out.println("Seleccione la categoria");
			System.out.println("1- Policiaca");
			System.out.println("2- Romantica");
			System.out.println("3- Aventura");
			System.out.println("4- Comedia");
			System.out.println("5- Animacion");
			System.out.println("6- Thriller");

			int seleccionCategoria = LecturaDeDatos.leerInteger();
			switch (seleccionCategoria) {

			case 1:
				pelicula.setCategoria(CategoriaPeliculas.policiaca);
				break;

			case 2:
				pelicula.setCategoria(CategoriaPeliculas.romantica);
				break;

			case 3:
				pelicula.setCategoria(CategoriaPeliculas.aventura);
				break;

			case 4:
				pelicula.setCategoria(CategoriaPeliculas.comedia);
				break;

			case 5:
				pelicula.setCategoria(CategoriaPeliculas.animacion);
				break;

			case 6:
				pelicula.setCategoria(CategoriaPeliculas.thriller);
				break;
			}

			try {
				servicios.addPeliculas(pelicula);
			} catch (Exception e) {

				e.printStackTrace();
			}

			break;

		case 2:

			System.out.println("Servicio en construccion, disculpen las molestias");
			break;

		case 3:
			System.out.println("Servicio en construccion, disculpen las molestias");
			break;
		}

	}

	public void adminSocios() {

	}

	public void menuSocios2() {
		int seleccion = 0;
		boolean correcto = false;

		do {

			try {

				seleccion = LecturaDeDatos.leerInteger();
				correcto = true;
			} catch (InputMismatchException e) {

				correcto = false;
			}

			if (seleccion < 1 || seleccion > 5) {
				correcto = false;
				System.out.println("Introduce un numero correcto");
			}
		} while (!correcto);
		switch (seleccion) {

		case 1:
			try {
				servicios.listarPeliculas();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case 2:
			System.out.println("Seleccione la categoria");
			System.out.println("1- Policiaca");
			System.out.println("2- Romantica");
			System.out.println("3- Aventura");
			System.out.println("4- Comedia");
			System.out.println("5- Animacion");
			System.out.println("6- Thriller");
			try {
				try {
					servicios.listadoPeliculasCategoria(LecturaDeDatos.leerInteger());
				} catch (InputMismatchException e) {

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case 3:

			System.out.println("Servicio en construccion, disculpen las molestias");
			Menu.menuUsuario();
			this.menuSocios2();
			break;
		case 4:

			System.out.println("Servicio en construccion, disculpen las molestias");
			Menu.menuUsuario();
			this.menuSocios2();
			break;
			
		case 5:
			
			this.mostrarMovieflix();
		}
	}
}