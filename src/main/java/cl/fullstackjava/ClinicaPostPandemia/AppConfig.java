package cl.fullstackjava.ClinicaPostPandemia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("cl.fullstackjava")
@PropertySource("classpath:database.properties")
public class AppConfig {

    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Autowired
    Environment environment;

    @Bean
    DataSource ds() {
        String driver = environment.getProperty("driver");
        String url = environment.getProperty("url");
        String username = environment.getProperty("user_db");
        String password = environment.getProperty("password");

        logger.info("Driver: {}", driver);
        logger.info("URL: {}", url);
        logger.info("Username: {}", username);
        logger.info("Password: {}", password);

        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName(driver);
        source.setUrl(url);
        source.setUsername(username);
        source.setPassword(password);

        return source;
    }
}
