package nl.leonw;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean
    public DataSource pgDataSource() {
        System.out.println("Constructing DataSource");
        PGSimpleDataSource source = new PGSimpleDataSource();
        source.setServerNames(new String[]{"localhost"});
        source.setDatabaseName("postgres");
        source.setUser("postgres");
        source.setPassword("v3ry_s3cr3t");
        return source;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        System.out.println("Constructing JDBCTemplate");
        return new JdbcTemplate(dataSource);
    }

    // Remarks
    // 1. Lots of config for the datasource mixed with code
    //    That really is not very practical or organised
    // 2. Dependency injection - jdbc template wants ('depends on') datasource and spring
    //    looks which datasource beans exist. If 1 @Bean floats around it will be injected.

}
