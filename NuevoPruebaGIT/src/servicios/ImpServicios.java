package servicios;
import datos.IDatos;
import datos.ImpDatos;
import modelos.Peliculas;
import modelos.Socios;
public class ImpServicios implements IServicios {
	
	private IDatos datos=new ImpDatos();
	@Override
	public void addPeliculas(Peliculas p) throws Exception {
		datos.addPeliculas(p);
			
	}
	@Override
	public void listarPeliculas() throws Exception {
		 
		datos.listarPeliculas();
	}
	
	public void addSocio(Socios s) throws Exception{
		datos.addSocio(s);
	}
}
