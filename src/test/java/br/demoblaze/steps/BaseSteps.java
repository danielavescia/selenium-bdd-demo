package br.demoblaze.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseSteps {
    
    protected static WebDriver driver;

    public static void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void closeBrowser(){
        if(driver != null){
            driver.quit();
            driver=null;
        }
    }
}
