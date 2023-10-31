package proyectoIntMaven;

import com.opencsv.bean.CsvBindByPosition;


public class archivoPronosticos {
	

	    @CsvBindByPosition(position = 0)
	    private String equipoLocal;
	    @CsvBindByPosition(position = 1)
	    private String ganaEquipoLocal;
	    @CsvBindByPosition(position = 2)
	    private String empate;
	    @CsvBindByPosition(position = 3)
	    private String ganaEquipoVisitante;
	    @CsvBindByPosition(position = 4)
	    private String equipoVisitante;
		public String getEquipoLocal() {
			return equipoLocal;
		}
		public void setEquipoLocal(String equipoLocal) {
			this.equipoLocal = equipoLocal;
		}
		public String getGanaEquipoLocal() {
			return ganaEquipoLocal;
		}
		public void setGanaEquipoLocal(String ganaEquipoLocal) {
			this.ganaEquipoLocal = ganaEquipoLocal;
		}
		public String getEmpate() {
			return empate;
		}
		public void setEmpate(String empate) {
			this.empate = empate;
		}
		public String getGanaEquipoVisitante() {
			return ganaEquipoVisitante;
		}
		public void setGanaEquipoVisitante(String ganaEquipoVisitante) {
			this.ganaEquipoVisitante = ganaEquipoVisitante;
		}
		public String getEquipoVisitante() {
			return equipoVisitante;
		}
		public void setEquipoVisitante(String equipoVisitante) {
			this.equipoVisitante = equipoVisitante;
		}
	    
}

