package lector;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LectorDeArchivo {
	//ATRIBUTOS
	//Guardamos en una variable la ruta donde se encuentra el archivo que queremos leer
	private String archALeer = null;
	
	//METODOS
	public LectorDeArchivo(String rutaOrigen) {
		if(!rutaOrigen.equals("")) {
			this.archALeer=rutaOrigen;
		}
	}
	public List<String> parsearArchivo(){
		//List<String> datosArchivo = null;
		//Leemos el archivo y devolvemos el contenido del mismo en un List<String>
		try {
			List<String> datosArchivo = Files.readAllLines(Paths.get(this.archALeer));
			return datosArchivo; // Devuelve una matriz con todos los datos del archivo
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Hubo problemas al leer el archivo.");
			e.printStackTrace();
		}
		return null; // Si es null es porque hubo un error
		
	}
	
	
	
}
	