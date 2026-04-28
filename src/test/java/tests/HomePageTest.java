package tests;

import org.example.pages.HomePage;
import org.example.utils.DriverManager;
import org.example.utils.ReqUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {

    HomePage homePage;

    @BeforeMethod
    public void init() {
        homePage = new HomePage(DriverManager.getDriver());
    }

    @Test
    public void testLivingMenu() {
//        homePage.getLivingMenuItemsList();
        int actualOutput = homePage.getLivingMenuItemsList();
        try{
            Assert.assertEquals(actualOutput,5,"Fetching Living Menu Items Failed");
        }catch (AssertionError e){
            throw e;
        }
        finally {
            ReqUtils utils = new ReqUtils(DriverManager.getDriver());
            utils.screenShot("LivingMenu_List");
        }
    }
}