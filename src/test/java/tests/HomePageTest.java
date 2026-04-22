package tests;

import base.BaseSetup;
import org.example.pages.HomePage;
import org.example.utils.ReqUtils;
import org.testng.annotations.Test;

public class HomePageTest extends BaseSetup {
    @Test
    public  void testLivingMenu(){
        HomePage home = new HomePage(driver);
//        home.checkPageLoad();
        home.waitFor();
        home.getLivingMenuItemsList();
    }
}
