package com.itechart.boot.config.settings;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "spring.datasource")
@Getter
@Setter
@NoArgsConstructor
public class SpringDatasourceSettings {
    @NotEmpty
    private String url;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String driverClassName;
    @NotNull
    private Integer maximumPoolSize;
}