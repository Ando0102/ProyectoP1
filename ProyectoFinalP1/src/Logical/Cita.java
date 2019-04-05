package Logical;

import java.util.Calendar;

public class Cita {

	private static final long serialVersionUID = 1L;
	private Doctor miDoctor;
	private Persona miPersona;
	private Calendar fecha;
	private int hora;
	public Cita(Doctor miDoctor, Persona miPersona, Calendar fecha, int hora) {
		super();
		this.miDoctor = miDoctor;
		this.miPersona = miPersona;
		this.fecha = fecha;
		this.hora = hora;
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
	
	
	
	

}
