package br.demoblaze.steps;

import org.junit.Assert;

import br.demoblaze.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps extends BaseSteps {

    HomePage homePage;

    @Given("the user opens the browser")
    public void theUserOpenstheBrowser() {
        homePage = new HomePage(driver);
        System.out.println("Browser opened by Hooks");
    }

    @When("the user acess DemoBlaze's page")
    public void theUserAcessPage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        homePage.acessHomePage();
    }

    @Then("DemoBlaze's page is acess with sucess")
    public void thePageIsSucessfullAcess() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }

        String expectedFooterText = "About Us";
        String FooterText = homePage.getFooter();

        Assert.assertTrue("The expected text's footer wasn't found at home page",
                FooterText.contains(expectedFooterText));
    }
}