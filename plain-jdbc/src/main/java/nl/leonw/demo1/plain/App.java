package nl.leonw.demo1.plain;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        new App().listPostgresFeatures(); // I'd rather new than use static functions
    }

    void listPostgresFeatures() {
        var url = "jdbc:postgresql://localhost/postgres";
        var username = "postgres";
        var password = "v3ry_s3cr3t";

        try (var conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the PostgreSQL server successfully.");
            var ps = conn.prepareStatement("select feature_name from information_schema.sql_features where is_supported = 'YES'");
            var rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // A fair amount of boilerplate
    // And it adds up over all the API's you typically use

    // Also, no uniform way to configure properties in apps.
}
