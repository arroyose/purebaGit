package servicios;

import modelos.Peliculas;
import modelos.Socios;
public interface IServicios {
	
		public void addPeliculas(Peliculas p) throws Exception;
		public void listarPeliculas() throws Exception;
		public void addSocio(Socios s) throws Exception;
}
