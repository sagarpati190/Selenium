package stepDefinations;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.TestContext;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.ObjectRepository;

import java.io.IOException;

public class Elements {
    WebDriver driver;
    ObjectRepository objectRepository;
    public Elements(TestContext testContext) throws IOException {
        objectRepository = testContext.getObjectRepository();
        driver = testContext.getDriver();
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("User is on homepage")
    public void userIsOnHomepage() {

        driver.get("https://demoqa.com/");
        objectRepository.getElement("$.Homepage.HomeIcon").click();
    }

    @When("User selects {string} options")
    public void userSelectsOptions(String card) {
        WebElement element = objectRepository.getDynamicElement("$.Homepage.Cards",card);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    @Then("User should be able to see the elements page")
    public void userShouldBeAbleToSeeTheElementsPage() {
    }

    @Then("User navigates to TextBox page and fill all the details and submit the form")
    public void userNavigatesToTextBoxPageAndFillAllTheDetailsAndSubmitTheForm() {
    }

    @Then("User validate the submitted details")
    public void userValidateTheSubmittedDetails() {
    }
}
