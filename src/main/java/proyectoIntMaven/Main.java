package proyectoIntMaven;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    	
    	ProcesaPartido p1 = new ProcesaPartido("../repoBecaN/resultados.txt");
    	ProcesaPronostico p2 = new ProcesaPronostico("../repoBecaN/pronosticos.txt");
    
        ArrayList<Partido> listaPartidos = p1.procesaDatos();
        ArrayList<Pronostico> listaPronostico = p2.procesaDatos();
        ArrayList<Persona> listaPersonas = p2.getListaPersonas();
        
        System.out.println("Cantidad de rondas: "+p1.cantRondas());
        System.out.println("Partidos de la ronda 2: "+p1.partidosPorRonda(2).size());
        System.out.println(listaPronostico);
        
        
		 for (int i=0; i < listaPersonas.size(); i++) {
			
			 for(int j=0; j < p1.cantRondas(); j++) {
				 
			 Ronda ronda = new Ronda(p1.cantRondas(),listaPersonas.get(i),listaPartidos, listaPersonas.get(i).getPronosticos());
			
		   System.out.println("Pronosticos acertados por " + listaPersonas.get(i).getNombre()+ " en la ronda"+ (j + 1) + ":" +ronda.puntos(j+1));
		 }}
		/*Ronda ronda1 = new Ronda("1",listaPartidos,listaPronostico);
    	System.out.println("Pronosticos acertados en la ronda 1: "+ronda1.puntos());
		*/
    }
}

