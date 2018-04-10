package es.uji.ei1027.sape.model;

import java.sql.Date;

public class Preferencia {
	Date fecha;
	int orden;
	int idProyecto;
	
	public int getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}
	public String getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
	}
	String estudiante;
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}

}
