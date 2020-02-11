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

/**
 * @author Gsancho
 * <p>Descripcion: La clase "Socio" como modelo 
 * Fecha: 11/02/2020</p>
 * @params La fecha es un LocalDate, se debe importar java.time.LocalDate. Se pasa por defecto una fecha estandar por si el usuario no la proporciona.
 * 
 * @version 1.0.0
 * 
 */

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
