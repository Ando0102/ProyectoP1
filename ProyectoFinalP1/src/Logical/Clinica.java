package Logical;

import java.util.ArrayList;

public class Clinica {

	
	private ArrayList <Persona> misPersonas;
	private ArrayList <Cita> misCitas;
	private ArrayList <HistorialMedico> misHistorias;
	private ArrayList <Vacuna> misVacunas;
	private ArrayList <Enfermedad> enfermedades;
	private static Clinica miClinica = null;
	//Constructor vacio de controladora
	
	public Clinica() {
		super();
		this.misPersonas = new ArrayList<Persona>();
		this.misCitas = new ArrayList<Cita>();
		this.misHistorias = new ArrayList<HistorialMedico>();
		this.misVacunas = new ArrayList<Vacuna>();
		this.enfermedades = new ArrayList<Enfermedad>();
	}
	//Instancia de controladora
	public static Clinica getInstance(){ 
		 if(miClinica == null){
			 miClinica = new Clinica();
		 }
		 return miClinica;
	 } 
	//Sets y gets
	public ArrayList <Persona> getMisPersonas() {
		return misPersonas;
	}
	public void setMisPersonas(ArrayList <Persona> misPersonas) {
		this.misPersonas = misPersonas;
	}
	public ArrayList <Cita> getMisCitas() {
		return misCitas;
	}
	public void setMisCitas(ArrayList <Cita> misCitas) {
		this.misCitas = misCitas;
	}
	public ArrayList <HistorialMedico> getMisHistorias() {
		return misHistorias;
	}
	public void setMisHistorias(ArrayList <HistorialMedico> misHistorias) {
		this.misHistorias = misHistorias;
	}
	public ArrayList <Vacuna> getMisVacunas() {
		return misVacunas;
	}
	public void setMisVacunas(ArrayList <Vacuna> misVacunas) {
		this.misVacunas = misVacunas;
	}
	public ArrayList <Enfermedad> getEnfermedades() {
		return enfermedades;
	}
	public void setEnfermedades(ArrayList <Enfermedad> enfermedades) {
		this.enfermedades = enfermedades;
	}
//////////////////////////////////////////////////
//////////////////////METODOS/////////////////////
//////////////////////////////////////////////////

//Insertar Persona
public void insertarPersona (Persona personaAux) {
misPersonas.add(personaAux);

}	
//Insertar Enfermedad
public void insertarEnfermedad (Enfermedad enfermedadAux){
enfermedades.add(enfermedadAux);
} 

//Insertar Vacuna
public void insertarVacuna (Vacuna vacunaAux){
misVacunas.add(vacunaAux);
}

//Insertar Citas
public void insertarCitas (Cita citaAux){
misCitas.add(citaAux);
}
//Insertar Historial
public void insertarHistorial (HistorialMedico misHistoriasAux){
misHistorias.add(misHistoriasAux);
}
}
