package Logical;

import java.io.Serializable;
import java.util.ArrayList;

public class Clinica  implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList <Persona> misPersonas;
	private ArrayList <Cita> misCitas;
	private ArrayList <HistorialMedico> misHistorias;
	private ArrayList <Vacuna> misVacunas;
	private ArrayList <Enfermedad> enfermedades;
	private static Clinica miClinica = null;
	//Constructor vacio de controladora
	
	private Clinica() {
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
	
	public static Clinica getMiClinica() {
		return miClinica;
	}
	public static void setMiClinica(Clinica miClinica) {
		Clinica.miClinica = miClinica;
	}
//////////////////////////////////////////////////
//////////////////////METODOS/////////////////////
//////////////////////////////////////////////////


	////////////////////////////////////////////////////
	public void insertarPersona (Persona personaAux) {
		//Insertar Persona
		misPersonas.add(personaAux);
	}	
///////////////////////////////////////////////////
	public void insertarEnfermedad (Enfermedad enfermedadAux){
		//Insertar Enfermedad
		enfermedades.add(enfermedadAux);
	} 
//////////////////////////////////////////////////
	public void insertarVacuna (Vacuna vacunaAux){
		//Insertar Vacuna
		misVacunas.add(vacunaAux);
	}
/////////////////////////////////////////////////
	public void insertarCitas (Cita citaAux){
		//Insertar Citas
		misCitas.add(citaAux);
	}
////////////////////////////////////////////////
	public void insertarHistorial (HistorialMedico misHistoriasAux){
		//Insertar Historial
		misHistorias.add(misHistoriasAux);
	}
////////////////////////////////////////////////
	public User buscarUsuario(String usuario, String constrasenna) {
		//buscar al usuario
		User userAux = null;
		for (Persona miPS : misPersonas) {
			if(miPS instanceof User) {
				//verificando usuario y contraseņa
				if(((User) miPS).getUsuario().equalsIgnoreCase(usuario)&&(((User) miPS).getConstrasenna().equalsIgnoreCase(constrasenna))) {
					userAux = ((User)miPS);
					System.out.println("Usuario encontrado");
				}
			}
		}
		return userAux;
	}
/////////////////////////////////////////////////
	public void insertarDoctor (Doctor miDoctor){
		//Insertar Doctor
		//Doctor miDoctor = new Doctor ("1", "Bibi", "Romano", "0804", false, "8095679302","Dominicano", null, "bibi0804@", "doctor", "123", "Doctor");
		misPersonas.add(miDoctor);
	}
////////////////////////////////////////////////
	public ArrayList<Doctor> doctores (){
		//Arreglo de doctores
		int i = 0;
		ArrayList <Doctor> doctores = new ArrayList<>();
		while(i<getMisPersonas().size()){	
		if (getMisPersonas().get(i) instanceof Doctor && getMisPersonas() != null){
			doctores.add((Doctor) getMisPersonas().get(i));
		}
			i++;
		} return doctores;
	}
////////////////////////////////////////////////
	public Persona miPersona (String cedula){
		boolean find = false;
		int i = 0;
		Persona miPersona = null;
		while(find!=true && i<misPersonas.size()){
			for(Persona aux : misPersonas){
				if(aux.getID().equalsIgnoreCase(cedula)){
					find = true;
					miPersona = aux;
				}
			}
		}
		return miPersona;
	}
	
}
