package br.demoblaze.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    
    private final By footerAboutUs =  By.xpath("//*[@id='fotcont']//h4[contains(., 'About Us')]");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void acessHomePage(){
        driver.get("https://www.demoblaze.com/index.html");
    }

    public String getFooter(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(footerAboutUs));

        return driver.findElement(footerAboutUs).getText();
    }
}
