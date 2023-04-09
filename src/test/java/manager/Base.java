package manager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.Reporter;


public class Base {

    private WebDriver driver;

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
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }else if(browserType.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }


    }

    @Before
    public void setup(){
        setDriver();
    }


}
