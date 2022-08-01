package dev.igor.data2base.config;

import dev.igor.data2base.repository.ti.TiRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackageClasses = TiRepository.class,
        entityManagerFactoryRef = "tiEntityManager"
)
public class TIDbConfig {

    @Bean
    @ConfigurationProperties(prefix = "mysql.datasource")
    public DataSource tiDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean tiEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("tiDataSource") DataSource dataSource
    ) {
        return builder.dataSource(dataSource)
                .packages("dev.igor.data2base.model.ti")
                .build();
    }
}
