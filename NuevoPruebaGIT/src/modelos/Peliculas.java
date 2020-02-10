package modelos;

public class Peliculas {

	private String nombre;
	private int year;
	private String sinopsis;
	private CategoriaPeliculas categoria;
	public Peliculas()
	{
		
	}
	public Peliculas(String nombre,int year,String sinopsis,CategoriaPeliculas cat)
	{
		this.nombre=nombre;
		this.year=year;
		this.sinopsis=sinopsis;
		this.categoria=cat;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String idPeliculas) {
		this.nombre = idPeliculas;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public CategoriaPeliculas getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaPeliculas categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Peliculas [nombre=" + nombre + ", year=" + year + ", sinopsis=" + sinopsis + ", categoria="
				+ categoria + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
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