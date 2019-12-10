package comm.example.dao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "comm.example")
public class JdbcConfig {
	@Bean
	 public DataSource dataSource() throws IOException {
		InputStream input = new FileInputStream("src/main/java/jdbc.properties");

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
           String url =prop.getProperty("jdbc.url");
           String user = prop.getProperty("jdbc.user");
            String password =prop.getProperty("jdbc.password");
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            //MySQL database we are using
            
            dataSource.setUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(password);
            

      
		return dataSource;
       
    }
	@Bean
	 public JdbcTemplate jdbcTemplate() throws IOException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
 
	@Bean
	public CustomerDAOImpl customerDao() throws IOException {
		return new CustomerDAOImpl(jdbcTemplate());
		
	}

}
