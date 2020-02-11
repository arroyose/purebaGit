package datos;

import modelos.Peliculas;
import java.lang.Exception;
import modelos.Socios;
public interface IDatos {

	public void addPeliculas (Peliculas p) throws Exception;
	public void listarPeliculas() throws Exception;
	public void addSocio(Socios s) throws Exception;
}
