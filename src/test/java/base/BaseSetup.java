package base;

import org.example.utils.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseSetup {

    String baseURL = "https://www.urbanladder.com/";

    @BeforeTest
    public void setUp() {
        DriverManager.getDriver().get(baseURL);
        System.out.println("Browser Opened");
    }

    @AfterTest
    public void tearDown() {
        DriverManager.quitDriver();
        System.out.println("Browser Closed");
    }
}