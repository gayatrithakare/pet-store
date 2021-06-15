package petstore.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//https://mkyong.com/java/java-properties-file-examples/
//
public class TestProperties {
    private static TestProperties INSTANCE;
    private Properties properties;

    private TestProperties() {
        try (InputStream input = TestProperties.class.getClassLoader().getResourceAsStream("test.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Not able to load properties", ex);
        }
    }

    public static TestProperties getProperties() {
        if (INSTANCE == null) {
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }
}
