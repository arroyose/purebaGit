package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
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
	 *
	 * Metodo para añadir una pelicula a nuestro base de datos.
	 *  @param pelicula es un objecto de tipo Peliculas donde viene incoporado el nombre, el año y la categoria.
	 * 
	 */
	public void addPeliculas(Peliculas pelicula) throws Exception {
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

	/**
	 *
	 * Metodo para mostrar las peliculas existentes de nuestro base de datos.
	 * 
	 */
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

	/**
	 *
	 * Metodo para mostrar las peliculas existentes por categoria de nuestro base de datos.
	 * @param numCategoria indica la categoria que quieres seleccionar y es de caracter INT
	 */
	public void listadoPeliculasCategoria(int numCategoria) {
		
		ConexionDB c = null;

		try {

			String query = "SELECT  DISTINCT*  FROM   movieflix.peliculas where categoria_pelicula =" + numCategoria;

			c = new ConexionDB();
			Statement ejecutar = c.getConnection().createStatement();
			ResultSet resultado = ejecutar.executeQuery(query);

			System.out.println("\n Peliculas de la categoria "+numCategoria+"\n");
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
	/**
	 * Metodo para mostrar las peliculas mas valoradas de la base de datos
	 * 
	 * 
	 */
	public void listaPeliculasMasValoradas() {
		ConexionDB con=null;
		
		try {
			con=new ConexionDB();
			Statement stmt=con.getConnection().createStatement();
			String query="SELECT peliculas.id_peliculas, peliculas.nombre,\r\n" + 
					"sum(visualizaciones.valoracion) as \"Puntuacion\" FROM peliculas JOIN\r\n" + 
					"visualizaciones WHERE  peliculas.id_peliculas=visualizaciones.id_pelicula\r\n" + 
					"Group by visualizaciones.id_pelicula order by puntuacion DESC limit 5;";
			ResultSet rs=stmt.executeQuery(query);
			
			System.out.println("Las cinco peliculas mas valoradas: \n");
			while(rs.next()) {
				System.out.format("%-20s", rs.getString(2));
				System.out.format("%-12s \n","  Puntuacion: "+rs.getInt(3));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
	}
	/**
	 * Metodo que muestra la lista de peliculas que no puede ver el socio
	 * @param id este parametro es el identificador del usuario y es de caracter INT
	 */
	public void listaPeliculasNoPuedeVer(int id) {
		ConexionDB con=null;
		try {
				con=new ConexionDB();
				Statement stmt=con.getConnection().createStatement();
				String query="SELECT categoria_peliculas.id_categoria FROM categoria_peliculas "
						+ "where categoria_peliculas.id_categoria <> (SELECT categoria_id "
						+ "FROM movieflix.supcripciones where movieflix.supcripciones.socio_id="+id+");";
				try{
					ResultSet rs=stmt.executeQuery(query);
					System.out.println("Las peliculas que puedes ver:\n");
					while(rs.next()) {
						listadoPeliculasCategoria(rs.getInt(1));
				}
				}catch(SQLException e) {
					System.out.println("El socio "+id +", Puedes ver todas las peliculas ");
				}		
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}	
	}
	/**
	 * Metodo para añadir un socio a nuestro base de datos.
	 * @param socio es un objecto de tipo Socios donde viene incorporado el nombre, fecha de nacimiento y ciudad.
	 *     
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
	/**
	 * Metodo para mostrar los usuarios de la base de datos. Muestra el nombre, fecha de nacimiento y ciudad.
	 * 
	 */
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
	/**
	 * 
	 * Metodo para encontrar un usuario por id
	 * 
	 * @param id, este parametro es el identificador del usuario y es de caracter INT
	 * @return Devulve un objecto de tipo socios.
	 */

	public Socios findById(int id) {
		ConexionDB con=null;
		try{
			con=new ConexionDB();
			Statement stmt=con.getConnection().createStatement();
			String query="SELECT *FROM movieflix.socio WHERE id_socio="+id;
			ResultSet rs=stmt.executeQuery(query);
			if(!rs.next()){
				return null;
			}
			return (new Socios(rs.getString("nombre"),rs.getDate("fecha_nacimiento").toLocalDate(),
					rs.getString("ciudad")));
			
		}catch(SQLException e){

			e.printStackTrace();
		}finally{
	
			con.close();
		}
		return null;
	}
	/**
	 *  Metodo de eliminar Usuario de nuestro base de datos
	 * @param id este parametro es el identificador del usuario para eliminar y es de caracter INT
	 * 
	 */
	
	public void eliminarUsuario(int id){
		ConexionDB con=null;
		Socios socio=findById(id);
		if(socio==null){
			//logger.info("Error id inexistente");
		}
		try{
			con=new ConexionDB();
			Statement stmt=con.getConnection().createStatement();
			String query="DELETE FROM movieflix.socio WHERE id_socio="+id;
			if(stmt.executeUpdate(query)!=1){
			    //logger.info("Error en la eliminacion");
			}
		}catch(SQLException e){
				
				e.printStackTrace();
		}finally{
				con.close();
		}
	}
	/**
	 *  Metodo de modificar la informacion del usuario de nuestro base de datos 
	 * 
	 */
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
