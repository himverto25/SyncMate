// Establishing profiles for both cloud and non-cloud deployment methods
/*
The system will automatically burst to cloud to make use of vertical
scaling so as to handle large number of requests made to the system.
*/

// Framework used: Spring-Boot so as to leverage ready made Spring Starters 

// placeholders must be filled with required data wherever applicable
package src.main.controller;
import src.main.*;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    // decorator and profile for local deployment
    @Profile("cloud")
    @Bean
    public DataSource cloudDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(dataSourceUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    // decorator for non-cloud or local deployment
    @Profile("!cloud") // Profile for local database
    @Bean
    public DataSource localDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/rideshare_db");
        dataSource.setUsername("your_username");
        dataSource.setPassword("your_password");
        return dataSource;
    }
}
