package modelos;

public enum CategoriaPeliculas {
	policiaca(1),
	romantica(2),
	aventura(3),
	comedia(4),
	animacion(5),
	thriller(6);
	
	private final int cod;
	
	private CategoriaPeliculas(int cod)
	{
		this.cod=cod;
	}
	public int getCod()
	{
		return cod;
	}

}
