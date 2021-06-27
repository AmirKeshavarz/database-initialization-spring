package ir.keshavarzreza.databaseinitialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@SpringBootApplication
public class DatabaseInitializationApplication {

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseInitializationApplication.class, args);
	}

	@Bean
	@Primary
	public DataSource firstDataSource() {
		return DataSourceBuilder.create()
				.url(env.getProperty("spring.datasource.url"))
				.password(env.getProperty("spring.datasource.password"))
				.username(env.getProperty("spring.datasource.username"))
				.driverClassName(env.getProperty("spring.datasource.driverClassName"))
				.build();
	}

	@Bean
	public DataSource scondDataSource() {
		return DataSourceBuilder.create()
				.url(env.getProperty("spring.second-datasource.url"))
				.password(env.getProperty("spring.second-datasource.password"))
				.username(env.getProperty("spring.second-datasource.username"))
				.driverClassName(env.getProperty("spring.second-datasource.driverClassName"))
				.build();
	}

}
