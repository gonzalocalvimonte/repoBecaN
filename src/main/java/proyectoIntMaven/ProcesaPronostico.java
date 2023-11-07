package proyectoIntMaven;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProcesaPronostico {
	private LectorDeArchivo archivoPartidos;
	ArrayList<Pronostico> listaPronosticos;
	
	public ProcesaPronostico(String rutaOrigen) {
		this.archivoPartidos = new LectorDeArchivo(rutaOrigen);
		listaPronosticos= new ArrayList<>();
	}
	public ArrayList<Pronostico> procesaDatos(){
		//Este metodo nos devuelve el array de pronosticos para pasarlo a la ronda
		List<String> datosPronostico = this.archivoPartidos.parsearArchivo();
		String[] linea;
		//Recorremos la lista con los datos de los partidos
		//Si el archivo tiene encabezado comenzamos desde i=1;
		for(int i=1;i<datosPronostico.size();i++) {
			linea = datosPronostico.get(i).split(",");
			
			//Cada linea tiene la siguiente informacion: partidoID,equipo,resultado(prediccion)
			//Creamos el Partido y lo agregamos al ArrayList}
			listaPronosticos.add(creaPronostico(Integer.parseInt(linea[0]),linea[3],ResultadoEnum.valueOf(linea[4])));
		}
		return this.listaPronosticos;
	}
	private Pronostico creaPronostico(int pID, String equipo, ResultadoEnum resultado ) {
		return new Pronostico(pID,new Equipo(equipo), resultado);
	}
	
	public ArrayList<Persona> listaPersonas(){
		List<String> datosPronostico = this.archivoPartidos.parsearArchivo();
		String[] linea;
		ArrayList<Persona> personas = new ArrayList<Persona>();
		int cantidadDePersonas = this.listaPronosticos.size() / Partido.getCantPartidos();
 		
		for (int i= 1; i < datosPronostico.size() ; i += Partido.getCantPartidos()) {
			linea = datosPronostico.get(i).split(",");
			
			personas.add(creaPersona(Integer.parseInt(linea[1]),linea[2]));
				
		}
		return personas;
	}
	
	private Persona creaPersona(int idPersona, String nombre) {
		return new Persona(idPersona,nombre);
	}
}
