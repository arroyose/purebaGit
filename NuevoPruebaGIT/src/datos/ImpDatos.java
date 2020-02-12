package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.ParseInfo;

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
	public void addPeliculas(Peliculas pelicula) throws Exception {
		/**
		 *
		 * @author Gsancho
		 * 
		 * <p> Recibe un objeto de tipo Peliculas y lo introduce en la base de datos. 
		 * Fecha 11/02/2020</p>
		 * 
		 * 
		 */
		
			String nombre = pelicula.getNombre();
			int anio = pelicula.getYear();
			String sinopsis =pelicula.getSinopsis();
			int categoria = pelicula.getCategoria().getCod();
			
			ConexionDB c = null;
			
	try {
		c = new ConexionDB();
				
				Statement ejecutar = c.getConnection().createStatement();
				 int resultado = ejecutar.executeUpdate("INSERT INTO movieflix.peliculas (nombre, year, sinopsis, categoria_pelicula) VALUES ("+"'"+nombre+"'"+","+"'" +anio+"'"+","+"'"+ sinopsis+"'"+"," + "'"+categoria+"'"+")");
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
			
			
			c.close();
		}}
		
	

	@Override
	public void listarPeliculas() throws Exception {
		
		ConexionDB c = null;
		
		try {
			
			 c = new ConexionDB();
					Statement ejecutar = c.getConnection().createStatement();
					ResultSet resultado = ejecutar.executeQuery("SELECT  DISTINCT*  FROM   movieflix.peliculas ,movieflix.categoria_peliculas where id_categoria = categoria_pelicula order by id_peliculas;");
					
					 System.out.println("Peliculas: ");
				        while (resultado.next()) {
				            System.out.print("Id: " + resultado.getInt(1));
				            System.out.print(" : " + resultado.getString(2));
				            System.out.print(" Año: " + resultado.getString(3));
				            System.out.print(" Sinopsis: " + resultado.getString(4));
				            System.out.println(" Categoria: " + resultado.getString(7));
				           
				        }
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
				
				
				c.close();
				}
	}

	@Override
	public void listadoUsuarios() throws Exception {
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
	
	

	
	}


