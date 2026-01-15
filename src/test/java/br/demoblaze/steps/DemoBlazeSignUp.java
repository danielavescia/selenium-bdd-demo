package br.demoblaze.steps;

import static br.demoblaze.steps.BaseSteps.driver;

import org.junit.Assert;

import br.demoblaze.pages.DemoBlazeSignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoBlazeSignUp {

    DemoBlazeSignUpPage signUpPage;

    @Given("I'm on the DemoBlaze home page")
    public void ImOnDemoBlazeHomePage() {
        driver.get("https://www.demoblaze.com/index.html");
        signUpPage = new DemoBlazeSignUpPage(driver);
    }

    @When("I click on Sign up button")
    public void iClickOnSignUpButton() {
        signUpPage.clickOnSignUpButton();
    }

    @And("I fill out the form with {string}, {string}")
    public void iFillOutFormWith(String email, String password) {
        signUpPage.fillOutFormWithCredentials(email, password);
    }

    @And("I click on the Sign up button")
    public void iClickOnSignUpButtonForm() {
        signUpPage.clickOnSignUpButtonForm();
    }

    @Then("I see the registration message {string}")
    public void iSeeSucessfulRegistrationMessage(String expectedMessage) {
        String alertMessage = signUpPage.alertMessageandAccept();
        String alertMessageExpected = "Sign up successful.";
        Assert.assertTrue("The message doesn't match with expected message", alertMessage.matches(alertMessageExpected));
    }
}