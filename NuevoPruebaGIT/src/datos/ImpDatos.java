package datos;

import java.sql.SQLException;
import java.sql.Statement;

import modelos.Peliculas;
import modelos.Socios;
import utilidades.ConexionDB;

public class ImpDatos implements IDatos{
	/**
	 * @author Fernando Garcia
	 * @param El Objeto socio nos proporcionara el nombre , fecha y ciudad para insertarlo en la base de datos
	 */
	public  void addSocio(Socios socio) {
		ConexionDB conexion = new ConexionDB();
		String consulta = String.format("INSERT INTO socio (nombre,fecha_nacimiento,ciudad )\r\n" + 
				"VALUES ('%s', '%s', '%s')",socio.getNombre(),socio.getFecha().toString(),socio.getCiudad());
		try {
			Statement statement = conexion.getConnection().createStatement();
			statement.executeUpdate(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conexion.close();
		}
		
		
	}

	@Override
	public void addPeliculas(Peliculas p) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarPeliculas() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
