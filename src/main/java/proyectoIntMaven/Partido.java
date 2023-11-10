/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoIntMaven;

import com.opencsv.bean.CsvBindByPosition;

/**
 *
 * @author FraNko
 */
public class Partido {
	//ATRIBUTOS

	//private int partidoId;
	private static int cantPartidos = 0; // llevamos la cuenta de todos los partidos que creamos.
	private int partidoId ; // asignamos el id al partido  a medida que creamos partidos.
	private int numeroDeRonda;
    private Equipo equipo1;   
    private int golesEquipo1;  
    private int golesEquipo2;
    private Equipo equipo2;
    private String ganador;
    private String perdedor;
    //CONSTRUCTORES
    public Partido() {
    }

    public Partido(int pID,int numeroDeRonda,Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        cantPartidos += 1; // cada vez que creamos un partido incrementamos la cantidad en 1.
    	this.partidoId = pID;
        this.numeroDeRonda=numeroDeRonda;
    	this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }
    //GETTERS
    public Equipo getEquipo1() {
    	return this.equipo1;
    }
    public Equipo getEquipo2() {
    	return this.equipo2;
    }
	public  int getPartidoId() {
		return this.partidoId;
	}
	public static int getCantPartidos() {
		return cantPartidos;//Devuelve la cantidad de partidos que hay creados.
	}
	public int getNumRonda() {
		return this.numeroDeRonda;
	}
	//OTROS METODOS
    public ResultadoEnum resultado(Equipo equipo1) {
        ganador();
        if (equipo1.getNombre().equals(this.ganador)) {
            return ResultadoEnum.GANADOR;
        } else if (equipo1.getNombre().equals(this.perdedor)) {
            return ResultadoEnum.PERDEDOR;
        }
        return ResultadoEnum.EMPATE;
    }

    private void ganador() {
        if (golesEquipo1 > golesEquipo2) {
            this.ganador = equipo1.getNombre();
            this.perdedor = equipo2.getNombre();
        } else if (golesEquipo1 < golesEquipo2) {
            this.ganador = equipo2.getNombre();
            this.perdedor = equipo1.getNombre();
        }
    }



	@Override
	public String toString() {
		return "[partidoId=" + partidoId + ", equipo1=" + equipo1 + ", golesEquipo1=" + golesEquipo1
				+ ", golesEquipo2=" + golesEquipo2 + ", equipo2=" + equipo2 + "]";
	}


}
