package datos;

import modelos.Peliculas;
import java.lang.Exception;
public interface IDatos {

	public void addPeliculas (Peliculas p) throws Exception;
	public void listarPeliculas() throws Exception;
}
