package gui;

public class Menu {

	
	
	public static void menuInicial() {
		
		
		System.out.println("|   |   |  Bienvenidos a MOVIEFLIX   |   |   |");
        System.out.println(" ");
        System.out.println("************************************************");
        System.out.println("*        Por favor, escoge una opcion: ");
        System.out.println("*        1.-Acceder como administrador");
        System.out.println("*        2.-Acceder como usuario");
	}
	
	
	
	
	public static void menuAdministrador() {
		System.out.println("************************************************");
        System.out.println("*        Bienvenido Administrador");
        System.out.println("*        1.- Gestionar Peliculas");
        System.out.println("*        2.- Gestionar Usuarios");
		
	}
	
	
	public static void menuAdministradorPeliculas() {
		System.out.println("************************************************");
        System.out.println("*        1.- Añadir Pelicula ");
        System.out.println("*        2.- Añadir Sinopsis");
        System.out.println("*        3.- Eliminar Pelicula");
		
	}
	
    public static void menuAdministradorUsuarios() {
    	System.out.println("************************************************");
        System.out.println("*        1.- Añadir Socio ");
        System.out.println("*        2.- Modificar Socio");
        System.out.println("*        3.- Eliminar Socio");
		
	}
	public static void menuUsuario() {
		
		System.out.println("************************************************");
        System.out.println("*        1.- Listar todas las peliculas ");
        System.out.println("*        2.- Listar peliculas por categoria");
        System.out.println("*        3.- Listar Peliculas que puedo ver");
        System.out.println("*        4.- Listar Peliculas que no puedo ver");
        System.out.println("         5.- Volver al menu principal");
	}
}
