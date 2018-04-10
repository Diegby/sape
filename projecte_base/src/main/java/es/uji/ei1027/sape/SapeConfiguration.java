package es.uji.ei1027.sape;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import es.uji.ei1027.sape.dao.PreferenciaDao;
import es.uji.ei1027.sape.daoInterface.PreferenciaJdbc;

@Configuration
public class SapeConfiguration {
	
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public javax.sql.DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean
    @Primary
    public PreferenciaJdbc getDao(){
    	return new PreferenciaDao();
    }

}
