package utilidades;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {
	
    private static Connection connection = null;
    private static String BD = "movieflix";
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";
    private static String driverUrl = "jdbc:mysql://10.90.36.101:3306/" + BD+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "remoto";
    private static String password = "root";
    
    public ConexionDB() {
        try {         
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(driverUrl, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("No se encuentra el driver");
        } catch (SQLException e) {
            System.out.println("Excepcion SQL: " + e.getMessage());
            System.out.println("Estado SQL: " + e.getSQLState());
            System.out.println("Codigo del Error: " + e.getErrorCode());
            System.out.println("ERROR. No se puede conectar con la Bases de Datos: " + e);
            System.exit(-1);
        }
    }
	
	
	public void cargarFicheroDB() throws FileNotFoundException {
		ConexionDB c = new ConexionDB();
		CargarFichero fichero = new CargarFichero(new FileReader(new File("peliculas_numCat.txt")));
		try {
			fichero.cagarPeliculas(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException se) {
            System.out.println("Exception closing Connection: " + se);
        }
    }

}
