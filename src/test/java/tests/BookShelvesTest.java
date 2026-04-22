package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookShelvesTest {

    public static void main(String[] args) {

        // Step 1: Launch browser
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().window().maximize();
        driver.get("https://www.urbanladder.com/");
        System.out.println("Launch Browser");

        // Close login popup (if present)
        try {
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@class,'close-reveal-modal')]"))).click();
        } catch (Exception e) {
            // popup not displayed
        }

        // Search for "Bookshelves"
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("searchInput")));
        searchBox.clear();
        searchBox.sendKeys("Bookshelves");
        searchBox.sendKeys(Keys.ENTER);
        System.out.println("Entered");

        // click filter
        WebElement filtersButton =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("productsContainer")));
        filtersButton.click();

        System.out.println("CLicked");

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", filtersButton);

        System.out.println("Filters panel opened");

        // Step 6: Apply Storage Type = Open
        Actions actions = new Actions(driver);
        WebElement storageType = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("[aria-label='Storage Type']")
                )
        );
        actions.moveToElement(storageType).click().perform();

        WebElement openStorageCheckbox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@role='checkbox' and .//text()[contains(.,'Open Storage')]]")
                )
        );
        actions.moveToElement(openStorageCheckbox).click().perform();
        System.out.println("Storage Type");

        // Exclude out of stock
        WebElement outOfStock = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("[aria-label='Storage Availability']")
                        )
        );
        actions.moveToElement(outOfStock).click().perform();

        WebElement withStorage = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@role='checkbox' and .//text()[contains(.,'With Storage')]]")
                )
        );
        actions.moveToElement(withStorage).click().perform();
        System.out.println("Exclude stock");

        // Price
        WebElement price = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("[aria-label='Price']")
                )
        );
        actions.moveToElement(price).click().perform();

        WebElement maxValue = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[aria-label='Maximum value ₹99,999']")
                )
        );
        maxValue.clear();
        maxValue.sendKeys("15000");
        System.out.println("Entered Price");

        new WebDriverWait(driver, Duration.ofMillis(5000))
        .until(d -> true);

        WebElement applyFilter = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[@data-testid='plp-filter-apply-button']")
                )
        );
        actions.moveToElement(applyFilter).click().perform();
        System.out.println("Filter applied");



// ✅ IMPORTANT: Get product cards here
        List<WebElement> products = driver.findElements(
//                By.xpath("//div[@data-testid='product-card']"));
                By.xpath("//h3[@class='XxwSy']"));

        System.out.println("Total products found: " + products.size());

        int count = 0;
        System.out.println("\nFirst 3 Bookshelves below Rs. 15000:\n");

        for (WebElement product : products) {

            String pName = product.getText();

            WebElement pPrice = driver.findElement(By.xpath("//h3[text()='"+pName+"']/following-sibling::div/descendant::div[@class='UYQNp']"));

//            List<WebElement> nameEls = product.findElements(
//                    By.xpath(".//p[@data-testid='product-name']"));

//            List<WebElement> priceEls = product.findElements(
//                    By.xpath(".//span[@data-testid='product-price']"));

//            if (nameEls.isEmpty() || priceEls.isEmpty())
//                continue;
//
//            String name = nameEls.get(0).getText().trim();
            String priceText = pPrice.getText();

            int rate = Integer.parseInt(priceText.replaceAll("[^0-9]", ""));

            if (rate <= 15000) {
                System.out.println(++count + ". " + pName + " - Rs. " + rate);
            }

            if (count == 3)
                break;
        }


        // Step 10: Close browser
        driver.quit();
    }
}
