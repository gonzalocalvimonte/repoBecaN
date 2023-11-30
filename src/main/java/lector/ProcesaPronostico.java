package lector;

import java.util.ArrayList;
import java.util.List;
import excepciones.CamposInvalidosException;
import logica.Equipo;
import logica.Partido;
import logica.Persona;
import logica.Pronostico;
import logica.ResultadoEnum;
import logica.metodosUtilitarios;

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
		try {
			//Este metodo nos devuelve el array de pronosticos para pasarlo a la ronda
			List<String> datosPronostico = this.archivoPartidos.parsearArchivo();
			String[] linea;
			//Recorremos la lista con los datos de los partidos
			//Si el archivo tiene encabezado comenzamos desde i=1;
			for(int i=1;i<datosPronostico.size();i++) {
				String lineaLimpia = datosPronostico.get(i).toUpperCase();
				linea = lineaLimpia.split(",");
				verificaCampos(linea.length);
				//Cada linea tiene la siguiente informacion: partidoID,equipo,resultado(prediccion) numeroDePartido;idPersona;persona;equipo;resultado
				//Creamos el Pronostico y lo agregamos al ArrayList}
				this.listaPronosticos.add(creaPronostico(Integer.parseInt(linea[0]),Integer.parseInt(linea[1]),Integer.parseInt(linea[2]),linea[4],ResultadoEnum.valueOf(linea[5])));
			}
			listaPersonas(); // creamos la lista de personas que participan
			metodosUtilitarios.asignaPronosticos(this.listaPersonas,this.listaPronosticos); // Asignamos a las distintas personas sus pronosticos correspondientes.
			return this.listaPronosticos;
		}catch(CamposInvalidosException e) {
			System.out.println("Error: alguna linea del archivo pronosticos tiene una cantidad de campos invalida.");
		}
		return null;
	}
	
	private Pronostico creaPronostico(int numeroRonda,int partidoNum,int pID, String equipo, ResultadoEnum resultado ) {
		return new Pronostico(numeroRonda,partidoNum,pID,new Equipo(equipo), resultado);
	}
	
	private void listaPersonas(){//Creamos la lista de personas que participan a partir del archivo pronosticos.txt
		List<String> datosPronostico = this.archivoPartidos.parsearArchivo();
		String[] linea;
		int cantidadDePersonas = this.listaPronosticos.size() / Partido.getCantPartidos();
 		
		for (int i= 1; i < datosPronostico.size() ; i += Partido.getCantPartidos()) {
			linea = datosPronostico.get(i).split(",");
			this.listaPersonas.add(creaPersona(Integer.parseInt(linea[2]),linea[3]));
		}
	}
	
	private Persona creaPersona(int idPersona, String nombre) {
		return new Persona(idPersona,nombre);
	}
	//Metodo que asigna a cada persona los pronosticos correspondientes.
	
	
	private void verificaCampos(int cantCampos) throws CamposInvalidosException{
		if(cantCampos!=6) {
			throw new CamposInvalidosException("La cantidad de campos no es valida.");
		}
	}
}
	

