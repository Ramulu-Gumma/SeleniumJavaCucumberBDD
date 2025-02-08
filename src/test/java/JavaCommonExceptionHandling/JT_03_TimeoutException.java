package JavaCommonExceptionHandling;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//What is TimeoutException in Selenium?
//TimeoutException occurs when a Selenium WebDriver waits for a condition to be met, but the condition is not satisfied within the specified time limit.
//
//Common Causes of TimeoutException
//Slow network or page load delays
//Element takes longer to appear or be clickable
//Incorrect locators that never match an element
//Waiting for an element that doesn't exist
//How to Handle TimeoutException?
//✅ Solutions:
//
//Increase wait time – Extend the timeout period.
//Use try-catch block – Catch the exception and handle it.
//Use WebDriverWait properly – Ensure correct conditions and locators.
//Check if the element exists before waiting – Use findElements().size() > 0 instead of waiting indefinitely.
//Scenario: You are testing an e-commerce checkout page. The "Place Order" button appears after loading all payment options. If the button takes longer to load than expected, TimeoutException may occur.
public class JT_03_TimeoutException {
    public static void main(String[] args) {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.get("https://example.com/checkout");

            // Define WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            try {
                // Wait until "Place Order" button is visible and clickable
                WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("placeOrderBtn")));
                placeOrderButton.click();
                System.out.println("Order placed successfully!");
                
            } catch (TimeoutException e) {
                System.out.println("Timeout: 'Place Order' button did not appear in time. Retrying...");
                
                // Alternative: Increase wait time and try again
                WebDriverWait extendedWait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement placeOrderButton = extendedWait.until(ExpectedConditions.elementToBeClickable(By.id("placeOrderBtn")));
                placeOrderButton.click();
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
