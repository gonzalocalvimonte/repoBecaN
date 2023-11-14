package proyectoIntMaven;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
    	CalculadoraDePronosticos Calculadora = 
    			new CalculadoraDePronosticos("../repoBecaN/resultados.txt","../repoBecaN/pronosticos.txt");
    	
    
		Calculadora.calculadora();
		
}
    }

