package nl.leonw;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;

public class App {
   public static void main(String[] args) {
      var ctx = new AnnotationConfigApplicationContext(Config.class);

      // Do something just to prove it does something
      var jdbc = ctx.getBean(JdbcTemplate.class);
      jdbc.query("select feature_name from information_schema.sql_features where is_supported = 'YES'",
              (ResultSet rs) -> System.out.println(rs.getString("feature_name")));

      System.out.println("------The End--------" );
   }
}
