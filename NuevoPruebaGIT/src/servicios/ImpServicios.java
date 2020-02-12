package servicios;
import datos.IDatos;
import datos.ImpDatos;
import modelos.Peliculas;
import modelos.Socios;







/**
 * @author Gsancho
 *  <p>Implementacion de Servicios, llama a Implementacion  datos 
 *  Fecha : 11/02/2020
 *  @version 1.0.0 
 *  
 *  
 *  
 */
public class ImpServicios implements IServicios {
	
	private IDatos datos=new ImpDatos();
	
	
	@Override
    
	
	public void addPeliculas(Peliculas pelicula) throws Exception {
		// TODO Auto-generated method stub
      datos.addPeliculas(pelicula);
	}
	@Override
	public void listarPeliculas() throws Exception {
		 
		datos.listarPeliculas();
	}


	public void addSocios(Socios socio) throws Exception{
		datos.addSocio(socio);

	
	}
	 public void listadoPeliculasCategoria(int numCategoria) throws Exception {
		 datos.listadoPeliculasCategoria(numCategoria);
	 }
	@Override
	public void listadoUsuarios() throws Exception {
		datos.listadoUsuarios();
		
	}
	public void modificarUsuario() throws Exception{
		datos.modificarUsuario();
	}
    public void eliminarUsuario(int id) throws Exception{
    	datos.eliminarUsuario(id);
    }
    public void listaPeliculasMasValoradas() throws Exception{
    	datos.listaPeliculasMasValoradas();
    }
    public void listaPeliculasNoPuedeVer(int id) throws Exception{
    	datos.listaPeliculasNoPuedeVer(id);
    }
}