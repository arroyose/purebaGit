package datos;

import modelos.Peliculas;
import modelos.Socios;

import java.lang.Exception;
import modelos.Socios;
/**
 * @author Fernando
 * 
 * <p> Interfaz datos
 * Fecha : 11/02/2020 </p>
 * 
 *@version 1.0.0
 *
 */
public interface IDatos {

	public void listadoUsuarios() throws Exception;
	public void addSocio(Socios socio) throws Exception;

    public void listadoPeliculasCategoria(int numCategoria) throws Exception;

}