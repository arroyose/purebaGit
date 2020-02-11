package servicios;
import datos.IDatos;
import datos.ImpDatos;
import modelos.Peliculas;
import modelos.Socios;
<<<<<<< HEAD




=======
>>>>>>> 912c345d6e5d7bcb9c9bf5df5978d48edf4fc8d4
public class ImpServicios implements IServicios {
	
	private IDatos datos=new ImpDatos();
	
	
	@Override
<<<<<<< HEAD
	public void addPeliculas(Peliculas pelicula) throws Exception {
		// TODO Auto-generated method stub
      datos.addPeliculas(pelicula);
=======
	public void addPeliculas(Peliculas p) throws Exception {
		datos.addPeliculas(p);
			
>>>>>>> 912c345d6e5d7bcb9c9bf5df5978d48edf4fc8d4
	}
	@Override
	public void listarPeliculas() throws Exception {
		 
		datos.listarPeliculas();
	}
<<<<<<< HEAD

	public void addSocios(Socios socio) throws Exception{
		datos.addSocio(socio);
=======
	
	public void addSocio(Socios s) throws Exception{
		datos.addSocio(s);
>>>>>>> 912c345d6e5d7bcb9c9bf5df5978d48edf4fc8d4
	}
}
