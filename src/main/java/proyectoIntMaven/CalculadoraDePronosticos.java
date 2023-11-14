package proyectoIntMaven;

import java.util.ArrayList;

public class CalculadoraDePronosticos {
	
	private String archivoPartido;
	private String archivoPronostico;
	
	public CalculadoraDePronosticos(String archivoPart,String archivoPronos) {
      this.archivoPartido = archivoPart;
      this.archivoPronostico = archivoPronos;
    }
	
	
	public void calculadora(){
	ProcesaPartido p1 = new ProcesaPartido(archivoPartido);
	ProcesaPronostico p2 = new ProcesaPronostico(archivoPronostico);

    ArrayList<Partido> listaPartidos = p1.procesaDatos();
    ArrayList<Pronostico> listaPronostico = p2.procesaDatos();
    ArrayList<Persona> listaPersonas = p2.getListaPersonas();
    
   
	 for (int i=0; i < listaPersonas.size(); i++) {
		 System.out.println("Pronosticos de " + listaPersonas.get(i).getNombre());
		 Ronda ronda = new Ronda(p1.cantRondas(),listaPersonas.get(i),listaPartidos, listaPersonas.get(i).getPronosticos());
		 for(int j=0; j < p1.cantRondas(); j++) {
			 

	   System.out.println("Pronosticos acertados por " + listaPersonas.get(i).getNombre()+ " en la ronda "+ (j + 1) + ": " +ronda.puntosPorRonda(j+1));
	 }
		 System.out.println("Pronosticos acertados por " + listaPersonas.get(i).getNombre()+ " en todas las rondas : " +ronda.puntos());}


    }
		}