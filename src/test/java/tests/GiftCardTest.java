package tests;

import org.example.pages.GiftcardsPage;
import org.example.utils.DriverManager;
import org.example.utils.ReqUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GiftCardTest {
    GiftcardsPage giftPage;
    ReqUtils utils;
    @BeforeMethod
    public void init(){
        giftPage=new GiftcardsPage(DriverManager.getDriver());
        utils=new ReqUtils(DriverManager.getDriver());
    }
    @Test(priority = 1)
    public void validateTitle(){

        String actualResult= giftPage.giftCardPage();
        String expectedResult="Gift Cards";
        Assert.assertEquals(actualResult,expectedResult,"Invalid Gift Card Page");

    }
    @Test(priority = 2)
    public void ValidateEmail(){
        String actualResult=giftPage.validateEmail();
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
        String actualResult=giftPage.validateMobile();
        String expectedResult="Valid Mobile Number";
        try{
            Assert.assertEquals(actualResult,expectedResult,"Mobile number validation failed");

        }catch (AssertionError e){
            utils.screenShot("errorMsgFromMobileNumber");
            throw e;
        }
    }

}
