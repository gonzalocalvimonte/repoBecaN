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
	private int numeroDeRonda;
	private int idPersona;
    private int partidoNumero;//Funciona como el id de partido
    private Equipo equipo;
    private ResultadoEnum resultado;
   
    
    public Pronostico(int numeroRonda,int partidoNum,int idPersona, Equipo equipo, ResultadoEnum resultado) {
    	this.numeroDeRonda= numeroRonda;
    	this.partidoNumero= partidoNum;
    	this.idPersona=idPersona;
    	this.equipo=equipo;
    	this.resultado=resultado;
    }
    
	public int getNumeroDeRonda() {
		return numeroDeRonda;
	}

	public void setNumeroDeRonda(int numeroDeRonda) {
		this.numeroDeRonda = numeroDeRonda;
	}

	public int getPartidoNumero() {
		return partidoNumero;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public ResultadoEnum getResultado() {
		return resultado;
	}
	public int getIdPersona() {
		return this.idPersona;
	}
	@Override
	public String toString() {
		return "[numeroDeRonda=" + numeroDeRonda  +", partidoNumero=" + partidoNumero + ", equipo=" + equipo + ", resultado=" + resultado + "]";
	}


}
