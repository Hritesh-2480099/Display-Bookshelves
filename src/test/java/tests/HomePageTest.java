package tests;

import base.BaseSetup;
import org.example.pages.HomePage;
import org.example.utils.ReqUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseSetup {
    HomePage homepage;
    @BeforeMethod
    public void init(){
        homepage = new HomePage(driver);
    }
    @Test
    public  void testLivingMenu(){
        homepage.getLivingMenuItemsList();
    }
}
