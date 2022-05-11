package ro.ubbcluj.rabbit.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ro.ubbcluj.rabbit.core.config.JpaConfig;

@ComponentScan({"ro.ubbcluj.rabbit.core"})
@Configuration
@Import(JpaConfig.class)
public class AppLocalConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
