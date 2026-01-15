package br.demoblaze.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSteps {
    
    protected static WebDriver driver;

    public static void openBrowser(){
        WebDriverManager.chromedriver().setup();
    
        ChromeOptions options = new ChromeOptions();

        boolean isPipelineCI = System.getenv("CI") != null;

        if(isPipelineCI){
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    public static void closeBrowser(){
        if(driver != null){
            driver.quit();
            driver=null;
        }
    }
}
