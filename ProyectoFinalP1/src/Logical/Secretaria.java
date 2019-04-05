package Logical;

import java.util.Calendar;

public class Secretaria extends User {
	private static final long serialVersionUID = 1L;
	private Cita misCitas;
	


	
	public Secretaria(String nombre, String apellidos, String cedula, boolean sexo, String telefono,
			String nacionalidad, Calendar fecha_nacimiento, String correo_electronico, String usuario,
			String constrasenna, String rol) {
		super(nombre, apellidos, cedula, sexo, telefono, nacionalidad, fecha_nacimiento, correo_electronico,
				usuario, constrasenna, rol);
		
	}




	public Cita getMisCitas() {
		return misCitas;
	}




	public void setMisCitas(Cita misCitas) {
		this.misCitas = misCitas;
	}

	
	
	
	
}
