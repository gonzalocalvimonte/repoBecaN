package logica;

import java.util.ArrayList;

public class metodosUtilitarios {

	public static int cantRondas(ArrayList<Partido> listaPartidos) {
		boolean bandera = false;
		
		int cantidadDeRondas=0;
		
		if(!bandera) {
			for(int i=0;i<listaPartidos.size()-1;i++) {
				if(listaPartidos.get(i).getNumRonda() != listaPartidos.get(i+1).getNumRonda()) {
					cantidadDeRondas++;
				}
			}
			cantidadDeRondas++;//sumamos uno porque en el ciclo cuenta la cantidad de veces que cambia el numero de rondas.
		}
		return cantidadDeRondas;
	}
	
	public static void asignaPronosticos(ArrayList<Persona> listaPersonas,ArrayList<Pronostico> listaPronosticos) {
		
		boolean bandera = true;
		int j=0,aux=0;
		for(int i=0;i<listaPersonas.size();i++) {
			j=aux;
			bandera=true;
			while(j<listaPronosticos.size() && bandera){
				if(listaPronosticos.get(j).getIdPersona() == listaPersonas.get(i).getIdPersona()) {
					listaPersonas.get(i).agregaPronostico(listaPronosticos.get(j));//Agregamos a la persona i, el pronostico j
				}else {
					aux=j;
					bandera=false;
				}
				j++;
			}
		}
	}
}
