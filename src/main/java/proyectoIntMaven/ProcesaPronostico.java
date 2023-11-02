package proyectoIntMaven;

import java.util.ArrayList;
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
		for(int i=0;i<datosPronostico.size();i++) {
			linea = datosPronostico.get(i).split(";");
			//Cada linea tiene la siguiente informacion: partidoID,equipo,resultado(prediccion)
			//Creamos el Partido y lo agregamos al ArrayList}
			listaPronosticos.add(creaPronostico(Integer.parseInt(linea[0]),linea[1],ResultadoEnum.valueOf(linea[2])));
		}
		return this.listaPronosticos;
	}
	private Pronostico creaPronostico(int pID, String equipo, ResultadoEnum resultado ) {
		return new Pronostico(pID,new Equipo(equipo), resultado);
	}
}
