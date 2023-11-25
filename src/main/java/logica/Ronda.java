/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FraNko
 */
public class Ronda {
	private static int puntosXAcierto;
	private static int puntosExtra;
	private String numRonda;
    private ArrayList<Partido> partidos;
    private ArrayList<Pronostico> pronosticos;//Si cada persona ya tiene los pronosticos, ¿es necesario tener este atributo?
    private ArrayList<Persona> personas;
    
    public Ronda(String numRonda, ArrayList<Persona> personas ,ArrayList<Partido> partidos, ArrayList<Pronostico> pronosticos) {
    	this.numRonda=numRonda;
    	this.personas=personas;
    	this.partidos=partidos;
    	this.pronosticos=pronosticos;
    }
    public String getNumRonda() {
    	return this.numRonda;
    }
    public static void setPuntosXAcierto(int num) {
    	puntosXAcierto=num;
    }
    public static void setPuntosExtra(int num) {
    	puntosExtra=num;
    }
    public void mostrarPuntosRonda() { //este metodo usa el metodo private puntosPorRonda
    	puntosPorRonda();
    	System.out.println("-----RONDA "+this.numRonda+"-----");
    	for(int i=0; i<this.personas.size();i++) {
    		System.out.print(this.personas.get(i));
    		System.out.println("-----------------------------");
    	}
    }
    
    private void puntosPorRonda() {//este metodo usa el metodo private puntosXPersona
    	for(int i=0;i<this.personas.size();i++) {
    		this.personas.get(i).setPuntosXRonda(puntosXPersona(this.personas.get(i)));// A cada persona le seteamos los puntos que obtuvo en esta ronda.
    	}
    }
    private int puntosXPersona(Persona p) {
    	int acumPuntos= 0;
    	int contadorPartidos=0;
    	int i=0;
    	while(i<p.getPronosticos().size()) {
    		if((p.getPronosticos().get(i).getNumeroDeRonda()==Integer.parseInt(this.numRonda))) {
        		//Aqui adentro comparo el resultado del pronostico de la persona con el resultado del partido correspondiente.
        		//Primero necesitamos el id del partido pronosticado para luego buscar ese partido en el arrayList de partidos.
        		contadorPartidos++;//Por la cantidad de pronosticos sabemos cuantos partidos hay en la ronda, pues una persona pronostica todos los partidos de una ronda.
    			int idPartido = p.getPronosticos().get(i).getPartidoNumero();//Aca guardamos el id del partido con el que debemos comparar.
        		if(p.getPronosticos().get(i).getResultado() == this.partidos.get(idPartido-1).resultado(p.getPronosticos().get(i).getEquipo())) {	
        			acumPuntos+=puntosXAcierto; //Sumamos 1 punto por el acierto del pronostico.
        		}
    		}
    		i++;//Actualizamos i.
    	}
		//Agregamos puntos extra si acierta todo sus pronosticos
		if(agregaPuntosExtra(acumPuntos,contadorPartidos)) {
			acumPuntos+=puntosExtra;
		}
    	return acumPuntos;
    }
    private boolean agregaPuntosExtra(int puntosRondaPersona, int cantPartidosRonda) {
    	//Recibe los puntos obtenidos por una persona en la ronda y decide si hay que agregar puntos extra o no.
    	//Agregamos puntos extra cuando acierta todos los partidos de una ronda.
    	//Necesitamos saber cuantos partidos tiene la ronda.
    	return ((puntosRondaPersona/puntosXAcierto) == cantPartidosRonda); // puntosRondaPersona/puntosXAcierto nos devulve la cantidad de pronosticos acertados correctamente.
    }
     
    public String toString() {
    	String cad="";
    	cad+="Ronda numero: "+this.numRonda;
    	cad+=" cantidad de partidos jugados: "+this.partidos.size();
    	
    	return cad;
    }
}
