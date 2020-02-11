package datos;

import modelos.Peliculas;
import modelos.Socios;

import java.lang.Exception;
import modelos.Socios;
public interface IDatos {

	public void addPeliculas (Peliculas pelicula) throws Exception;
	public void listarPeliculas() throws Exception;

	public void addSocio(Socios socio) throws Exception;
}