package tests;

import java.util.List;
import org.example.pages.BookShelvesPage;
import org.example.utils.DriverManager;
import org.openqa.selenium.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookShelvesTest {

    BookShelvesPage bookPage;

    @BeforeMethod
    public void init() {
        bookPage = new BookShelvesPage(DriverManager.getDriver());
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
        }]
    }

    @Test(priority = 5)
    public void navigateToHomePage(){
        bookPage.navigateToHomePage();
    }

}