package es.uji.ei1027.sape.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.sape.daoInterface.PreferenciaJdbc;
import es.uji.ei1027.sape.model.Preferencia;

@Repository
public class PreferenciaDao implements PreferenciaJdbc{
	
	private JdbcTemplate jdbcTemplate;
    
	@Autowired
	public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	
	private static final class PreferenciaMapper implements RowMapper<Preferencia> { 
	    public Preferencia mapRow(ResultSet rs, int rowNum) throws SQLException { 
	    	Preferencia pref = new Preferencia();
	    	pref.setFecha(rs.getDate("fechaCambio"));
	    	pref.setOrden(rs.getInt("orden"));
	    	pref.setEstudiante(rs.getString("estudiante"));
	    	pref.setIdProyecto(rs.getInt("proyecto"));
	        return pref;
	    }
	}

	@Override
	public List<Preferencia> getPreferences(Date fecha, String nombreEstudiante) {
		return this.jdbcTemplate.query(
				"SELECT orden, fechaCambio, proyecto, estudiante FROM preferencia WHERE estudiante = ? AND fechaCambio > ?;", 
		     	new Object[] {nombreEstudiante, fecha},new PreferenciaMapper());
	}

	@Override
	public List<Preferencia> getAllPreferences(String nombreEstudiante) {
		return this.jdbcTemplate.query(
				"SELECT orden, fechaCambio, proyecto, estudiante FROM preferencia WHERE estudiante = ?;", 
		     	new Object[] {nombreEstudiante},new PreferenciaMapper());
	}

}
