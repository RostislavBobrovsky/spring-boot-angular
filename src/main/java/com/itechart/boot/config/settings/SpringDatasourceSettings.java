package com.itechart.boot.config.settings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="spring.datasource")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpringDatasourceSettings {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
