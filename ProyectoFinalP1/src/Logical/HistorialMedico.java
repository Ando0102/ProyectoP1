package Logical;

import java.io.Serializable;
import java.util.Calendar;

public class HistorialMedico  implements Serializable {

	private static final long serialVersionUID = 1L;
	private Doctor miDoctor;
	private Calendar fecha;
	private String Suceso;
	
	public HistorialMedico(Doctor miDoctor, Calendar fecha, String suceso) {
		super();
		this.miDoctor = miDoctor;
		this.fecha = fecha;
		Suceso = suceso;
	}

	public Doctor getMiDoctor() {
		return miDoctor;
	}

	public void setMiDoctor(Doctor miDoctor) {
		this.miDoctor = miDoctor;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getSuceso() {
		return Suceso;
	}

	public void setSuceso(String suceso) {
		Suceso = suceso;
	}
	
	
	

}
