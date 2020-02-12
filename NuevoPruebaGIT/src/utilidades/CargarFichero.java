package utilidades;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelos.Peliculas;

public class CargarFichero {
	
	private static final Logger logger = LogManager.getLogger("CargarFichero");
	
	private BufferedReader bf;
	private ConexionDB conexion;

	public CargarFichero(FileReader archivo) {
		this.bf = new BufferedReader(archivo);
		this.conexion = new ConexionDB();
	}
	
	private void cagarPeliculasDB() throws IOException{
		String linea = "";
		int cont = 0;
		String [] arrayString = new String[2];
		
		System.out.println("-------------DATOS INSERTADOS------------");
		
		while((linea=bf.readLine())!=null) {
			arrayString = linea.split(",");
			System.out.println("Nombre: "+arrayString[0]+" Anho: "+arrayString[1]+" Categoria id: "+arrayString[2]);
			insertarDB(arrayString);
		}
		
		conexion.close();
		
	}
	
	private void insertarDB(String [] param) {
		Statement ejecutar = null;
		try {
			ejecutar = conexion.getConnection().createStatement();
			ejecutar.executeUpdate("INSERT INTO movieflix.peliculas (nombre, year, sinopsis, categoria_pelicula) VALUES ("+"'"+param[0]+"'"+","+"'" +param[1]+"'"+","+"'"+ " "+"'"+"," + "'"+param[2]+"'"+")");
		} catch (SQLException e) {
			logger.info("error al insertar peliculas en la BBDD",e);
		}
				
	}
	
	public void cargarFichero() throws FileNotFoundException {
		try {
			cagarPeliculasDB();
		} catch (IOException e) {
			logger.info("error al cargar el fichero",e);
		}
	}

	

}
