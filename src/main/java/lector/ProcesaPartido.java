package lector;

import java.util.ArrayList;
import java.util.List;
import excepciones.CamposInvalidosException;
import logica.Equipo;
import logica.Partido;
public class ProcesaPartido {
	
	private LectorDeArchivo archivoPartidos;
	ArrayList<Partido> listaPartidos;
	private int cantidadDeRondas;
	private boolean bandera = false; // la ocupamos para saber si el metodo procesaDatos() fue ejecutado.	
	
	public ProcesaPartido(String rutaOrigen) {
		this.archivoPartidos = new LectorDeArchivo(rutaOrigen);
		listaPartidos= new ArrayList<>();
	}
	public ArrayList<Partido> procesaDatos(){
		try {
			//Este metodo nos devuelve el array de pronosticos para pasarlo a la ronda
			List<String> datosPartido = this.archivoPartidos.parsearArchivo();
			String[] linea;
			//Recorremos la lista con los datos de los partidos
			//Si el archivo tiene encabezado comenzamos desde i=1;
			for(int i=1;i<datosPartido.size();i++) {
				String lineaLimpia = datosPartido.get(i).toUpperCase();
				linea = lineaLimpia.split(",");
				verificaCampos(linea.length);
				verificaGoles(linea[4]);
				verificaGoles(linea[5]);
				//Cada linea tiene la siguiente informacion: partidoID,numeroDeRonda,equipo1,equipo1,golesEquipo1,golesEquipo2
				//Creamos el Partido y lo agregamos al ArrayList}
				listaPartidos.add(creaPartido(Integer.parseInt(linea[0]),Integer.parseInt(linea[1]),linea[2],linea[3],Integer.parseInt(linea[4]),Integer.parseInt(linea[5])));
			}
			this.bandera= true;
			return this.listaPartidos;
		}catch(CamposInvalidosException e) {
			System.out.println("Error: alguna linea del archivo partidos tiene una cantidad de campos invalida.");
			e.getMessage();
		}
		return null;
	}
	private Partido creaPartido(int pID,int numRonda,String eq1, String eq2, int cantGoles1 , int cantGoles2 ) {
		return new Partido(pID, numRonda,new Equipo(eq1), new Equipo(eq2), cantGoles1, cantGoles2);
	}
	//Habria que agregar un metodo que verifique la cantidad de campos que tiene cada linea y ocuparla en el metodo procesaDatos().
	public ArrayList<Partido> partidosPorRonda(int num){ // este metodo tenia que devolver la cantidad de partidos o la lista de partidos que se juegan en esa ronda ?
		ArrayList<Partido> partidosRonda = null;
		if(num > 0 && num <= this.cantidadDeRondas && this.bandera) {
			partidosRonda = new ArrayList<Partido>();
			for(int i=0;i<this.listaPartidos.size();i++) {
				if(this.listaPartidos.get(i).getNumRonda() == num) {
					partidosRonda.add(this.listaPartidos.get(i));
				}
			}
		}else {
			System.out.println("No existe la ronda numero: "+num); // o this.listaPartidos es null.
		}
		return partidosRonda;
	}
	
	private void verificaCampos(int cantCampos) throws CamposInvalidosException {
		if(cantCampos!=6) {
			throw new CamposInvalidosException("Cantidad de campos invalida.");
		}
	}
	private void verificaGoles(String goles) {
		try {
			Integer.parseInt(goles);
		}catch(NumberFormatException e){
			System.out.println("El campo de goles no tiene un numero entero.");
		}
	}
}
