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
	        ArrayList<Persona> listaPersonas = p2.getListaPersonas();
	           
	        System.out.println(listaPersonas);
	        System.out.println("Cantidad de rondas: "+p1.cantRondas());
	        System.out.println("Partidos de la ronda 2: "+p1.partidosPorRonda(2).size());
			/*
			 * for (int i=0; i < listaPersonas.size(); i++) {
			 * System.out.println(listaPersonas); System.out.println(listaPersonas.get(i));
			 * System.out.println("--Pronosticos de persona: "+i);
			 * System.out.println(listaPersonas.get(i).getPronosticos()); }
			 */
	    	for(int i = 0 ; i < p1.cantRondas(); i++) {
	    	System.out.println(listaPersonas.get(i).getPronosticos() + "soy el syso del main linea 29");
	        Ronda ronda = new Ronda(Integer.toString(i),listaPersonas.get(i),listaPartidos,listaPersonas.get(i).getPronosticos());
	        System.out.println("Pronosticos acertados en la ronda 1: " + ronda.puntos());
	        
	    }}

}

