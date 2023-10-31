package proyectoIntMaven;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;



public class LectorDeArchivos {

	
	public static void main(String[] args) {
		
	
		LectorDeArchivos lectorDeArchivos = new LectorDeArchivos("C:\\Users\\GonzaloCalvimonte\\eclipse-workspace\\proyectoIntMaven\\resultados.csv",
		"C:\\Users\\GonzaloCalvimonte\\eclipse-workspace\\proyectoIntMaven\\pronosticos.csv");
		
		lectorDeArchivos.parsearArchivoPartidos();
		
	}
    String rutaArchivoPartidos;
    String rutaArchivoPronosticos;
    List<Partido> lineasPartidos;
    List<Pronostico> lineasPronosticos;
    
    public LectorDeArchivos(String rutaPartidos, String rutaPronosticos) {    	
        this.rutaArchivoPartidos = rutaPartidos;
        this.rutaArchivoPronosticos = rutaPronosticos;
        this.lineasPartidos = new ArrayList<>();
        this.lineasPronosticos = new ArrayList<>();
    }

    
	public void parsearArchivoPartidos() {
        List<Partido> listaPartidos = null;
        try {
            // En esta primera línea definimos el archivos que va a ingresar
        	listaPartidos = new CsvToBeanBuilder(new FileReader(this.rutaArchivoPartidos))
                    // con esta configuración podemos skipear la primera línea de nuestro archivo CSV
                    .withSkipLines(1)
                    // con esta configuración podemos elegir cual es el caracter que vamos a usar para delimitar
                    .withSeparator(';')
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(Partido.class)
                    .build()
                    .parse();

        } catch (IOException e) {
        e.printStackTrace();
    }
        this.lineasPartidos = listaPartidos;
    }
    
    public void parsearArchivoPronosticos() {
        List<Pronostico> listaPronosticos = null;
        try {
            // En esta primera línea definimos el archivos que va a ingresar
        	listaPronosticos = new CsvToBeanBuilder(new FileReader(this.rutaArchivoPronosticos))
                    // con esta configuración podemos skipear la primera línea de nuestro archivo CSV
                    .withSkipLines(1)
                    // con esta configuración podemos elegir cual es el caracter que vamos a usar para delimitar
                    .withSeparator(';')
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(Pronostico.class)
                    .build()
                    .parse();

        } catch (IOException e) {
        e.printStackTrace();
    }
        this.lineasPronosticos = listaPronosticos;
    }
    
    public void listarPartidos(){
    	for (int i = 0 ; i < lineasPartidos.size(); i++) {
			System.out.println(lineasPartidos.get(i));
		}
    }
    
   /* public ArrayList<Partido> listarPartidos(){
    	
    	ArrayList<Partido> partidos = new ArrayList<>();
    	
    	for (Partido lineaPartido : this.lineasPartidos) {
    		Equipo equipo1 = null;
    		int golesEquipo1 = 0;
    		int golesEquipo2 = 0;
    		Equipo equipo2 = null;
    		
    		for (Equipo equipo : equipos1) {
        		if(equipo.getNombre().equals(lineaPartido.getEquipo1())) {
        			equipo1 = equipo;
        		}
        	}
    		
    		for (Equipo equipo : equipos2) {
        		if(equipo.getNombre().equals(lineaPartido.getEquipo1())) {
        			equipo1 = equipo;
        		}
        	}
    	}
    	
    }*/
   /* public ArrayList<Inscripcion> listarInscripciones(Collection<Materia> materias , Collection<Alumno> alumnos){
    	
        boolean InscripcionYaCargada = false;
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();

            for (ArchivoInscripciones lineaarchivoInscripciones : this.lineasArchivoInscripciones) {
            	InscripcionYaCargada = false;
            	Alumno alumnoNuevo = null;
            	Materia materiaNueva = null;
            	for (Alumno alumno : alumnos) {
            		if(alumno.getNombre().equals(lineaarchivoInscripciones.getNombreAlumno())) {
            			alumnoNuevo = alumno;
            		}
            	}
            	
            	for (Materia materia : materias) {
            		if(materia.getNombre().equals(lineaarchivoInscripciones.getMateria())) {
            			materiaNueva = materia;
            		}
            	}
            	
                Inscripcion nuevaInscripcion = new Inscripcion(alumnoNuevo,
                		materiaNueva,
                		lineaarchivoInscripciones.getFechaDeInscripcion());

                for ( Inscripcion inscripcionGuardada : inscripciones) {
                    if (nuevaInscripcion.equals(inscripcionGuardada)) {
                    	InscripcionYaCargada = true;
                        break;
                    }
                }
                if (!InscripcionYaCargada) {
                	inscripciones.add(nuevaInscripcion);
                }
        }
        return inscripciones;
    }
    
    
}*/
    
}