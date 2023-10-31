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
    
    public Ronda(String numeroRonda, ArrayList<Partido> partidos, ArrayList<Pronostico> pronosticos) {
    	this.nro=numeroRonda;
    	this.partidos=partidos;
    	this.pronosticos=pronosticos;
    	//CREAR UNA CALSE LECTOR DE ARCHIVO Y USARLA DENTRO DE RONDA PARA OBTENER LOS DATOS.
    	//ACA LLAMAMOS AL METODO getDatos.
    }
    public int puntos(){
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
    }
    //CREAR UN METODO getDatos para inicializar partidos y pronosticos. 
    public String toString() {
    	String cad="";
    	cad+="Ronda numero: "+this.nro;
    	cad+=" cantidad de partidos jugados: "+this.partidos.size();
    	cad+=" puntos: "+puntos();
    	return cad;
    }
}
