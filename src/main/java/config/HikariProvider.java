package config;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariConfig;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class HikariProvider implements DataBaseManagerConnector {

   private final HikariDataSource dataSource;

    public HikariProvider(String hostname, int port, String database, String username, String password, String jdbcDriver) {
        HikariConfig config = new HikariConfig();
        try{
            Class.forName(jdbcDriver);
        }catch (ClassNotFoundException ex){
            throw new RuntimeException("Error loading DB driver");
        }
        config.setJdbcUrl(String.format("jdbc:postgresql://%s:%d/%s", hostname, port, database));
        config.setUsername(username);
        config.setPassword(password);
        config.setMaximumPoolSize(5);
        config.setIdleTimeout(100);
        this.dataSource = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
