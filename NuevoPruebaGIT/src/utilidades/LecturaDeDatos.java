package utilidades;
import java.util.Scanner;

public class LecturaDeDatos {

    //metodo estatico
	
    public static String leerString() {
        return new Scanner(System.in).nextLine();
    }
    
    public static int leerInteger() {
        return new Scanner(System.in).nextInt();
    }
    public static float leerFloat() {
        return (float)new Scanner(System.in).nextFloat();
    }
    public static short leerShort() {
    	return (short)new Scanner(System.in).nextShort();
    }
    public static String leerString(String msg) {
        System.out.println(msg);
        return leerString();
    }
    
    public static int leerInteger(String msg) {
    	System.out.print(msg);
        return leerInteger();
    }
    public static float leerFloat(String msg) {
    	System.out.print(msg);
        return (float)leerFloat();
    }
    
    public static short leerShort(String msg) {
    	System.out.print(msg);
        return (short)leerShort();
    	
    }
	
}
