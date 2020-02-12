package servicios;

import modelos.Peliculas;
import modelos.Socios;

/**@author Yuzhi
 *
 *<p> Interfaz servicios 
 *Fecha : 11/02/2020
 *@version 1.0.0
 *</p>
 */
public interface IServicios {
	
		public void addPeliculas(Peliculas pelicula) throws Exception;
		public void listarPeliculas() throws Exception;
		public void addSocios(Socios socio) throws Exception;
        public void listadoPeliculasCategoria(int numCategoria) throws Exception;
        public void listadoUsuarios() throws Exception;
        public void listarPeliculasMasVistas() throws Exception;
        public void modificarUsuario() throws Exception;
        public void eliminarUsuario(int id) throws Exception;
        public void listaPeliculasMasValoradas() throws Exception;

}