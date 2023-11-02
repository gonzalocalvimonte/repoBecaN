package proyectoIntMaven;

import java.util.ArrayList;
import java.util.List;


public class Main {

	    public static void main(String[] args) {
	    	//lectorDeArchivosTxt archPartidos = new lectorDeArchivosTxt("C:\\Users\\jijau\\OneDrive\\Escritorio\\Partidos.txt");
	    	//lectorDeArchivosTxt archPronosticos = new lectorDeArchivosTxt("C:\\Users\\jijau\\OneDrive\\Escritorio\\Pronosticos.txt");
	    	ProcesaPartido p1 = new ProcesaPartido("C:\\Users\\jijau\\OneDrive\\Escritorio\\Partidos.txt");
	    	ProcesaPronostico p2 = new ProcesaPronostico("C:\\Users\\jijau\\OneDrive\\Escritorio\\Pronosticos.txt");
	    	//List<String> datosPartidos = archPartidos.parsearArchivo();
	    	//List<String> datosPronosticos = archPronosticos.parsearArchivo();
	        ArrayList<Partido> listaPartidos = p1.procesaDatos();
	        ArrayList<Pronostico> listaPronostico = p2.procesaDatos();
	    	for(int i=0; i<listaPartidos.size();i++) {
	        	System.out.println(listaPartidos.get(i));
	        }
	        for(int i=0; i<listaPronostico.size();i++) {
	        	System.out.println(listaPronostico.get(i));
	        }
	        Ronda ronda1 = new Ronda("1",listaPartidos,listaPronostico);
	        System.out.println(ronda1.puntos());
	        
	    }

}

