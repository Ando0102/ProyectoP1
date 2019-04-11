package Logical;

import java.io.Serializable;
import java.util.Calendar;

public class Consulta  implements Serializable {

	private static final long serialVersionUID = 1L;
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
