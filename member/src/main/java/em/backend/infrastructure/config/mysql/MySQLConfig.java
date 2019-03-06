package em.backend.infrastructure.config.mysql;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class MySQLConfig {

	@Bean(name = "mysqlDB")
	@Primary
	public DataSource dataSource() {
	    return DataSourceBuilder
	        .create()
	        .username("root")
	        .password("root")
	        .url("jdbc:mysql://localhost:3306/member_db")
	        .driverClassName("com.mysql.cj.jdbc.Driver")
	        .build();
	}	
	
	@Bean(name = "mysqlJdbcTemplate")
	public JdbcTemplate mySqlJdbcTemplate(@Qualifier("mysqlDB") DataSource mySqlDataSource) {
		return new JdbcTemplate(mySqlDataSource);
	}

}
