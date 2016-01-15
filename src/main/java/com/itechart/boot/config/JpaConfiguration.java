package com.itechart.boot.config;

import com.itechart.boot.Application;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = Application.class)
@EntityScan(basePackages = "com.itechart.boot.domain")
public class JpaConfiguration implements EnvironmentAware {

    private final Logger LOGGER = LoggerFactory.getLogger(JpaConfiguration.class);

    @Value("${dataSource.driverClassName}")
    private String driver;
    @Value("${dataSource.url}")
    private String url;
    @Value("${dataSource.username}")
    private String username;
    @Value("${dataSource.password}")
    private String password;
    @Value("${hibernate.dialect}")
    private String dialect;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;

    private RelaxedPropertyResolver propertyResolver;
    private Environment env;

    @Override
    public void setEnvironment(Environment env) {
        this.env = env;
        this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
    }

//    @Autowired
//    private SpringDatasourceSettings springDatasourceSettings;

    @Bean
    public DataSource configureDataSource() {
        LOGGER.debug("Configuring Datasource");

//        if (propertyResolver.getProperty("url") == null
//                && propertyResolver.getProperty("databaseName") == null) {
//            LOGGER.error(
//                    "Your database connection pool configuration is incorrect! The application cannot start. " +
//                            "Please check your Spring profile, current profiles are: {}",
//                    Arrays.toString(env.getActiveProfiles()));
//
//            throw new ApplicationContextException(
//                    "Database connection pool is not configured correctly");
//        }

//        HikariConfig config = new HikariConfig();
//        config.setDriverClassName(springDatasourceSettings.getDriverClassName());
//        config.setJdbcUrl(springDatasourceSettings.getUrl());
//        config.setUsername(springDatasourceSettings.getUsername());
//        config.setPassword(springDatasourceSettings.getPassword());

        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

        return new HikariDataSource(config);
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}