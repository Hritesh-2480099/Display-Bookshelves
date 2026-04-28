package tests;

import java.util.List;
import org.example.pages.BookShelvesPage;
import org.example.utils.DriverManager;
import org.example.utils.ReqUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookShelvesTest {

    BookShelvesPage bookPage;
    ReqUtils utils;

    @BeforeMethod
    public void init() {
        bookPage = new BookShelvesPage(DriverManager.getDriver());
        utils = new ReqUtils(DriverManager.getDriver());
    }


    @Test(priority = 1)
    public void openBookPage(){
        bookPage.searchBookshelves();
    }

    @Test(priority = 2)
    public void clickFilter(){
        String actualTitle = bookPage.openFilters();
        String expectedTitle = "Filter and Sort";
        try{
            Assert.assertEquals(actualTitle,expectedTitle,"Filter and Sort Button not Working");
        }catch (AssertionError e){
            utils.screenShot("fFilterContainer");
            throw e;
        }
    }

    @Test(priority = 3)
    public void clickStorageType(){
        bookPage.applyFilter("15000");
    }


    @Test(priority = 4)
    public  void printTopThreeProducts(){
        List<WebElement> products = bookPage.getProducts();
        System.out.println("\nFirst 3 Bookshelves below Rs. 15000:\n");
        int count = 0;
        for (WebElement product : products) {
            String name = bookPage.getProductName(product);
            int price = bookPage.getProductPrice(product);

            if (price <= 15000) {
                System.out.println(++count + ". " + name + " - Rs. " + price);
            }
            if (count == 3)
                break;
        }
    }

    @Test(priority = 5)
    public void takeScreenShot(){
        List<WebElement> products = bookPage.getProducts();
        ReqUtils utils = new ReqUtils(DriverManager.getDriver());
        utils.scrollIntoView(products.get(0));
        utils.screenShot("Top_Three_BookShelves");
    }

    @Test(priority = 6)
    public void navigateToHomePage(){
        String actualTitle = bookPage.navigateToHomePage();
        String expectedTitle = "Buy Furniture Online: Upto 70% off in this Festive Season";
        try{
            Assert.assertEquals(actualTitle,expectedTitle,"Navigation to Homepage failed");
        }catch (AssertionError e){
            utils.screenShot("fFilterContainer");
            throw e;
        }

    }

}