package servicios;

import modelos.Peliculas;
import modelos.Socios;

public interface IServicios {
	
		public void addPeliculas(Peliculas pelicula) throws Exception;
		public void listarPeliculas() throws Exception;
		public void addSocios(Socios socio) throws Exception;


}