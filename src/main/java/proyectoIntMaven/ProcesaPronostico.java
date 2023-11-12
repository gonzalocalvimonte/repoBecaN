package proyectoIntMaven;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProcesaPronostico {
	private LectorDeArchivo archivoPartidos;
	private ArrayList<Pronostico> listaPronosticos;
	private ArrayList<Persona> listaPersonas;
	
	public ProcesaPronostico(String rutaOrigen) {
		this.archivoPartidos = new LectorDeArchivo(rutaOrigen);
		this.listaPronosticos= new ArrayList<>();
		this.listaPersonas= new ArrayList<>();
	}
	public ArrayList<Persona> getListaPersonas(){
		return this.listaPersonas;
	}
	
	public ArrayList<Pronostico> procesaDatos(){
		//Este metodo nos devuelve el array de pronosticos para pasarlo a la ronda
		List<String> datosPronostico = this.archivoPartidos.parsearArchivo();
		String[] linea;
		//Recorremos la lista con los datos de los partidos
		//Si el archivo tiene encabezado comenzamos desde i=1;
		for(int i=1;i<datosPronostico.size();i++) {
			linea = datosPronostico.get(i).split(",");
			
			//Cada linea tiene la siguiente informacion: partidoID,equipo,resultado(prediccion) numeroDePartido;idPersona;persona;equipo;resultado
			//Creamos el Partido y lo agregamos al ArrayList}
			this.listaPronosticos.add(creaPronostico(Integer.parseInt(linea[0]),Integer.parseInt(linea[1]),linea[3],ResultadoEnum.valueOf(linea[4])));
			
		}
		listaPersonas(); // creamos la lista de personas que participan
		asignaPronosticos(); // Asignamos a las distintas personas sus pronosticos correspondientes.
		return this.listaPronosticos;
	}
	
	
	private Pronostico creaPronostico(int partidoNum,int pID, String equipo, ResultadoEnum resultado ) {
		return new Pronostico(partidoNum,pID,new Equipo(equipo), resultado);
	}
	
	private void listaPersonas(){//Creamos la lista de personas que participan a partir del archivo pronosticos.txt
		List<String> datosPronostico = this.archivoPartidos.parsearArchivo();
		ArrayList<Pronostico> pronosPers = new ArrayList<Pronostico>();
		String[] linea;
		int cantidadDePersonas = this.listaPronosticos.size() / Partido.getCantPartidos();
 		
		for (int i= 1; i < datosPronostico.size() ; i += Partido.getCantPartidos()) {
			linea = datosPronostico.get(i).split(",");
			this.listaPersonas.add(creaPersona(Integer.parseInt(linea[1]),linea[2],pronosPers));
		}
	}
	
	
	private Persona creaPersona(int idPersona, String nombre, ArrayList<Pronostico> pronosPers ) {
		return new Persona(idPersona,nombre,pronosPers);
	}
	//Metodo que asigna a cada persona los pronosticos correspondientes.
	
	
	private void asignaPronosticos() {
		System.out.println("tamaño de listaPronostico "+this.listaPronosticos.size() + " ,personas son " + this.listaPersonas.size());
		ArrayList<Pronostico> seteoPronosticos = new ArrayList<>();
	
		for(int i=0;i<this.listaPersonas.size();i++) {
			

			for(int j = 0 ; j < this.listaPronosticos.size(); j++) {
			
				if(this.listaPronosticos.get(j).getIdPersona() == this.listaPersonas.get(i).getIdPersona()) {
					seteoPronosticos.add(this.listaPronosticos.get(j));//Agregamos a la persona i, el pronostico j
				}
				
			}
			this.listaPersonas.get(i).setPronosticos(seteoPronosticos);
			System.out.println(this.listaPersonas.get(i).getPronosticos() +  "soy el syso del asignaPronostico linea 79");
			seteoPronosticos.clear();
			
		}
		
		
	}

}
