package Logical;

import java.util.Calendar;

public class Vacuna {
 
 private Calendar fecha_vencimiento;
 private Calendar fecha_puesta;
 private String nombre_vacuna;
 //Constructor
 public Vacuna(Calendar fecha_vencimiento, Calendar fecha_puesta, String nombre_vacuna) {
		super();
		this.fecha_vencimiento = fecha_vencimiento;
		this.fecha_puesta = fecha_puesta;
		this.nombre_vacuna = nombre_vacuna;
	}
 //Sets y gets
public Calendar getFecha_vencimiento() {
	return fecha_vencimiento;
}
public void setFecha_vencimiento(Calendar fecha_vencimiento) {
	this.fecha_vencimiento = fecha_vencimiento;
}
public Calendar getFecha_puesta() {
	return fecha_puesta;
}
public void setFecha_puesta(Calendar fecha_puesta) {
	this.fecha_puesta = fecha_puesta;
}
public String getNombre_vacuna() {
	return nombre_vacuna;
}
public void setNombre_vacuna(String nombre_vacuna) {
	this.nombre_vacuna = nombre_vacuna;
}
}
