package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseSetup {
    protected WebDriver driver;
    String baseURL = "https://www.urbanladder.com/";
    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeDriver(){
        if(driver != null){
            driver.quit();
        }
    }
}
