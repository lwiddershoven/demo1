package nl.leonw.demo1.bootjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;

@SpringBootApplication
public class BootJdbcApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(BootJdbcApplication.class, args);

		// Do something just to prove it does something
		var jdbc = ctx.getBean(JdbcTemplate.class);
		jdbc.query("select feature_name from information_schema.sql_features where is_supported = 'YES'",
				(ResultSet rs) -> System.out.println(rs.getString("feature_name")));

		System.out.println("------The End--------" );

	}

}
