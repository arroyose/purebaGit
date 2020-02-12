package utilidades;

public class utilCadenas {
	
	
	// devuelve la ultima letra en formato String
	public static String lastCharToString(String cadena) {
		return cadena.substring(cadena.length() - 1);
	}
	//devuelve la ultima letra en formato char
	public static char lastCharToChar(String cadena) {
		return (cadena.substring(cadena.length() - 1)).charAt(0);
	}
	// devuelve true si la letra pasada como STRING es una vocal
	public static boolean isVocal(String letra) {
		return isVocal(letra.charAt(0));
	}
	//devuelve true si la letra pasada como char es una vocal
	public static boolean isVocal(char letra) {
		letra = Character.toLowerCase(letra);
		if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
			return true;
		} else {
			return false;
		}
	}
	// concatena cadenas
	public static String concatenar(String cad, String anexo) {
		return cad + anexo;
	}
	// concatena cadenas STRING + CHAR
	public static String concatenar(String cad, char anexo) {
		return cad + anexo;
	}
	//Eliminar los n ultimos carracteres de la cadena 
	public static String eliminarNLastCarracteres(String cad, int num) {
		return (cad.substring(0, cad.length() - num));
	}
	
	//Mezcla dos cadenas y devuelve una cadena nueva intercalando una letra de cada 
	//una de ellas en el caso de que las cadenas no sean de igual tamaño 
	// Se terminara la frase con la frase mas larga sin mezclar
	
	public static String mezclarCadenas(String s1, String s2) {
		String aux= "";
		String cadenaRestante="";
		
		int longitudS1=s1.length();
		int longitudS2=s2.length();
		int longitudCadenaMenor=longitudS1;
		
		if (longitudS1>longitudS2) {
			cadenaRestante= s1.substring(longitudS2);
			//System.out.println("La cadena MAYOR ES S1");
			//System.out.println("La cadena restante es: "+cadenaRestante);
			longitudCadenaMenor=longitudS2;
		}else if(longitudS1<longitudS2) {
			cadenaRestante= s2.substring(longitudS1);
			//System.out.println("La cadena MAYOR ES S2");
			//System.out.println("La cadena restante es: "+cadenaRestante);
			longitudCadenaMenor=longitudS1;
		}
		//System.out.println("La cadena S1:"+s1);
		//System.out.println("La cadena S2:"+s2);
		
		int i=0;
		do {
			aux= utilCadenas.concatenar(aux,s1.charAt(i));
			aux= utilCadenas.concatenar(aux,s2.charAt(i));
			
			i++;
		}while(i<longitudCadenaMenor-1);
			aux= utilCadenas.concatenar(aux,cadenaRestante);
			//System.out.println(aux);
		return aux;
		
	}
	
	public static int buscarCadena(String cadena, String cadenaEncontrar) {//Busca la primera aparicion de una subcadena(parametro2) en una cadena(parametro 1)
		int isInCadena = cadena.indexOf(cadenaEncontrar);
		return isInCadena;
	}
	
	public static String reemplazar(String cadena, String busqueda, String reemplazo) {
			return cadena.replaceAll(busqueda, reemplazo);
	}
	
	
	//***************************************************************************************************************
	//                                       PARA STRING BUFFER
	//***************************************************************************************************************
	
	public static int buscarSubcadena(StringBuffer cad, String sub) {
		return cad.indexOf(sub);
	}
	
	public static StringBuffer reemplazarPrimeraAparicion(StringBuffer cad, String sub, String cadenaSustituta) {
		
		StringBuffer aux = new StringBuffer(cad);
		int longitudSubCadena=sub.length();
		int posicionSubCadena=buscarSubcadena(cad, sub);
		
		if(posicionSubCadena!=-1) {
			aux= aux.replace(posicionSubCadena, longitudSubCadena+posicionSubCadena,cadenaSustituta);
		}else {
			System.out.println("No hay ocurrencias en la busqueda de la subcadena");
		}
		return aux;
	}
	
	public static StringBuffer reemplazarTodasAparicion(StringBuffer cad, String sub, String cadenaSustituta) {
		
		StringBuffer aux = new StringBuffer(cad);
		int longitudSubCadena=sub.length();
		
		while (buscarSubcadena(aux, sub)!=-1) {
			int posicionSubCadena=buscarSubcadena(aux, sub);
			aux= aux.replace(posicionSubCadena, longitudSubCadena+posicionSubCadena,cadenaSustituta);
		}
		return aux;
	}
	
}
