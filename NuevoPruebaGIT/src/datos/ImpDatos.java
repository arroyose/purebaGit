package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelos.Peliculas;
import modelos.Socios;
import utilidades.ConexionDB;
import utilidades.LecturaDeDatos;

/**
 * @author admin
 *
 */
public class ImpDatos implements IDatos {
	/**
	 * @author Fernando Garcia
	 * @param El Objeto socio nos proporcionara el nombre , fecha y ciudad para
	 *           insertarlo en la base de datos
	 */

	public void addSocio(Socios socio) {

		ConexionDB conexion = new ConexionDB();
		String consulta = String.format(
				"INSERT INTO socio (nombre,fecha_nacimiento,ciudad )\r\n" + "VALUES ('%s', '%s', '%s')",
				socio.getNombre(), socio.getFecha().toString(), socio.getCiudad());
		try {
			Statement statement = conexion.getConnection().createStatement();
			statement.executeUpdate(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}

	}

	@Override
	public void addPeliculas(Peliculas pelicula) throws Exception {
		/**
		 *
		 * @author Gsancho
		 * 
		 *         <p>
		 *         Recibe un objeto de tipo Peliculas y lo introduce en la base de
		 *         datos. Fecha 11/02/2020
		 *         </p>
		 * 
		 * 
		 */

		String nombre = pelicula.getNombre();
		int anio = pelicula.getYear();
		String sinopsis = pelicula.getSinopsis();
		int categoria = pelicula.getCategoria().getCod();

		ConexionDB c = null;

		try {
			c = new ConexionDB();

			Statement ejecutar = c.getConnection().createStatement();
			int resultado = ejecutar.executeUpdate(
					"INSERT INTO movieflix.peliculas (nombre, year, sinopsis, categoria_pelicula) VALUES (" + "'"
							+ nombre + "'" + "," + "'" + anio + "'" + "," + "'" + sinopsis + "'" + "," + "'" + categoria
							+ "'" + ")");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			c.close();
		}
	}

	@Override
	public void listarPeliculas() throws Exception {

		ConexionDB c = null;

		try {

			c = new ConexionDB();
			Statement ejecutar = c.getConnection().createStatement();
			ResultSet resultado = ejecutar.executeQuery(
					"SELECT  DISTINCT*  FROM   movieflix.peliculas ,movieflix.categoria_peliculas where id_categoria = categoria_pelicula order by id_peliculas;");

			System.out.println("Peliculas: ");
			while (resultado.next()) {
				System.out.print("Id: " + resultado.getInt(1));
				System.out.print(" : " + resultado.getString(2));
				System.out.print(" Año: " + resultado.getString(3));
				System.out.print(" Sinopsis: " + resultado.getString(4));
				System.out.println(" Categoria: " + resultado.getString(7));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			c.close();
		}
	}

	
	
	
	public void listadoPeliculasCategoria(int numCategoria) {
		/**
		 *
		 * @author Gsancho
		 * 
		 *         <p>
		 *         Recibe una categoria como int y muestra todas las peliculas
		 *         mediante una consulta
		 *          Fecha 11/02/2020
		 *         </p>
		 * 
		 */
		
		ConexionDB c = null;

		try {

			String query = "SELECT  DISTINCT*  FROM   movieflix.peliculas where categoria_pelicula =" + numCategoria;

			c = new ConexionDB();
			Statement ejecutar = c.getConnection().createStatement();
			ResultSet resultado = ejecutar.executeQuery(query);

			System.out.println("Peliculas: ");
			while (resultado.next()) {
				System.out.print("Id: " + resultado.getInt(1));
				System.out.print(" : " + resultado.getString(2));
				System.out.print(" Año: " + resultado.getString(3));
				System.out.println(" Sinopsis: " + resultado.getString(4));
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			c.close();
		}
	}
	

	public void listadoUsuarios() {
		ConexionDB conexion = new ConexionDB();
		String consulta = "select * from Socio";
		String [] camposUsuarios = new String[4];
		try {
			Statement statement = conexion.getConnection().createStatement();
			ResultSet rs = statement.executeQuery(consulta);
			
			while (rs.next()) {
					camposUsuarios[0]= Integer.toString(rs.getInt("id_socio")); 
					camposUsuarios[1]= rs.getString("nombre");
					camposUsuarios[2]= rs.getString("fecha_nacimiento");
					camposUsuarios[3]= rs.getString("ciudad");
				  System.out.println("id: "+camposUsuarios[0]+"  nombre: "+camposUsuarios[1] + " Fecha de nacimiento: "+camposUsuarios[2]+" ciudad: "+camposUsuarios[3]+"\n");
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conexion.close();
		}
		
	}
	
	public void modificarUsuario() {
		Statement statement = null;
		ResultSet rs = null;
		ConexionDB conexion = new ConexionDB();
		int id = LecturaDeDatos.leerInteger("Introduce el id del socio");
		String nombre = LecturaDeDatos.leerString("Introduce el nombre");
		String fechaNacimiento = LecturaDeDatos.leerString("Introduce la fecha de nacimiento");
		String ciudad = LecturaDeDatos.leerString("Introduce la ciudad");
		
		String consulta = "UPDATE socio\r\n" + 
				"SET nombre = '"+nombre+"',fecha_nacimiento = "+"'"+fechaNacimiento+"'"+",ciudad = '"+ciudad+"'\r\n" + 
				"WHERE id_socio = "+id+"";
		
		try {
			statement = conexion.getConnection().createStatement();
			
			if(statement.executeUpdate(consulta)==0) {
				System.out.println("No se ha encontrado el socio");
			}else {
				System.out.println("Socio modificado con datos: ");
				System.out.println("Nombre: "+nombre);
				System.out.println("fecha de nacimientos: "+fechaNacimiento);
				System.out.println("Ciudad: "+ciudad);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
	}
		
}


