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

	
	public Paciente(String nombre, String apellidos, String cedula, boolean sexo, String telefono,
			String nacionalidad, Calendar fecha_nacimiento, String correo_electronico, String tipo_sangre,
			String estado, String contacto_emergencia, float peso) {
		super( nombre, apellidos, cedula, sexo, telefono, nacionalidad, fecha_nacimiento, correo_electronico);
		this.tipo_sangre = tipo_sangre;
		this.estado = estado;
		this.contacto_emergencia = contacto_emergencia;
		this.peso = peso;
		this.misVacunas = new ArrayList<Vacuna>();
		this.misEnfermedas = new ArrayList<>();
		this.misConsultas = new ArrayList<>();
		this.misHistorialMedico = new ArrayList<>();
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

	public ArrayList<Vacuna> getMisVacunas() {
		return misVacunas;
	}

	public void setMisVacunas(ArrayList<Vacuna> misVacunas) {
		this.misVacunas = misVacunas;
	}

	public ArrayList<Enfermedad> getMisEnfermedas() {
		return misEnfermedas;
	}

	public void setMisEnfermedas(ArrayList<Enfermedad> misEnfermedas) {
		this.misEnfermedas = misEnfermedas;
	}

	public ArrayList<Consulta> getMisConsultas() {
		return misConsultas;
	}

	public void setMisConsultas(ArrayList<Consulta> misConsultas) {
		this.misConsultas = misConsultas;
	}

	public ArrayList<HistorialMedico> getMisHistorialMedico() {
		return misHistorialMedico;
	}

	public void setMisHistorialMedico(ArrayList<HistorialMedico> misHistorialMedico) {
		this.misHistorialMedico = misHistorialMedico;
	}
//---------------------------------------------------------------------------
	public boolean buscar_vacuna(String nombre) {
		//Busca una si el pasiente tiene la vacuna dada por el nombre
		Boolean aux = false;
		for (Vacuna consulta : misVacunas) {
			if(consulta.getNombre_vacuna().equalsIgnoreCase(nombre)) {
				aux = true;
				break;
			}
		}
		
		
		return aux;
	}


}
