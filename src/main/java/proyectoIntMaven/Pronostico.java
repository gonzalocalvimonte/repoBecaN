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
    private Partido partido;
    @CsvBindByPosition(position = 1)
    private Equipo equipo;
    @CsvBindByPosition(position = 2)
    private ResultadoEnum resultado;
   
    
    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
    	this.partido= partido;
    	this.equipo=equipo;
    	this.resultado=resultado;
    }
    public Partido getPartido() {
		return partido;
	}
	public Equipo getEquipo() {
		return equipo;
	}

	public ResultadoEnum getResultado() {
		return resultado;
	}

	public int puntos() {
        int punto = 0;
        if (resultado == partido.resultado(equipo)) {
            punto += 1;
        }
        return punto;
    }

}
