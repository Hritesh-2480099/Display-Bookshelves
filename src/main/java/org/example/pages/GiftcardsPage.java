package org.example.pages;

import org.example.base.BasePage;
import org.example.utils.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Page Object class representing Gift Cards page
 */
public class GiftcardsPage extends BasePage {

    /**
     * Constructor to initialize driver via parent HomePage
     */
    public GiftcardsPage(WebDriver driver) {
        super(driver);
    }

    /* ===================== Gift Card Selection Fields ===================== */

    // Gift card amount field
    @FindBy(id = "denomination")
    private WebElement amount;

    // Gift card quantity field
    @FindBy(id = "quantity")
    private WebElement quantity;

    // Gift card design/theme selection
    @FindBy(xpath = "//div[@data-index='2']//img")
    private WebElement design;

    /* ===================== Sender Details Fields ===================== */

    // Sender first name input field
    @FindBy(xpath = "//*[@id='sender-details']//*[@id='firstname']")
    private WebElement sender_firstName;

    // Sender last name input field
    @FindBy(xpath = "//*[@id='sender-details']//*[@id='lastname']")
    private WebElement sender_lastName;

    // Sender email input field
    @FindBy(xpath = "//*[@id='sender-details']//*[@id='email']")
    static private WebElement sender_Email;

    // Sender mobile number input field
    @FindBy(xpath = "//*[@id='sender-details']//*[@id='telephone']")
    private WebElement sender_mobileNumber;

    /* ===================== Receiver Details Fields ===================== */

    // Receiver first name input field
    @FindBy(xpath = "//*[@id='receiver-details']//*[@id='firstname']")
    private WebElement receiver_firstName;

    // Receiver last name input field
    @FindBy(xpath = "//*[@id='receiver-details']//*[@id='lastname']")
    private WebElement receiver_lastName;

    // Receiver email input field
    @FindBy(xpath = "//*[@id='receiver-details']//*[@id='email']")
    static private WebElement receiver_Email;

    // Receiver gift message textarea
    @FindBy(xpath = "//*[@id='receiver-details']//*[@id='giftMessage']")
    private WebElement receiver_msg;
    // Invalid Email
    @FindBy(xpath ="//div[contains(text(),'Enter valid Email ID')]")
    private WebElement validEmail;

    @FindBy(xpath = "//button[normalize-space()='PREVIEW E-GIFT-CARD']")
    private WebElement previewButton;

    @FindBy(xpath = "//div[@data-index='2']//img")
    private WebElement chooseWishImage;
    // Home page reference to navigate to Gift Cards
    HomePage page = new HomePage(driver);

    /**
     * Method to fill gift card form and validate email error message
     */

    public static void scrollView(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void giftCardPage() {

        // Navigate to Gift Cards page from Home Page
        page.goToGiftcardsPage();

        // Switch to newly opened Gift Cards window/tab
        utils.switchToNew();

        // Wait until amount field is visible
        utils.visible(amount);

        // Enter gift card amount and quantity
        amount.sendKeys("1000");
        quantity.sendKeys("2");

        // Explicit wait for gift card theme
        WebElement theme = utils.waitForPresence(chooseWishImage);
        utils.scrollIntoView(theme);
        //ElementClickInterceptedException: element click intercepted: Element is not clickable
        //theme.click();
        utils.clickByJavascript(theme);
        /* ===================== Fill Sender Details ===================== */

        sender_firstName.sendKeys("Prince");
        sender_lastName.sendKeys("Kumar");
        sender_Email.sendKeys("abc@gmailcom");
        sender_mobileNumber.sendKeys("999999999999");

        /* ===================== Fill Receiver Details ===================== */

        receiver_firstName.sendKeys("Adam");
        receiver_lastName.sendKeys("Gilchrist");
        receiver_Email.sendKeys("xyz@gmail.com"); // Invalid email to trigger validation
        receiver_msg.sendKeys("Happy birthday yaar.....");

        // Scroll to gift message field
        utils.scrollIntoView(receiver_msg);
        utils.scrollIntoView(previewButton);

    }
    public static String validateEmail(){
        // Capture validation error message for invalid receiver email
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(20));
        try {
            WebElement errorMsg = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//div[contains(text(),'Enter valid Email ID')]")
                    )
            );
            scrollView(errorMsg);
            return "Invalid Email ID";
        } catch (TimeoutException e) {
            return "Valid Email ID";
        }

    }

    public static String validateMobile(){
        // Capture validation error message for invalid receiver email
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(20));
        try {
            WebElement errorMsg = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//div[contains(text(),'Enter valid Mobile Number')]")
                    )
            );
            scrollView(errorMsg);
            return "Invalid Mobile Number";
        } catch (TimeoutException e) {
            return "Valid Mobile Number";
        }

    }
}
