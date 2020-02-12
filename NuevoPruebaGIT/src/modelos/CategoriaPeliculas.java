package modelos;
/**
 * *
 * @author Eduardo Arroyo 
 * 
 * Enum para las categorias a las que puede pertenecer una pelicula
 *
 */

public enum CategoriaPeliculas {
	policiaca(1),
	romantica(2),
	aventura(3),
	comedia(4),
	animacion(5),
	thriller(6);
	
	private final int cod;
	/**
	 * Constructor del ENUM 
	 * @param Tiene como parametro el int del codigo de la categoria
	 * */
	private CategoriaPeliculas(int cod)
	{
		this.cod=cod;
	}
	/**
	 * Obtener el cod de un ENM categoria  
	 * @return Develve un INT con el codigo de la categoria
	 * */
	public int getCod()
	{
		return cod;
	}

}
