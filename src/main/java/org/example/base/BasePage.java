package org.example.base;

import org.example.utils.ReqUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected ReqUtils utils;
    public  BasePage(WebDriver driver){
        this.driver = driver;
        this.utils = new ReqUtils(driver);
        PageFactory.initElements(driver,this);
    }
}
