package br.demoblaze.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlazeSignUpPage{

    private final WebDriver driver;

    private final By signUpButton = By.id("signin2");

    private final By usernameForm = By.id("sign-username");

    private final By passwordForm = By.id("sign-password");

    private final By signUpFormButton = By.xpath("//*[@id='signInModal']//button[contains(normalize-space(), 'Sign up')]");

    // Sign up successful.
    //This user already exist.
    public DemoBlazeSignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSignUpButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
    }

    public void fillOutFormWithCredentials(String email, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameForm)).sendKeys(email);
        driver.findElement(passwordForm).sendKeys(password);
    }

    public void clickOnSignUpButtonForm(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        wait.until(ExpectedConditions.elementToBeClickable(signUpFormButton)).click();
    }

    public String alertMessageandAccept(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String message = alert.getText().trim();
        alert.accept();
        
        return message;
    }
}