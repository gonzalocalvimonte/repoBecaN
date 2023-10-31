package proyectoIntMaven;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class lectorDeArchivosTxt {
	
	
	public static void lectorArchivos(String archivoRes, String archivoPro) {
	String archivoResultados = archivoRes;
	String archivoPronosticos= archivoPro;
	
	{
	try {
		List<String> listaPartidos = Files.readAllLines(Paths.get(archivoResultados));
		List<String> listaPronosticos = Files.readAllLines(Paths.get(archivoPronosticos));
		
		String [] datosPartido1 = listaPartidos.get(1).split(";");
		String [] datosPartido2 = listaPartidos.get(2).split(";");
		
		Equipo equipo1 = new Equipo( datosPartido1[0],"lo que sea");
		Equipo equipo2 = new Equipo( datosPartido1[3],"lo que sea");
		Equipo equipo3 = new Equipo( datosPartido2[0],"lo que sea");
		Equipo equipo4 = new Equipo( datosPartido2[3],"lo que sea");
		
		Partido partido1= new Partido(equipo1, equipo2 ,Integer.parseInt(datosPartido1[1]), Integer.parseInt(datosPartido1[2]));
		Partido partido2= new Partido(equipo3, equipo4 ,Integer.parseInt(datosPartido2[1]), Integer.parseInt(datosPartido2[2]));
		
		ArrayList<Partido> partidos = new ArrayList<>();
        partidos.add(partido1);
        partidos.add(partido2);
        
        
        String [] datosPronostico1 = listaPronosticos.get(1).split(";");
		String [] datosPronostico2 = listaPronosticos.get(2).split(";");
		
		//falta definir como cargaremos los pronosticos en el archivo 
		
		String[] equipoLocal = listaPartidos.get(0).split(";");
		String [] golesEquipoLocal = listaPartidos.get(1).split(";");
		String [] golesEquipoVisit = listaPartidos.get(2).split(";");
		String [] equipoVisit = listaPartidos.get(3).split(";");
		
		String[] partidoNumero = listaPronosticos.get(0).split(";");
		String [] equipo = listaPronosticos.get(1).split(";");
		String [] resultado = listaPronosticos.get(2).split(";");
		
		
		
	}catch(Exception e){
		
	}
}
}
	}