package JavaCommonExceptionHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

// NoSuchElementException is a common exception in Selenium WebDriver that occurs when an element cannot be found on a web page. This usually happens when:
//	The element is not present in the DOM.
//	The locator used to find the element is incorrect or outdated.
//	The element is not yet loaded or visible when the script tries to access it.
//
//	How to Handle NoSuchElementException?
//	You can handle this exception in multiple ways:
//
//	Use try-catch block: Catch the exception and handle it gracefully.
//	Use WebDriverWait: Explicitly wait for the element to be present before interacting with it.
//	Verify element presence using findElements: It returns an empty list instead of throwing an exception if the element is not found.
//Scenario:
//Imagine you are testing a login page. Sometimes, a pop-up appears randomly, which might delay the visibility of the login button. If your script tries to find the login button before it appears, it will throw NoSuchElementException.

public class JT_01_NoSuchElementException {
	public static void main(String[] args) {
		// Set up WebDriver
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://example.com/login");

			// Handling NoSuchElementException with try-catch
			try {
				WebElement loginButton = driver.findElement(By.id("loginBtn"));
				loginButton.click();
			} catch (NoSuchElementException e) {
				System.out.println("Login button not found, waiting...");
			}

			// Handling with Explicit Wait
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginBtn")));
			loginButton.click();

			System.out.println("Login button clicked successfully!");

		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}

//Key Points in Code
//Using try-catch: If the element is not found, we catch the NoSuchElementException and handle it.
//Using WebDriverWait: Waits until the login button is visible instead of failing immediately.
//Best Practice: Always use explicit waits when dealing with dynamic elements to avoid unnecessary exceptions.

