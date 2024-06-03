package com.losolved.booking.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(value = {DataSourceProperties.class})
public class DatabaseConfig {

    private final DataSourceProperties dataSourceProperties;
    
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);


    @Autowired
    public DatabaseConfig(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        logger.info(dataSourceProperties.getUrl());
        logger.info(dataSourceProperties.getUsername());
        logger.info(dataSourceProperties.getPassword());
        logger.info(dataSourceProperties.getDriverClassName());
        
        
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        return dataSource;
    }
    
    //TODO: See how to keep alive and run project (tail -f /dev/null && java -jar)
    //TODO: see why s not running n debug 
    //TODO: 
}
