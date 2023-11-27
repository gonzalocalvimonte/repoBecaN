package logica;

import java.util.ArrayList;


public class Persona {
	
	private String nombre;
	private static int cantPersonas = 0; // llevamos la cuenta de todos los partidos que creamos.
	private int idPersona ; // asignamos el id al partido  a medida que creamos partidos.
	private ArrayList<Pronostico> pronosticos;
	private int PuntosXRonda = 0;
	
	public Persona(int idPersona, String nombre) {
		cantPersonas += 1; // cada vez que creamos un partido incrementamos la cantidad en 1.
    	this.idPersona = idPersona;
		this.nombre= nombre;
		this.pronosticos= new ArrayList<Pronostico>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdPersona() {
		return this.idPersona;
	}
	public int getPuntosXRonda() {
		return this.PuntosXRonda;
	}
	public void setPuntosXRonda(int puntos) {
		this.PuntosXRonda=puntos;
	}
	public ArrayList<Pronostico> getPronosticos(){
		return this.pronosticos;
	}
	public void agregaPronostico(Pronostico pronostico){
		this.pronosticos.add(pronostico);//agrego pronostico
	}
	@Override
	public String toString() {
		String cad="";
		//cad+="Nombre: "+this.nombre +" ID: "+this.idPersona+"\n";
		//cad+="Puntos: "+this.PuntosXRonda+"\n";
		cad+=this.nombre.toUpperCase()+" "+"\tPuntos: "+this.PuntosXRonda+"\n";
		return cad;
	}

	
	
}

