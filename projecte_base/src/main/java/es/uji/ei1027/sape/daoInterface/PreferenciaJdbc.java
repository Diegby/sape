package es.uji.ei1027.sape.daoInterface;

import java.sql.Date;
import java.util.List;

import es.uji.ei1027.sape.model.Preferencia;

public interface PreferenciaJdbc {
	
	public List<Preferencia> getPreferences(Date fecha, String nombreEstudiante);
	public List<Preferencia> getAllPreferences(String nombreEstudiante);

}
