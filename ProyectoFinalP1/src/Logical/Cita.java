package Logical;

import java.util.Calendar;

public class Cita {

	private Doctor miDoctor;
	private Persona miPersona;
	private Calendar fecha;
	
	public Cita(Doctor miDoctor, Persona miPersona, Calendar fecha) {
		super();
		this.miDoctor = miDoctor;
		this.miPersona = miPersona;
		this.fecha = fecha;
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
	
	
	
	

}
