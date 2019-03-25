package Logical;

import java.util.ArrayList;
import java.util.Calendar;

public class Paciente extends Persona {
	private static final long serialVersionUID = 1L;
	private String tipo_sangre;
	private String estado;
	private String contacto_emergencia;
	private float peso;
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<Enfermedad> misEnfermedas;
	private ArrayList<Consulta> misConsultas;
	private ArrayList<HistorialMedico> misHistorialMedico;
	//constructor

	
	public Paciente(String iD, String nombre, String apellidos, String cedula, boolean sexo, String telefono,
			String nacionalidad, Calendar fecha_nacimiento, String correo_electronico, String tipo_sangre,
			String estado, String contacto_emergencia, float peso) {
		super(iD, nombre, apellidos, cedula, sexo, telefono, nacionalidad, fecha_nacimiento, correo_electronico);
		this.tipo_sangre = tipo_sangre;
		this.estado = estado;
		this.contacto_emergencia = contacto_emergencia;
		this.peso = peso;
		this.misVacunas        = new ArrayList<>();
		this.misEnfermedas      = new ArrayList<>();
		this.misConsultas       =  new ArrayList<>();
		this.misHistorialMedico =  new ArrayList<>();
	}

	//------------[get end set-----------------
	public String getTipo_sangre() {
		return tipo_sangre;
	}

	public void setTipo_sangre(String tipo_sangre) {
		this.tipo_sangre = tipo_sangre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getContacto_emergencia() {
		return contacto_emergencia;
	}
	public void setContacto_emergencia(String contacto_emergencia) {
		this.contacto_emergencia = contacto_emergencia;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	//--------------------------------------------

	@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
