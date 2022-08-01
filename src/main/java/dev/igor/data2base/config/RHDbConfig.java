package dev.igor.data2base.config;

import dev.igor.data2base.repository.rh.RhRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackageClasses = RhRepository.class,
        entityManagerFactoryRef = "rhEntityManager"
)
public class RHDbConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "pg.datasource")
    public DataSource rhDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean rhEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("rhDataSource") DataSource dataSource
    ) {
        return builder.dataSource(dataSource)
                .packages("dev.igor.data2base.model.rh")
                .build();
    }
}
