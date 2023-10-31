package proyectoIntMaven;

import com.opencsv.bean.CsvBindByPosition;


public class archivoPartidos {

	    @CsvBindByPosition(position = 0)
	    private String equipoLocal;
	    @CsvBindByPosition(position = 1)
	    private int golesEquipoLocal;
	    @CsvBindByPosition(position = 2)
	    private int golesEquipoVisitante;
	    @CsvBindByPosition(position = 3)
	    private String equipoVisitante;
		public String getEquipoLocal() {
			return equipoLocal;
		}
		public void setEquipoLocal(String equipoLocal) {
			this.equipoLocal = equipoLocal;
		}
		public int getGolesEquipoLocal() {
			return golesEquipoLocal;
		}
		public void setGolesEquipoLocal(int golesEquipoLocal) {
			this.golesEquipoLocal = golesEquipoLocal;
		}
		public int getGolesEquipoVisitante() {
			return golesEquipoVisitante;
		}
		public void setGolesEquipoVisitante(int golesEquipoVisitante) {
			this.golesEquipoVisitante = golesEquipoVisitante;
		}
		public String getEquipoVisitante() {
			return equipoVisitante;
		}
		public void setEquipoVisitante(String equipoVisitante) {
			this.equipoVisitante = equipoVisitante;
		}
	   
		
	    
}


