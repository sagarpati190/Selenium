package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/features/"}, glue = {"stepDefinations"},
        plugin = {})

public class TestRunner extends AbstractTestNGCucumberTests {

}