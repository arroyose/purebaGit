package servicios;

import modelos.Peliculas;
public interface IServicios {
	
		public void addPeliculas(Peliculas p) throws Exception;
		public void listarPeliculas() throws Exception;
		
}
