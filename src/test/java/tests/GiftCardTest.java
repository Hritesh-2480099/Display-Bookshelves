package tests;

import base.BaseSetup;
import org.example.pages.GiftcardsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GiftCardTest extends BaseSetup {
    GiftcardsPage giftPage;
    @BeforeMethod
    public void init(){
        giftPage=new GiftcardsPage(driver);
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
        Assert.assertEquals(actualResult,expectedResult,"Email ID validation failed");
    }

    @Test(priority = 2)
    public void ValidateMobileNumber(){
        String actualResult=giftPage.validateMobile();
        String expectedResult="Valid Mobile Number";
        Assert.assertEquals(actualResult,expectedResult,"Mobile number validation failed");

    }

}
