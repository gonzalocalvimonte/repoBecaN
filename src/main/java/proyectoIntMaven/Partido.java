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

	@CsvBindByPosition(position = 0)
    private Equipo equipo1;
    @CsvBindByPosition(position = 1)
    private int golesEquipo1;
    @CsvBindByPosition(position = 2)
    private int golesEquipo2;
    @CsvBindByPosition(position = 3)
    private Equipo equipo2;
    
   
    private String ganador;
    private String perdedor;

    public Partido() {
    }

    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }
    public Equipo getEquipo1() {
    	return this.equipo1;
    }
    public Equipo getEquipo2() {
    	return this.equipo2;
    }
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

}
