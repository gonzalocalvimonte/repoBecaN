package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class consultasDB {
	static Connection conexion = null;
    static java.sql.Statement consulta = null;
	
    
    public static void main(String[] args) {
		consultaPartidos();
	}
    
	public static void consultaPartidos() {
	

        try {

            // Abrir la conexión
            System.out.println("conectando a la base de datos...");

            conexion = DriverManager.getConnection(ConectorSQL.DB_URL, ConectorSQL.USER, ConectorSQL.PASS);

            // Ejecutar una consulta
            System.out.println("Creating statement...");
            consulta = conexion.createStatement();
            String sql;
            sql = "SELECT * FROM apuestasdeportivas.resultadospartidos";

            //En la variable resultado obtendremos las distintas filas que nos devolvió la base
            ResultSet resultado = consulta.executeQuery(sql);

            // Obtener las distintas filas de la consulta
            while (resultado.next()) {
                // Pbtener el valor de cada columna
            	int idPartido = resultado.getInt("idPartido");
            	String equipo1 = resultado.getString("equipo1");
            	String equipo2 = resultado.getString("equipo2");
               

                // Mostrar los valores obtenidos
                System.out.print("id" + idPartido);
                System.out.print(", equipo1: " + equipo1);
                System.out.print(", equipo2: " + equipo2);
            
            }
            // Esto se utiliza par cerrar la conexión con la base de datos
            resultado.close();
            consulta.close();
            conexion.close();
        } catch (SQLException se) {
            // Execpción ante problemas de conexión
            se.printStackTrace();
        } finally {
            // Esta sentencia es para que ante un problema con la base igual se cierren las conexiones
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
        System.out.println("Fin de la ejecucción");
    }
	}

