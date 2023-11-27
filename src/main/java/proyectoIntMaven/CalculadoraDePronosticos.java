package proyectoIntMaven;

import java.util.ArrayList;

import db.consultasDB;
import logica.Partido;
import logica.Persona;
import logica.Pronostico;
import logica.Ronda;
import logica.metodosUtilitarios;

public class CalculadoraDePronosticos {
	
	private String archivoPartido;
	private String archivoPronostico;
	
	public CalculadoraDePronosticos(String archivoPart,String archivoPronos) {
      this.archivoPartido = archivoPart;
      this.archivoPronostico = archivoPronos;
    }
	
	
	public String calculadora(){
		/*ProcesaPartido p1 = new ProcesaPartido(archivoPartido);
		ProcesaPronostico p2 = new ProcesaPronostico(archivoPronostico);
		

		ArrayList<Partido> listaPartidos = p1.procesaDatos();// Aqui estan los partidos de TODAS rondas
		ArrayList<Pronostico> listaPronostico = p2.procesaDatos();
		ArrayList<Persona> listaPersonas = p2.getListaPersonas();*/
		
		ArrayList<Partido> listaPartidos = consultasDB.consultaPartidos(); /*Aqui estan los partidos de TODAS rondas*/
		ArrayList<Pronostico> listaPronosticos = consultasDB.consultaPronosticos();
		ArrayList<Persona> listaPersonas = consultasDB.consultaPersonas();
		int puntosXAcierto = consultasDB.consultaPuntosXAcierto();
		int puntosExtra = consultasDB.consultaPuntosExtra();
		System.out.println("Puntos por acierto: "+puntosXAcierto);
		System.out.println("Puntos extra: "+puntosExtra);
		Ronda.setPuntosXAcierto(puntosXAcierto);//seteamos los puntos por acierto segun lo que nos dice la base de datos. Lo hicimos configurable
		Ronda.setPuntosExtra(puntosExtra);
		metodosUtilitarios.asignaPronosticos(listaPersonas, listaPronosticos);
		
		
		ArrayList<Ronda> listaRondas = new ArrayList<>();
		String cad="";
		int cantRondas = metodosUtilitarios.cantRondas(listaPartidos);
		System.out.println("Cant rondas: " + cantRondas);
		for (int i = 0; i < cantRondas; i++) {
			int j = i + 1;//j indica el numero de ronda, comienza en 1.
			listaRondas.add(new Ronda(String.valueOf(j), listaPersonas, listaPartidos, listaPronosticos));
		}
		
		for (int i = 0; i < listaRondas.size(); i++) {
			cad+=listaRondas.get(i).mostrarPuntosRonda();
		}
		return cad;
	}
}