package proyectoIntMaven;

import java.util.ArrayList;
import java.util.List;

public class ProcesaPartido {
	
	private LectorDeArchivo archivoPartidos;
	ArrayList<Partido> listaPartidos;
	private int cantidadDeRondas;
	
	
	public ProcesaPartido(String rutaOrigen) {
		this.archivoPartidos = new LectorDeArchivo(rutaOrigen);
		listaPartidos= new ArrayList<>();
	}
	public ArrayList<Partido> procesaDatos(){
		//Este metodo nos devuelve el array de pronosticos para pasarlo a la ronda
		List<String> datosPartido = this.archivoPartidos.parsearArchivo();
		String[] linea;
		//Recorremos la lista con los datos de los partidos
		//Si el archivo tiene encabezado comenzamos desde i=1;
		for(int i=1;i<datosPartido.size();i++) {
			String lineaLimpia = datosPartido.get(i).toUpperCase();
			linea = lineaLimpia.split(",");
			//Cada linea tiene la siguiente informacion: partidoID,numeroDeRonda,equipo1,equipo1,golesEquipo1,golesEquipo2
			//Creamos el Partido y lo agregamos al ArrayList}
			listaPartidos.add(creaPartido(Integer.parseInt(linea[0]),Integer.parseInt(linea[1]),linea[2],linea[3],Integer.parseInt(linea[4]),Integer.parseInt(linea[5])));
		}
		return this.listaPartidos;
	}
	
	/*public ArrayList<Partido> partidosPorRonda(int num){
		if(num > 0 && num <= this.cantidadDeRondas) {
			
		}
	}*/

	/*
	 * private List<String> limpiarDatos(List<String> datos){ for(int i=0;
	 * i<datos.size();i++) { datos.get(i). datos.get(i)=datos.get(i).toUpperCase();
	 * } return datos;
	 */
	//}
	private Partido creaPartido(int pID,int numRonda,String eq1, String eq2, int cantGoles1 , int cantGoles2 ) {
		return new Partido(pID, numRonda,new Equipo(eq1), new Equipo(eq2), cantGoles1, cantGoles2);
	}
	//Habria que agregar un metodo que verifique la cantidad de campos que tiene cada linea y ocuparla en el metodo procesaDatos().
	
}
