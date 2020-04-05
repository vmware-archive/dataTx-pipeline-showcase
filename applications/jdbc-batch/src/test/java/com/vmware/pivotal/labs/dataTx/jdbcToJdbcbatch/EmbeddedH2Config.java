package com.vmware.pivotal.labs.dataTx.jdbcToJdbcbatch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * @author Gregory Green
 */
@Configuration
@Profile(("test"))
public class EmbeddedH2Config
{

    @Value("${spring.datasource.url}")
    String url ;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DataSource getDataSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.username(user);
        dataSourceBuilder.password(password);
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url(url);
        return dataSourceBuilder.build();
    }
}
