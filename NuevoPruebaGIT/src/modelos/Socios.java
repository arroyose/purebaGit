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
	
	
	public Socios() {
		
		
	}
	
	public Socios(String nombre, LocalDate fecha, String ciudad) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.ciudad = ciudad;
	}




	public Socios(String nombre, String ciudad) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
	}


	public Socios(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Socios [nombre=" + nombre + ", fecha=" + fecha + ", ciudad=" + ciudad + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

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
