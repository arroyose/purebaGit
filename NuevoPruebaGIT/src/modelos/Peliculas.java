package modelos;

/**
 * @author Yuzhi
 * <p> Esta clase define el objecto pelicula donde contiene el nombre de la pelicula, el año, la sinopsis y la categoria </p>
 * 
 * @version 1.0.0
 * 
 * 
 */
public class Peliculas {

	private String nombre;
	private int year;
	private String sinopsis;
	private CategoriaPeliculas categoria;
	
	/**
	 * Constructor sin parametros para la calse peliculas
	 * 
	 * */
	public Peliculas(){
		
	}
	
	/**
	 * Constructor con todos los parametros para la calse peliculas
	 * @param nombre  El parametro nombre, define el nombre de una pelicula y sera de tipo String
	 * @param year  El parametro year, define el año en el que se publico la pelicula y sera de tipo int
	 * @param sinopsis El parametro sinopsis, define el nombre de una pelicula y sera de tipo String
	 * @param cat El parametro cat, define la categoria de una pelicula y sera de tipo Enum CategoriaPeliculas
	 * */
	public Peliculas(String nombre,int year,String sinopsis,CategoriaPeliculas cat){
		this.nombre=nombre;
		this.year=year;
		this.sinopsis=sinopsis;
		this.categoria=cat;
	}
	/**
	 * getNombre Metodo que nos dara el nombre de la pelicula 
	 * @return Nombre de la pelicula 
	 * */
	public String getNombre() {
		return nombre;
	}
	/**
	 * setNombre Metodo cambiara el nombre de la pelicula en el objeto 
	 * @param Nombre de la pelicula 
	 * */
	public void setNombre(String idPeliculas) {
		this.nombre = idPeliculas;
	}

	/**
	 * getYear Metodo que nos dara el año de la pelicula 
	 * @return Year tipo entero con el año de la pelicula
	 * */
	public int getYear() {
		return year;
	}
	/**
	 * setYear Metodo que cambiaraa el año de la pelicula 
	 * @param year  tipo entero con el año de la pelicula
	 * */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * getSinopsis Metodo que nos dara la siopsis de la pelicula 
	 * @return sinopsis de la pelicula como tipo String 
	 * */
	public String getSinopsis() {
		return sinopsis;
	}
	/**
	 * setSinopsis Metodo que cambiara la siopsis de la pelicula 
	 * @param sinopsis de la pelicula como tipo String 
	 * */
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	/**
	 * getCategoria Metodo que nos dara la Categoria de la pelicula 
	 * @return CategoriaPelicula de la pelicula como tipo Enum CategoriaPelicula 
	 * */
	public CategoriaPeliculas getCategoria() {
		return categoria;
	}
	/**
	 * setCategoria Metodo cambiara la Categoria de la pelicula 
	 * @param categoria CategoriaPelicula de la pelicula como tipo Enum CategoriaPelicula 
	 * */
	public void setCategoria(CategoriaPeliculas categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * toString Metodo sobre esrito para la impresion de una pelicula 
	 *  
	 * */
	@Override
	public String toString() {
		return "Peliculas [nombre=" + nombre + ", year=" + year + ", sinopsis=" + sinopsis + ", categoria="
				+ categoria + "]";
	}
	/**
	 * hasCode Metodo sobre esrito hasCode 
	 *  
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	/**
	 * equals Metodo sobreesrito para comparacion de objetos de la clase peliculas
	 *  
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Peliculas other = (Peliculas) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}