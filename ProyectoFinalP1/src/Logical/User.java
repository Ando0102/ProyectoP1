package Logical;

import java.util.Calendar;

public class User extends Persona {
	protected String usuario;
	protected String constrasenna;
	protected String rol;
	//--------[ agregando conctructor ]----
	
	public User(String nombre, String apellidos, String cedula, boolean sexo, String telefono,
			String nacionalidad, Calendar fecha_nacimiento, String correo_electronico, String usuario,
			String constrasenna, String rol) {
		super( nombre, apellidos, cedula, sexo, telefono, nacionalidad, fecha_nacimiento, correo_electronico);
		this.usuario = usuario;
		this.constrasenna = constrasenna;
		this.rol = rol;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getConstrasenna() {
		return constrasenna;
	}
	public void setConstrasenna(String constrasenna) {
		this.constrasenna = constrasenna;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}

	
}
