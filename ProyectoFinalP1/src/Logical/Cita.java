package Logical;

import java.util.Calendar;

public class Cita {

	private static final long serialVersionUID = 1L;
	private Doctor miDoctor;
	private Persona miPersona;
	private Calendar fecha;
	private int hora;
	private String estado;
	private Secretaria secretaria;
	public Cita(Doctor miDoctor, Persona miPersona, Calendar fecha, int hora,String estado, Secretaria secretaria) {
		super();
		this.miDoctor = miDoctor;
		this.miPersona = miPersona;
		this.fecha = fecha;
		this.hora = hora;
		this.setEstado(estado);
		this.secretaria= secretaria;
	}

	public Doctor getMiDoctor() {
		return miDoctor;
	}

	public void setMiDoctor(Doctor miDoctor) {
		this.miDoctor = miDoctor;
	}

	public Persona getMiPersona() {
		return miPersona;
	}

	public void setMiPersona(Persona miPersona) {
		this.miPersona = miPersona;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}
	
	
	
	

}
