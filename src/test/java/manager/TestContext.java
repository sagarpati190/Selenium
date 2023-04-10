package manager;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import utility.ObjectRepository;

public class TestContext {
    private WebDriver driver;
    private ObjectRepository objectRepository;

    public TestContext() throws IOException {
        setDriver();
        objectRepository = new ObjectRepository(driver);
    }

    public WebDriver getDriver(){
        if(this.driver ==null)
            setDriver();
        return driver;
    }
    public void setDriver(){
        String browserType = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        if(browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browserType.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public ObjectRepository getObjectRepository() {
        return objectRepository;
    }
}
