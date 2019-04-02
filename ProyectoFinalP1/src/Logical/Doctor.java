package Logical;

import java.util.ArrayList;
import java.util.Calendar;

public class Doctor extends User {
	private static final long serialVersionUID = 1L;
	private ArrayList<Paciente> misPacientes;
	private ArrayList<Cita> misCitas;//considero que no deberia estar
	private ArrayList<Consulta> misConsulta;
	public Doctor(String nombre, String apellidos, String cedula, boolean sexo, String telefono,
			String nacionalidad, Calendar fecha_nacimiento, String correo_electronico, String usuario,
			String constrasenna, String rol) {
		super(nombre, apellidos, cedula, sexo, telefono, nacionalidad, fecha_nacimiento, correo_electronico,
				usuario, constrasenna, rol);
		this.misPacientes = new ArrayList<Paciente>();
		this.misCitas     = new ArrayList<Cita>();
		this.misConsulta  = new ArrayList<Consulta>();
	}
	public ArrayList<Paciente> getMisPacientes() {
		return misPacientes;
	}
	public void setMisPacientes(ArrayList<Paciente> misPacientes) {
		this.misPacientes = misPacientes;
	}
	public ArrayList<Cita> getMisCitas() {
		return misCitas;
	}
	public void setMisCitas(ArrayList<Cita> misCitas) {
		this.misCitas = misCitas;
	}
	public ArrayList<Consulta> getMisConsulta() {
		return misConsulta;
	}
	public void setMisConsulta(ArrayList<Consulta> misConsulta) {
		this.misConsulta = misConsulta;
	}
	/////////////////////////////////////
	public void incertar_Paciente(Paciente miPaciente) {
		//Incertando Paciente 
		misPacientes.add(miPaciente);
	}
	//////////////////////////////////////
	public void incertar_Consulta(Consulta miConsulta) {
		//Incertando Consulta 
		misConsulta.add(miConsulta);
		
	}
	public void insertarCitas (Cita miCita){
		misCitas.add(miCita);
	}
	public ArrayList<Cita> citas_de_semana_actual(Calendar minimo, Calendar maximo){
		//este metodo debuel las cita de una semana
		ArrayList<Cita> miCitasSemana = new ArrayList<Cita>();
		for (Cita cita : misCitas) {
			//afeter si es despues
			if((cita.getFecha().equals(minimo)||cita.getFecha().equals(maximo))||(cita.getFecha().after(minimo)&&cita.getFecha().before(maximo))) {
				miCitasSemana.add(cita);
			}
		}
		return miCitasSemana;
	}

}
