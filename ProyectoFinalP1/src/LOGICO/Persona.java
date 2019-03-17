package LOGICO;

import java.util.Calendar;

public class Persona {
	protected String nombre;
	protected String apellidos;
	protected String cedula;
	protected String correo_electronico;
	protected Calendar Fecha_nacimiento;
	
	
	public Persona(String nombre, String apellidos, String cedula, String correo_electronico,
			Calendar fecha_nacimiento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cedula = cedula;
		this.correo_electronico = correo_electronico;
		Fecha_nacimiento = fecha_nacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	public Calendar getFecha_nacimiento() {
		return Fecha_nacimiento;
	}
	public void setFecha_nacimiento(Calendar fecha_nacimiento) {
		Fecha_nacimiento = fecha_nacimiento;
	}
	

}
