package Logical;

import java.util.Calendar;

public class Secretaria extends User {
	private Persona miPersona;

	public Secretaria(String iD, String nombre, String apellidos, boolean sexo, String telefono, String nacionalidad,
			Calendar fecha_nacimiento, String correo_electronico, String usuario, String constrasenna, String rol
			) {
		super(iD, nombre, apellidos, sexo, telefono, nacionalidad, fecha_nacimiento, correo_electronico, usuario,
				constrasenna, rol);
		this.miPersona = miPersona;
	}
	
	//------------[get end set-----------------
	public Persona getMiPersona() {
		return miPersona;
	}

	public void setMiPersona(Persona miPersona) {
		this.miPersona = miPersona;
	}
	
	
	//-----------------------------------------

}
