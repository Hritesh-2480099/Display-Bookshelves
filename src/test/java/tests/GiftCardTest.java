package tests;

import org.example.pages.GiftcardsPage;
import org.example.utils.DriverManager;
import org.example.utils.ReqUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GiftCardTest {
    GiftcardsPage giftPage;
    @BeforeMethod
    public void init(){
        giftPage=new GiftcardsPage(DriverManager.getDriver());
    }
    @Test(priority = 1)
    public void validateTitle(){
        giftPage.giftCardPage();
        String actualResult=DriverManager.getDriver().getTitle();
        String expectedResult="Gift Cards";
        try{
            Assert.assertEquals(actualResult,expectedResult,"Invalid Gift Card Page");

        }catch (AssertionError e){
            throw e;
        }
    }
    @Test(priority = 2)
    public void ValidateEmail(){
        ReqUtils utils=new ReqUtils(DriverManager.getDriver());
        String actualResult=GiftcardsPage.validateEmail();
        String expectedResult="Valid Email ID";
        try{
            Assert.assertEquals(actualResult,expectedResult,"Email ID validation failed");

        }catch (AssertionError e){
            utils.screenShot("errorMsgFromEmailID");
            throw e;
        }
    }

    @Test(priority = 2)
    public void ValidateMobileNumber(){
        ReqUtils utils=new ReqUtils(DriverManager.getDriver());
        String actualResult=GiftcardsPage.validateMobile();
        String expectedResult="Valid Mobile Number";
        try{
            Assert.assertEquals(actualResult,expectedResult,"Mobile number validation failed");

        }catch (AssertionError e){
            utils.screenShot("errorMsgFromMobileNumber");
            throw e;
        }
    }

}
