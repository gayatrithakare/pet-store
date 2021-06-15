package petstore.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;

public class JsonUtil {

    public static String convertToJsonString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            Assert.fail("Error while converting object to Json String");
        }
        return null;

    }
}
