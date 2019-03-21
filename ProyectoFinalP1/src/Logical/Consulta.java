package Logical;

import java.util.Calendar;

public class Consulta {

	private String diagnostico;
	private Calendar fecha;
	
	
	public Consulta(String diagnostico, Calendar fecha) {
		super();
		this.diagnostico = diagnostico;
		this.fecha = fecha;
	}


	public String getDiagnostico() {
		return diagnostico;
	}


	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}


	public Calendar getFecha() {
		return fecha;
	}


	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	
	

}
