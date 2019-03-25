package Logical;

import java.util.Calendar;

public class Secretaria extends User {
	private static final long serialVersionUID = 1L;
	private Persona miPersona;


	
	public Secretaria(String iD, String nombre, String apellidos, String cedula, boolean sexo, String telefono,
			String nacionalidad, Calendar fecha_nacimiento, String correo_electronico, String usuario,
			String constrasenna, String rol, Persona miPersona) {
		super(iD, nombre, apellidos, cedula, sexo, telefono, nacionalidad, fecha_nacimiento, correo_electronico,
				usuario, constrasenna, rol);
		this.miPersona = miPersona;
	}

	//------------[ get end set ]-----------------
	public Persona getMiPersona() {
		return miPersona;
	}

	public void setMiPersona(Persona miPersona) {
		this.miPersona = miPersona;
	}
	
	
	//-----------------------------------------
}
