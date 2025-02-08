package JavaCommonExceptionHandling;

//What is ElementNotFoundException in Selenium?
//ElementNotFoundException is not a built-in exception in Selenium WebDriver. Instead, Selenium throws NoSuchElementException when an element cannot be found.
//
//Common Causes of Element Not Found Issues:
//Incorrect locator (XPath, ID, CSS Selector, etc.)
//Element takes time to load (use WebDriverWait)
//Element is inside an iframe or shadow DOM
//Dynamic elements that appear/disappear based on user actions
//How to Handle "Element Not Found" Issues?
//✅ Solutions:
//
//Use try-catch block – Handle NoSuchElementException gracefully.
//Use WebDriverWait – Wait for the element to be present instead of failing immediately.
//Verify presence with findElements() – This method returns an empty list instead of throwing an exception.
//Check if the element is inside an iframe or shadow DOM.
//Real-Time Scenario:
//🔹 Scenario: Suppose you are automating a login form, but sometimes the "Forgot Password?" link is missing. Instead of failing the test, we want to handle this scenario gracefully.

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class JT_05_ElementNotFoundException {
	public static void main(String[] args) {
		// Set up WebDriver
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://example.com/login");

			// Using try-catch to handle NoSuchElementException
			try {
				WebElement forgotPasswordLink = driver.findElement(By.id("forgotPassword"));
				forgotPasswordLink.click();
				System.out.println("Forgot Password link clicked.");
			} catch (NoSuchElementException e) {
				System.out.println("Forgot Password link not found. Proceeding with login...");
			}

			// Using WebDriverWait to avoid Element Not Found issue
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
			usernameField.sendKeys("testuser");

			System.out.println("Login process continued...");

		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}

