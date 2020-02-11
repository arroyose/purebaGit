package servicios;
import datos.IDatos;
import datos.ImpDatos;
import modelos.Peliculas;
import modelos.Socios;







public class ImpServicios implements otronombre {
	
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
}