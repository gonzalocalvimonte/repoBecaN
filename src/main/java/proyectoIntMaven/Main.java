package proyectoIntMaven;

import java.util.ArrayList;

public class Main {

	    public static void main(String[] args) {
	        // TODO code application logic here
	    	//equipos
	        Equipo eq1 = new Equipo("LosPeques ", "Alp2 ");
	        Equipo eq2 = new Equipo("Messi ", " LosBuenos");
	        Equipo eq3 = new Equipo("Lalal", "asdas");
	        System.out.println("Equipo 1 " + eq1.getNombre() + eq1.getDescripcion());
	        System.out.println("Equipo 2 " + eq2.getNombre() + eq2.getDescripcion());
	        //PARTIDOS Y PRONOSTICOS
	        Partido p1 = new Partido(eq1, eq2, 2, 1);//Gana eq1
	        Partido p2 = new Partido(eq1, eq2, 1, 2);//Gana eq2
	        Partido p3 = new Partido(eq1, eq2, 0, 0);
	        Partido p4 = new Partido(eq1, eq3, 1, 3);
	        Pronostico pron1 = new Pronostico(p1,eq1,ResultadoEnum.GANADOR);
	        Pronostico pron2 = new Pronostico(p2,eq1,ResultadoEnum.PERDEDOR);
	        Pronostico pron3 = new Pronostico(p3,eq2,ResultadoEnum.GANADOR);
	        Pronostico pron4 = new Pronostico(p4,eq3,ResultadoEnum.GANADOR);
	        //Arrays
	        ArrayList<Partido> partidos = new ArrayList<>();
	        partidos.add(p1);
	        partidos.add(p2);
	        partidos.add(p3);
	        partidos.add(p4);
	        ArrayList<Pronostico> pronosticos = new ArrayList<>();
	        pronosticos.add(pron1);
	        pronosticos.add(pron2);
	        pronosticos.add(pron3);
	        pronosticos.add(pron4);
	        //RONDA
	        Ronda ronda1 = new Ronda("1",partidos,pronosticos);
	        int puntos = 0;
	        puntos = ronda1.puntos();
	        System.out.println(ronda1);
	        System.out.println("Puntos de la persona que pronostico: "+puntos);
	        
	        
	    }

}

