package Logical;

public class Enfermedad {
	private String nombre_enfermedad;
	private String sintomas;
	private String tratamiento;
	private boolean tipo_enfermedad;
	//Constructor
	public Enfermedad(String nombre_enfermedad, String sintomas, String tratamiento, boolean tipo_enfermedad) {
		super();
		this.nombre_enfermedad = nombre_enfermedad;
		this.sintomas = sintomas;
		this.tratamiento = tratamiento;
		this.tipo_enfermedad = tipo_enfermedad;
	}
	//Sets y gets
	public String getNombre_enfermedad() {
		return nombre_enfermedad;
	}
	public void setNombre_enfermedad(String nombre_enfermedad) {
		this.nombre_enfermedad = nombre_enfermedad;
	}
	public String getSintomas() {
		return sintomas;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public boolean isTipo_enfermedad() {
		return tipo_enfermedad;
	}
	public void setTipo_enfermedad(boolean tipo_enfermedad) {
		this.tipo_enfermedad = tipo_enfermedad;
	}

}
