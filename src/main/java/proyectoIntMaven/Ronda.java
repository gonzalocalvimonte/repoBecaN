/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoIntMaven;

import java.util.ArrayList;

/**
 *
 * @author FraNko
 */
public class Ronda {
	
	private String numRonda;
    private int cantRondas;
    private ArrayList<Partido> partidos;
    private ArrayList<Pronostico> pronosticos;
    private Persona persona; 
    
    public Ronda(int numeroRondas, Persona persona ,ArrayList<Partido> partidos, ArrayList<Pronostico> pronosticos) {
    	this.cantRondas =numeroRondas;
    	this.persona=persona;
    	this.partidos=partidos;
    	this.pronosticos=pronosticos;
    }
    @SuppressWarnings("unused")
    //Corregir: Ronda calcula el puntaje de SU ronda, no de todas las rondas
    //Una idea seria hacer un metodo puntosXRonda, donde en su interior itere el array de personas y calcule el puntaje de cada persona
    //Alli dentro podria llamarse a un metodo puntosXPersona(p), que calcula los puntos de la persona ´p´ que recibe por parametro.
	public int puntosPorRonda(int ronda) {
		int puntosRonda = 0;
		for (int i = 1; i < cantRondas + 1; i++) {
			for (int j = 0; j < partidos.size(); j++) {
				if (partidos.get(j).getNumRonda() == ronda
						&& persona.getPronosticos().get(j).getNumeroDeRonda() == ronda) {
					if (partidos.get(j).resultado(persona.getPronosticos().get(j).getEquipo()) == persona
							.getPronosticos().get(j).getResultado()) {
						puntosRonda++;
					}
				}
			}
			return puntosRonda;
		}
		return puntosRonda;
	}
    

    public int puntos(){
    	int puntosAcum = 0;
        if (partidos.size()==persona.getPronosticos().size()) {// Solo se ejecuta si el numero de partidos coincide con el numero de pronosticos.
            for (int i = 0; i < partidos.size(); i++) {
                if(partidos.get(i).resultado(persona.getPronosticos().get(i).getEquipo()) == persona.getPronosticos().get(i).getResultado()) {
                	puntosAcum++;
                }
            }
        }else {
        	System.out.println("No coincide el numero de partidos con el numero de pronosticos.");
        	return -1;
        }
        return puntosAcum;
    }
    
  
    //CREAR UN METODO getDatos para inicializar partidos y pronosticos. 
    public String toString() {
    	String cad="";
    	cad+="Ronda numero: "+this.cantRondas;
    	cad+=" cantidad de partidos jugados: "+this.partidos.size();
    	
    	return cad;
    }
}
