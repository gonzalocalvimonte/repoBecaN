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
public class Pronostico {

	@CsvBindByPosition(position = 0)
    private int partidoNumero;
    @CsvBindByPosition(position = 1)
    private Equipo equipo;
    @CsvBindByPosition(position = 2)
    private ResultadoEnum resultado;
   
    
    public Pronostico(int partidoNum, Equipo equipo, ResultadoEnum resultado) {
    	this.partidoNumero= partidoNum;
    	this.equipo=equipo;
    	this.resultado=resultado;
    }
    
	public int getPartidoNumero() {
		return partidoNumero;
	}


	public Equipo getEquipo() {
		return equipo;
	}

	public ResultadoEnum getResultado() {
		return resultado;
	}

	public int puntos() {
		int numeroDePartido = Partido.getPartidoId();
        int punto = 0;
        if( getPartidoNumero() == numeroDePartido) {
        if (resultado == Partido.resultado(equipo)) {
            punto += 1;
        }}
        return punto;
    }

}
