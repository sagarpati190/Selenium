package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.Base;
import org.openqa.selenium.WebDriver;

public class Elements {
    WebDriver driver;

    public Elements(Base base)
    {
        driver = base.getDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("User is on homepage")
    public void userIsOnHomepage() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
    }

    @When("User selects {string} options")
    public void userSelectsOptions(String arg0) {
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
