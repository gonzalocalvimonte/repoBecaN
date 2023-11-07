package proyectoIntMaven;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Main {

	    public static void main(String[] args) {
	    	
	    	ProcesaPartido p1 = new ProcesaPartido("../repoBecaN/resultados.txt");
	    	ProcesaPronostico p2 = new ProcesaPronostico("../repoBecaN/pronosticos.txt");
	    
	        ArrayList<Partido> listaPartidos = p1.procesaDatos();
	        ArrayList<Pronostico> listaPronostico = p2.procesaDatos();
	        ArrayList<Persona> listaPersonas = p2.listaPersonas();
	        
	        for (int i=0; i < listaPersonas.size(); i++) {
				System.out.println(listaPersonas.get(i));
			
			}
	    	
	        /*Ronda ronda1 = new Ronda("1",listaPartidos,listaPronostico);
	        System.out.println("Pronosticos acertados en la ronda 1: "+ronda1.puntos());
	        */
	    }

}

