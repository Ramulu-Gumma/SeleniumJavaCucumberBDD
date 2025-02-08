package JavaCommonExceptionHandling;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
//What is WebDriverTimeoutException in Selenium?
//WebDriverTimeoutException occurs when WebDriverWait exceeds the specified timeout while waiting for an element or condition to be met.
//
//Common Causes of WebDriverTimeoutException:
//Element Not Found in Time – The element doesn’t appear within the specified wait time.
//Incorrect Locator – The element’s XPath or CSS selector is incorrect.
//Slow Page Load – The website takes longer to load elements.
//JavaScript Execution Delay – Elements load dynamically after an AJAX request.
//How to Handle WebDriverTimeoutException?
//✅ Solutions:
//
//Increase Wait Time – Use a longer WebDriverWait timeout.
//Check Element’s Locator – Ensure you are using the correct XPath or CSS Selector.
//Use FluentWait – Retry at intervals instead of failing immediately.
//Handle Loading Issues – Ensure AJAX requests and animations are complete before interacting.
//Real-Time Scenario:
//🔹 Scenario: You are automating a flight booking website, but the "Search Flights" button appears late due to AJAX loading, causing WebDriverTimeoutException.
public class JT_10_WebDriverTimeoutException {
	public static void main(String[] args) {
		// Set up WebDriver
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://example.com/flight-booking");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

			try {
				// Wait for "Search Flights" button to be clickable
				WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchFlights")));
				searchButton.click();

			} catch (TimeoutException e) {
				System.out.println("WebDriverTimeoutException occurred! Retrying with longer wait time...");

				// Retry with an extended timeout
				WebDriverWait longerWait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement searchButton = longerWait.until(ExpectedConditions.elementToBeClickable(By.id("searchFlights")));
				searchButton.click();

				System.out.println("Clicked Search Flights button successfully after waiting.");
			}

		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}
}

