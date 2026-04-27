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

    @Test
    public void openBookPage(){
        bookPage.searchBookshelves();
    }

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.urbanladder.com/");

        System.out.println("lanch");

        BookShelvesPage shelves = new BookShelvesPage(driver);


//        shelves.closePopupIfPresent();
        shelves.searchBookshelves();
        System.out.println("search");

        shelves.openFilters();
        System.out.println("filters");

        shelves.applyStorageTypeFilter();
        System.out.println("open");

        shelves.applyAvailabilityFilter();
        System.out.println("with storage");

        shelves.applyPriceFilter("15000");
        System.out.println("price");

        List<WebElement> products = shelves.getProducts();

        //System.out.println("Total products found: " + products.size());
        System.out.println("\nFirst 3 Bookshelves below Rs. 15000:\n");

        int count = 0;

        for (WebElement product : products) {

            String name = shelves.getProductName(product);
            int price = shelves.getProductPrice(product);

            if (price <= 15000) {
                System.out.println(++count + ". " + name + " - Rs. " + price);
            }

            if (count == 3)
                break;
        }

        driver.navigate().back();
    }
}