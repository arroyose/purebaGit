package modelos;

import java.time.LocalDate;
/**
 * @author Gsancho
 * <p>Descripcion: La clase "Socio" como modelo 
 * Fecha: 11/02/2020</p>
 * @params La fecha es un LocalDate, se debe importar java.time.LocalDate. Se pasa por defecto una fecha estandar por si el usuario no la proporciona.
 * 
 * @version 1.0.0
 * 
 * 
 */
public class Socios {

	
	private String nombre;
	private LocalDate fecha=LocalDate.of(1900, 01, 01);
	private String ciudad;
	
	/**
	 * Constructor sin parametros para la calse socios
	 * 
	 * */
	public Socios() {
		
		
	}
	/**
	 * Constructor con todos los parametros para la calse Socios
	 * @param nombre  El parametro nombre, define el nombre de un Socio y sera de tipo String
	 * @param fecha  El parametro fecha, define la fecha de nacimiento de un usuario y sera de tipo LocalDate
	 * @param ciudad El parametro  ciudad, define el nombre de ciudad en la que reside un socio y sera de tipo String
	 * */
	public Socios(String nombre, LocalDate fecha, String ciudad) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.ciudad = ciudad;
	}
	
	/**
	 * Constructor con parametros para la calse Socios
	 * @param nombre  El parametro nombre, define el nombre de un Socio y sera de tipo String
	 * @param ciudad El parametro  ciudad, define el nombre de ciudad en la que reside un socio y sera de tipo String
	 * */
	public Socios(String nombre, String ciudad) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
	}
	/**
	 * Constructor con parametros para la calse Socios
	 * @param nombre  El parametro nombre, define el nombre de un Socio y sera de tipo String
	 * */
	public Socios(String nombre) {
		super();
		this.nombre = nombre;
	}
	/**
	 * getNombre Metodo que nos dara el nombre de un socio
	 * @return Nombre de un socio 
	 * */
	public String getNombre() {
		return nombre;
	}
	/**
	 * setNombre modifica el nombbre de un socio
	 * @param nombre Nombre del socio tipo String
	 * */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * getFecha obtiene la fecha de nacimiento de un socio
	 * @retur fecha Fecha de nacimiento en formato LocalDate  del socio
	 * */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * setNombre modifica la fecha de nacimiento de un socio
	 * @param fecha Fecha de nacimeinto del socio tipo LocalDate
	 * */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	/**
	 * getCiudad obtiene la ciudad en la que reside un usuario
	 * @return ciudad Nos dara la ciudad en la que reside un usuario tipo String
	 * */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * setCiudad modifica la ciudad en la que reside un usuario
	 * @param ciudad  Ciudad en la que reside un usuario tipo String
	 * */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	/**
	 * toString Metodo sobre esrito para la impresion de un Socio 
	 *  
	 * */
	@Override
	public String toString() {
		return "Socios [nombre=" + nombre + ", fecha=" + fecha + ", ciudad=" + ciudad + "]";
	}
	/**
	 * hasCode Metodo sobre esrito hasCode 
	 *  
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	/**
	 * equals Metodo sobreesrito para comparacion de objetos de la clase peliculas
	 *  
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Socios other = (Socios) obj;
		if (ciudad == null) {
			if (other.ciudad != null)
				return false;
		} else if (!ciudad.equals(other.ciudad))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
	
	
}
