package tests;

import java.util.List;

import base.BaseSetup;
import org.example.pages.BookShelvesPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookShelvesTest extends BaseSetup {

    BookShelvesPage bookPage;
    @BeforeMethod
    public void init(){
        bookPage = new BookShelvesPage(driver);
    }

    @Test(priority = 1)
    public void openBookPage(){
        bookPage.searchBookshelves();
    }

    @Test(priority = 2)
    public void clickFilter(){
        bookPage.openFilters();
    }

    @Test(priority = 3)
    public void clickStorageType(){
        bookPage.applyStorageTypeFilter();
    }

    @Test(priority = 4)
    public void clickStorageAvailability(){
        bookPage.applyAvailabilityFilter();
    }

    @Test(priority = 5)
    public void clickPriceFilter(){
        bookPage.applyPriceFilter("15000");
    }

    @Test(priority = 6)
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

    @Test(priority = 7)
    public void navigateToHomePage(){
        bookPage.navigateToHomePage();
    }

}