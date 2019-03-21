package Logical;

import java.util.Calendar;

public class Paciente extends Persona {
	protected String tipo_sangre;
	protected String estado;
	protected String contacto_emergencia;
	protected float peso;
	
	//constructor
	public Paciente(String iD, String nombre, String apellidos, boolean sexo, String telefono, String nacionalidad,
			Calendar fecha_nacimiento, String correo_electronico, String tipo_sangre, String estado,
			String contacto_emergencia, float peso) {
		super(iD, nombre, apellidos, sexo, telefono, nacionalidad, fecha_nacimiento, correo_electronico);
		this.tipo_sangre = tipo_sangre;
		this.estado = estado;
		this.contacto_emergencia = contacto_emergencia;
		this.peso = peso;
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
}
