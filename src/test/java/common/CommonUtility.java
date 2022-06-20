package common;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.Map;
import java.util.Properties;

public class CommonUtility {

    InputStream inputStream;

    public String getProperty(String propertyName) throws IOException {
        Properties prop = new Properties();
        Map<String, String> envList = System.getenv();
        String env = envList.get("env");
        String propFileName = env + "Config.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
        return prop.getProperty(propertyName);
    }

    public JSONObject getTemplate(String filename) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject data = (JSONObject) parser.parse(
                new FileReader("src/test/resources/Templates/" + filename));
        return data;
    }

}