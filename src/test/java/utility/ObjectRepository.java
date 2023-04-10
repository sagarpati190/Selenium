package utility;

import com.jayway.jsonpath.JsonPath;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.*;

public class ObjectRepository {
    JSONObject jsonObjects;
    WebDriver driver;

    public JSONObject getObjectRepository() throws Exception {
        return jsonObjects;
    }

    public ObjectRepository(WebDriver driver) throws IOException {

        jsonObjects = new JSONObject();
        File[] files = new File("src/test/resources/locators/desktop/local/").
                listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));
        for(File file : files) {
            InputStream is = new FileInputStream(file);
            String jsonTxt = IOUtils.toString(is, "UTF-8");
            JSONObject jsonObject = new JSONObject(jsonTxt);
            String key = jsonObject.keys().next().toString();
            jsonObjects.put(key, jsonObject.get(key));
        }
        this.driver =driver;
    }

    public WebElement getElement(String jsonPath) {
        return driver.findElement(getLocator(jsonPath));
    }

    public WebElement getDynamicElement(String jsonPath,String dynamicValue) {
        return driver.findElement(getDynamicLocator(jsonPath,dynamicValue));
    }


    private By getDynamicLocator(String jsonPath, String dynamicValue) {
        String value = String.format(JsonPath.read(jsonObjects.toString(),jsonPath+".value").toString(),dynamicValue);

        switch (JsonPath.read(jsonObjects.toString(),jsonPath+".by").toString()){
            case "xpath": return By.xpath(value);
            case "id": return By.id(value);
            case "css": return By.cssSelector(value);
        }
        return null;
    }

    private By getLocator(String jsonPath) {

        switch (JsonPath.read(jsonObjects.toString(),jsonPath+".by").toString()){
            case "xpath": return By.xpath(JsonPath.read(jsonObjects.toString(),jsonPath+".value").toString());
            case "id": return By.id(JsonPath.read(jsonObjects.toString(),jsonPath+".value").toString());
            case "css": return By.cssSelector(JsonPath.read(jsonObjects.toString(),jsonPath+".value").toString());
       }
        return null;
    }


}
