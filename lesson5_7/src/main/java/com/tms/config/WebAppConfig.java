package com.tms.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import javax.sql.DataSource;

@Order(1)
@Configuration
@EnableWebMvc
@ComponentScan("com.tms.*")
@PropertySource("classpath:database.properties")
public class WebAppConfig implements WebMvcConfigurer {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(environment.getProperty("jdbc.url"));
        basicDataSource.setUsername(environment.getProperty("jdbc.username"));
        basicDataSource.setPassword(environment.getProperty("jdbc.password"));
        basicDataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
        return basicDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
