package JavaCommonExceptionHandling;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

//What is InvalidSelectorException in Selenium?
//InvalidSelectorException is thrown when the locator (XPath, CSS Selector, etc.) used to find an element is incorrect or invalid.
//
//Common Causes of InvalidSelectorException:
//Syntax Errors in XPath/CSS Selector
//Example: By.xpath("//div[@id='123]") → (Missing closing quote)
//Using XPath functions not supported by the browser
//Example: By.xpath("//*[contains(text(), 'Login')]") → Some browsers may have limitations.
//Trying to use CSS selectors with XPath functions
//Example: By.cssSelector("//*[contains(@class, 'button')]") → (contains() is an XPath function, not CSS)
//Using an invalid index
//Example: By.xpath("(//input[@type='text'])[0]") → XPath index starts from 1, not 0.
//Applying an XPath meant for a single element to findElements()
//Example: List<WebElement> elements = driver.findElements(By.xpath("(//div)[1]")); → Won’t work because findElements() expects multiple elements.
//How to Handle InvalidSelectorException?
//✅ Solutions:
//
//Validate the XPath/CSS Selector in DevTools (Chrome/Firefox) before using it in code.
//Use try-catch to handle and log errors instead of failing the test.
//Check if the locator is compatible with findElement() or findElements().
//Use WebDriverWait to allow elements to load properly before interacting.
//Ensure proper syntax in XPath and CSS selectors.
public class JT_09_InvalidSelectorException {
	public static void main(String[] args) {
		// Set up WebDriver
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://example.com/login");

			try {
				// Incorrect XPath (Missing closing quote)
				WebElement usernameField = driver.findElement(By.xpath("//input[@id='username]"));
				usernameField.sendKeys("testuser");

			} catch (InvalidSelectorException e) {
				System.out.println("InvalidSelectorException caught! Using correct XPath...");

				// Correct XPath
				WebElement usernameField = driver.findElement(By.xpath("//input[@id='username']"));
				usernameField.sendKeys("testuser");

				System.out.println("Username entered successfully.");
			}

		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}
}


