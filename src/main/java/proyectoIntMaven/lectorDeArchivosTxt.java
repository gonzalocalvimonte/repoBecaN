package proyectoIntMaven;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class lectorDeArchivosTxt {
	
	public static void main(String[] args) {
		lectorArchivos("C:\\Users\\GonzaloCalvimonte\\eclipse-workspace\\proyectoIntMaven\\resultados.txt",
				"C:\\Users\\GonzaloCalvimonte\\eclipse-workspace\\proyectoIntMaven\\pronosticos.txt");
	}
	
	public static void lectorArchivos(String archivoRes, String archivoPro) {
	String archivoResultados = archivoRes;
	String archivoPronosticos= archivoPro;
	ArrayList<Partido> arrayDePartidos = null;
	ArrayList<Pronostico> arrayDePronosticos = null;
	
	try {
		List<String> listaPartidos = Files.readAllLines(Paths.get(archivoResultados));
		List<String> listaPronosticos = Files.readAllLines(Paths.get(archivoPronosticos));
		
		String [] datosPartido1 = listaPartidos.get(1).split(";");
		String [] datosPartido2 = listaPartidos.get(2).split(";");
		
		Equipo equipo1 = new Equipo( datosPartido1[1],"lo que sea");
		Equipo equipo2 = new Equipo( datosPartido1[2],"lo que sea");
		Equipo equipo3 = new Equipo( datosPartido2[1],"lo que sea");
		Equipo equipo4 = new Equipo( datosPartido2[2],"lo que sea");
		
		Partido partido1= new Partido(Integer.parseInt(datosPartido1[0]),equipo1, equipo2 ,Integer.parseInt(datosPartido1[3]), Integer.parseInt(datosPartido1[4]));
		Partido partido2= new Partido(Integer.parseInt(datosPartido2[0]),equipo3, equipo4 ,Integer.parseInt(datosPartido2[3]), Integer.parseInt(datosPartido2[4]));
		
		ArrayList<Partido> partidos = new ArrayList<>();
        partidos.add(partido1);
        partidos.add(partido2);
        
        arrayDePartidos = partidos;
        
        System.out.println("lista partidos");
        System.out.print(partidos);
        
        String [] datosPronostico1 = listaPronosticos.get(1).split(";");
		String [] datosPronostico2 = listaPronosticos.get(2).split(";");
		
		//falta definir como cargaremos los pronosticos en el archivo 
		
		Equipo equipoPro1 = new Equipo(datosPronostico1[1],"lo que sea");
		Equipo equipoPro2 = new Equipo(datosPronostico2[1],"lo que sea");
		ResultadoEnum resultadoPro1 = null;
		ResultadoEnum resultadoPro2 = null;
		 
		if(datosPronostico1[2] == "GANADOR") {
			resultadoPro1 = ResultadoEnum.GANADOR;			
		} else if(datosPronostico1[2] == "PERDEDOR" ) {
			resultadoPro1 = ResultadoEnum.PERDEDOR;			
		}else {
			resultadoPro1 = ResultadoEnum.EMPATE;
		}
		
		if(datosPronostico2[2] == "GANADOR") {			
			resultadoPro2 = ResultadoEnum.GANADOR;
		} else if(datosPronostico2[2] == "PERDEDOR") {			
			resultadoPro2 = ResultadoEnum.PERDEDOR;
		}else {			
			resultadoPro2 = ResultadoEnum.EMPATE;
		}
		
		
		Pronostico pronostico1 = new Pronostico(Integer.parseInt(datosPartido1[0]),equipoPro1,resultadoPro1);
		Pronostico pronostico2 = new Pronostico(Integer.parseInt(datosPartido1[0]),equipoPro2,resultadoPro2);
			
		ArrayList<Pronostico> pronosticos = new ArrayList<>();
		pronosticos.add(pronostico1);
        pronosticos.add(pronostico2);
		
        arrayDePronosticos = pronosticos;
        
        System.out.println("lista pronosticos");
        System.out.println(pronosticos);
        
	}catch(Exception e){
		System.out.println("Hubo un error en la operacion" + e);
	}
	return;
}
	
}
	