package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver){
        super(driver);

    }
    @FindBy(xpath = "//img[@alt='Bookshelves']/parent::div/parent::a")
    private WebElement bookShelves;

//    @FindBy(xpath = "//*[@class='ETrkE' and text()='Gift Cards']")
//    private WebElement collectionLists;

    @FindBy(xpath = "//*[@class='ETrkE' and text()='Gift Cards']")
    private WebElement giftCards;

    public void goToBookshelvesPage(){
        utils.click(bookShelves);
    }

//    public void getCollectionList(){
//        utils.click(collectionLists);
//    }

    public void goToGiftcardsPage(){
        utils.click(giftCards);
    }
}
