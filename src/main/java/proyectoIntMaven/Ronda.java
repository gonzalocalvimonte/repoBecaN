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
    
    private String nro;
    private ArrayList<Partido> partidos;
    private ArrayList<Pronostico> pronosticos;
    private Persona persona; 
    
    public Ronda(String numeroRonda, Persona persona ,ArrayList<Partido> partidos, ArrayList<Pronostico> pronosticos) {
    	this.nro=numeroRonda;
    	this.persona=persona;
    	this.partidos=partidos;
    	this.pronosticos=pronosticos;
    	//CREAR UNA CALSE LECTOR DE ARCHIVO Y USARLA DENTRO DE RONDA PARA OBTENER LOS DATOS.
    	//ACA LLAMAMOS AL METODO getDatos.
    }
    public int puntos(){
    	int puntosAcum = 0;
    	System.out.println(partidos.size()+ " soy el syso de Ronda linea 31");
    	System.out.println(persona.getPronosticos().size() + " soy el syso de Ronda linea 32");
        if (partidos.size()==persona.getPronosticos().size()) {// Solo se ejecuta si el numero de partidos coincide con el numero de pronosticos.
            for (int i = 0; i < partidos.size(); i++) {
                if(partidos.get(i).resultado(persona.getPronosticos().get(i).getEquipo()) == persona.getPronosticos().get(i).getResultado()) {
                	puntosAcum++;
                }}
        }else {
        	System.out.println("No coincide el numero de partidos con el numero de pronosticos.");
        	return -1;
        }
        return puntosAcum;
    }
    /*public int puntos(){
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
    
    /*public int puntos(){
    	int puntosAcum = 0;
        if (partidos.size()==pronosticos.size()) {// Solo se ejecuta si el numero de partidos coincide con el numero de pronosticos.
            for (int i = 0; i < partidos.size(); i++) {
                if(partidos.get(i).resultado(pronosticos.get(i).getEquipo()) == pronosticos.get(i).getResultado() ) {
                	puntosAcum++;
                }
            }
        }else {
        	System.out.println("No coincide el numero de partidos con el numero de pronosticos.");
        	return -1;
        }
        return puntosAcum;
    }*/
    
    
    
    
    
    //CREAR UN METODO getDatos para inicializar partidos y pronosticos. 
    public String toString() {
    	String cad="";
    	cad+="Ronda numero: "+this.nro;
    	cad+=" cantidad de partidos jugados: "+this.partidos.size();
    	cad+=" puntos: "+puntos();
    	return cad;
    }
}
