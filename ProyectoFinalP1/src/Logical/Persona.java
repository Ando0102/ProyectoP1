package Logical;

import java.util.Calendar;

public class Persona {
	protected String ID;
	protected String nombre;
	protected String apellidos;
	protected boolean sexo;
	//true masculino
	//false femenino
	protected String telefono;
	protected String nacionalidad;
	protected Calendar fecha_nacimiento;
	protected String correo_electronico;
	
	public Persona(String iD, String nombre, String apellidos, boolean sexo, String telefono, String nacionalidad,
			Calendar fecha_nacimiento, String correo_electronico) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.telefono = telefono;
		this.nacionalidad = nacionalidad;
		this.fecha_nacimiento = fecha_nacimiento;
		this.correo_electronico = correo_electronico;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
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
	public boolean isSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public Calendar getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Calendar fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	
	
	
	
}
