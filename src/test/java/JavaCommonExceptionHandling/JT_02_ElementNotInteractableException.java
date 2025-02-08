package JavaCommonExceptionHandling;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
//What is ElementNotInteractableException in Selenium?
//ElementNotInteractableException occurs when an element is present in the DOM but is not interactable, meaning Selenium cannot perform actions like clicking or typing on it.
//
//Common Causes of ElementNotInteractableException:
//Element is hidden (e.g., inside a collapsed dropdown, modal, or with display: none; CSS).
//Element is disabled (e.g., a grayed-out button).
//Page is still loading, and the element is not ready for interaction.
//Overlapping elements (another element is covering it).
//How to Handle ElementNotInteractableException?
//✅ Solutions:
//
//Use WebDriverWait – Wait until the element is visible and enabled.
//Use JavaScript Executor – If the element is hidden but should be interacted with.
//Check Element State – Ensure the element is not disabled before interacting.
//Scroll into View – If the element is not within the viewport.
//Scenario: Trying to click a login button, but it's initially hidden under a pop-up.
public class JT_02_ElementNotInteractableException {
	public static void main(String[] args) {
		// Set up WebDriver
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://example.com/login");

			// Wait until the login button is visible and clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn")));

			try {
				loginButton.click(); // Attempt to click
			} catch (ElementNotInteractableException e) {
				System.out.println("Element not interactable, using alternative approach...");

				// Option 1: Use JavaScript Executor to click
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", loginButton);

				// Option 2: Scroll to the element before clicking
				js.executeScript("arguments[0].scrollIntoView(true);", loginButton);
				loginButton.click();
			}

			System.out.println("Login button clicked successfully!");

		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}

