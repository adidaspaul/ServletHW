package config;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    Properties properties = null;

    public PropertiesUtil(ServletContext conx) {
        load(conx);
    }

    public String getHostname() {
        return properties.getProperty("database.hostname");
    }

    public Integer getPort() {

        return Integer.parseInt(properties.getProperty("database.port"));
    }

    public String getSchema() {

        return properties.getProperty("database.schema");
    }

    public String getUser() {

        return properties.getProperty("database.user");
    }

    public String getPassword() {

        return properties.getProperty("database.password");
    }

    public String getJdbcDriver(){
        return properties.getProperty("jdbc.driver");
    }

    public void load(ServletContext conx) {
        this.properties = new Properties();
        try (InputStream is = conx.getResourceAsStream("/WEB-INF/application.properties")) {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
