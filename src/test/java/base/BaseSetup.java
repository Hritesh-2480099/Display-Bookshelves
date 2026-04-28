package base;

import org.example.utils.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseSetup {

    String baseURL = "https://www.urbanladder.com/";

    @BeforeTest
    public void setUp() {
        DriverManager.getDriver().get(baseURL);
    }

    @AfterTest
    public void tearDown() {
        DriverManager.quitDriver();
    }
}