package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import logica.Equipo;
import logica.Partido;
import logica.Persona;
import logica.Pronostico;
import logica.ResultadoEnum;

public class consultasDB {
	static Connection conexion = null;
    static java.sql.Statement consulta = null;
    ArrayList<Partido> listaPartidos ;
    ArrayList<Pronostico> listaPronosticos;
    ArrayList<Persona> listaPersonas;
    
    
	public static ArrayList<Partido> consultaPartidos() {
		ArrayList<Partido> listaPartidos = null;
		try {
			listaPartidos = new ArrayList<>();
			// Abrir la conexión
			// System.out.println("conectando a la base de datos...");
			conexion = DriverManager.getConnection(ConectorSQL.DB_URL, ConectorSQL.USER, ConectorSQL.PASS);
			// Ejecutar una consulta
			// System.out.println("Creating statement...");
			consulta = conexion.createStatement();
			String sql;
			sql = "SELECT * FROM apuestasdeportivas.resultadospartidos";
			// En la variable resultado obtendremos las distintas filas que nos devolvió la
			// base
			ResultSet resultado = consulta.executeQuery(sql);
			// Obtener las distintas filas de la consulta
			while (resultado.next()) {
				// Pbtener el valor de cada columna
				int idPartido = resultado.getInt("idPartido");
				int idRonda = resultado.getInt("idRonda");
				String equipo1 = resultado.getString("equipo1");
				String equipo2 = resultado.getString("equipo2");
				int golesEquipo1 = resultado.getInt("golesEquipo1");
				int golesEquipo2 = resultado.getInt("golesEquipo2");

				Equipo equipo11 = new Equipo(equipo1);
				Equipo equipo22 = new Equipo(equipo2);
				Partido partido = new Partido(idPartido, idRonda, equipo11, equipo22, golesEquipo1, golesEquipo2);
				listaPartidos.add(partido);
			}
			// Esto se utiliza par cerrar la conexión con la base de datos
			resultado.close();
			consulta.close();
			conexion.close();
			// System.out.println("Fin de la ejecucción");
		} catch (SQLException se) {
			// Execpción ante problemas de conexión
			se.printStackTrace();
		} finally {
			// Esta sentencia es para que ante un problema con la base igual se cierren las
			// conexiones
			try {
				if (consulta != null)
					consulta.close();
			} catch (SQLException se2) {
			}
			try {
				if (conexion != null)
					conexion.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return listaPartidos;
    }
	
	public static ArrayList<Pronostico> consultaPronosticos() {
		ArrayList<Pronostico> listaPronosticos = null;
		try {
			listaPronosticos = new ArrayList<>();
			// Abrir la conexión
			// System.out.println("conectando a la base de datos...");
			conexion = DriverManager.getConnection(ConectorSQL.DB_URL, ConectorSQL.USER, ConectorSQL.PASS);
			// Ejecutar una consulta
			// System.out.println("Creando statement...");
			consulta = conexion.createStatement();
			String sql;
			sql = "SELECT * FROM apuestasdeportivas.pronosticos";
			// En la variable resultado obtendremos las distintas filas que nos devolvió la
			// base
			ResultSet resultado = consulta.executeQuery(sql);
			// Obtener las distintas filas de la consulta
			while (resultado.next()) {
				// Pbtener el valor de cada columna
				int idRonda = resultado.getInt("idRonda");
				int idPartido = resultado.getInt("idPartido");
				int idPersona = resultado.getInt("idPersona");
				String nombrePersona = resultado.getString("nombrePersona");
				String equipodb = resultado.getString("equipo");
				String resultadoDB = resultado.getString("resultado").toUpperCase();

				Equipo equipo = new Equipo(equipodb);
				Pronostico pronostico = new Pronostico(idRonda, idPartido, idPersona, equipo,
						ResultadoEnum.valueOf(resultadoDB));
				listaPronosticos.add(pronostico);
			}
			// Esto se utiliza par cerrar la conexión con la base de datos
			resultado.close();
			consulta.close();
			conexion.close();
			// System.out.println("Fin de la ejecucción");
		} catch (SQLException se) {
			// Execpción ante problemas de conexión
			se.printStackTrace();
		} finally {
			// Esta sentencia es para que ante un problema con la base igual se cierren las
			// conexiones
			try {
				if (consulta != null)
					consulta.close();
			} catch (SQLException se2) {
			}
			try {
				if (conexion != null)
					conexion.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return listaPronosticos;
	}
	
	public static ArrayList<Persona> consultaPersonas(){
		ArrayList<Persona> listaPersonas = null;
		try {
			listaPersonas = new ArrayList<>();
			// Abrir la conexión
			// System.out.println("conectando a la base de datos...");
			conexion = DriverManager.getConnection(ConectorSQL.DB_URL, ConectorSQL.USER, ConectorSQL.PASS);
			// Ejecutar una consulta
			// System.out.println("Creando statement...");
			consulta = conexion.createStatement();
			String sql;
			sql = "SELECT * FROM apuestasdeportivas.personas";
			// En la variable resultado obtendremos las distintas filas que nos devolvió la
			// base
			ResultSet resultado = consulta.executeQuery(sql);
			// Obtener las distintas filas de la consulta
			while (resultado.next()) {
				// Pbtener el valor de cada columna
				int idPersona = resultado.getInt("idPersona");
				String nombre = resultado.getString("nombre");

				Persona persona = new Persona(idPersona, nombre);
				listaPersonas.add(persona);
			}
			// Esto se utiliza par cerrar la conexión con la base de datos
			resultado.close();
			consulta.close();
			conexion.close();
			// System.out.println("Fin de la ejecucción");
		} catch (SQLException se) {
			// Execpción ante problemas de conexión
			se.printStackTrace();
		} finally {
			// Esta sentencia es para que ante un problema con la base igual se cierren las
			// conexiones
			try {
				if (consulta != null)
					consulta.close();
			} catch (SQLException se2) {
			}
			try {
				if (conexion != null)
					conexion.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return listaPersonas;
	       
	}
	public static int consultaPuntosXAcierto() {
		int puntos = 1;// nunca el punto por acierto debe ser 0.
		try {
			// Abrir la conexión
			conexion = DriverManager.getConnection(ConectorSQL.DB_URL, ConectorSQL.USER, ConectorSQL.PASS);
			// Ejecutar una consulta
			consulta = conexion.createStatement();
			String sql;
			sql = "SELECT puntosPorAcierto FROM apuestasdeportivas.parametros";
			ResultSet resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				puntos = resultado.getInt("puntosPorAcierto");
			}
			resultado.close();
			consulta.close();
			conexion.close();
		} catch (SQLException se) {
			// Execpción ante problemas de conexión
			se.printStackTrace();
		} finally {
			try {
				if (consulta != null)
					consulta.close();
			} catch (SQLException se2) {
			}
			try {
				if (conexion != null)
					conexion.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return puntos;
	}

	public static int consultaPuntosExtra() {
		int puntos=0; 
		try {
			// Abrir la conexión
			conexion = DriverManager.getConnection(ConectorSQL.DB_URL, ConectorSQL.USER, ConectorSQL.PASS);
			// Ejecutar una consulta
			consulta = conexion.createStatement();
			String sql;
			sql = "SELECT puntosExtra FROM apuestasdeportivas.parametros";
			ResultSet resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				puntos = resultado.getInt("puntosExtra");
			}
			resultado.close();
			consulta.close();
			conexion.close();
		} catch (SQLException se) {
			// Execpción ante problemas de conexión
			se.printStackTrace();
		} finally {
			try {
				if (consulta != null)
					consulta.close();
			} catch (SQLException se2) {
			}
			try {
				if (conexion != null)
					conexion.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return puntos;
	}
}

