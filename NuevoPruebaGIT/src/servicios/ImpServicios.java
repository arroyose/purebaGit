package servicios;
import datos.IDatos;
import datos.ImpDatos;
public class ImpServicios implements nuevonombre {
	
	private IDatos datos=new ImpDatos();
	@Override
	public void addPeliculas() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void listarPeliculas() throws Exception {
		 
		datos.listarPeliculas();
	}

}
