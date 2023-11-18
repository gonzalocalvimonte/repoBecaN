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

		ArrayList<Partido> listaPartidos = p1.procesaDatos();// Aqui estan los partidos de TODAS rondas
		ArrayList<Pronostico> listaPronostico = p2.procesaDatos();
		ArrayList<Persona> listaPersonas = p2.getListaPersonas();
		ArrayList<Ronda> listaRondas = new ArrayList<>();
		int cantRondas = p1.cantRondas();
		System.out.println("Cant rondas: " + cantRondas);
		for (int i = 0; i < cantRondas; i++) {
			int j = i + 1;//j indica el numero de ronda, comienza en 1.
			listaRondas.add(new Ronda(String.valueOf(j), listaPersonas, listaPartidos, listaPronostico));
		}
		for (int i = 0; i < listaRondas.size(); i++) {
			listaRondas.get(i).mostrarPuntosRonda();
		}
	}
}