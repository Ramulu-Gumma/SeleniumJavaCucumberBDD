package JavaCommonExceptionHandling;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//What is ElementClickInterceptedException in Selenium?
//ElementClickInterceptedException occurs when Selenium tries to click an element, but another element (like an overlay, popup, or sticky element) blocks it.
//
//Common Causes of ElementClickInterceptedException:
//Pop-ups, modals, or ads — A popup appears and covers the clickable element.
//Sticky headers/footers — Fixed elements overlap and prevent interaction.
//Animations — The element is still moving when the click is attempted.
//Hidden overlays — Some elements are invisible but still intercept clicks.
//How to Handle ElementClickInterceptedException?
//✅ Solutions:
//
//Scroll into view — Scroll the element into the viewport before clicking.
//Use WebDriverWait — Wait for overlays to disappear before clicking.
//Use JavaScript click — Force click using JavaScript if the normal click fails.
//Handle overlays — Close popups or ads before clicking the element.
//Real-Time Scenario:
//🔹 Scenario: You are automating an e-commerce website, but an advertisement popup appears and blocks the "Buy Now" button, preventing Selenium from clicking it.
public class JT_07_ElementClickInterceptedException {
	public static void main(String[] args) {
		// Set up WebDriver
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://example.com/product");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			try {
				// Wait until the "Buy Now" button is clickable
				WebElement buyNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("buyNowBtn")));

				// Attempt to click
				buyNowButton.click();

			} catch (ElementClickInterceptedException e) {
				System.out.println("ElementClickInterceptedException occurred!");

				// Option 1: Scroll into view and try again
				WebElement buyNowButton = driver.findElement(By.id("buyNowBtn"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buyNowButton);

				// Option 2: Click using JavaScript as a fallback
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", buyNowButton);

				// Option 3: Handle overlay (assuming overlay has an ID "closeAd")
				try {
					WebElement closeAdButton = driver.findElement(By.id("closeAd"));
					closeAdButton.click();
					System.out.println("Closed overlay, retrying...");

					// Retry clicking the buy button
					buyNowButton.click();

				} catch (NoSuchElementException ex) {
					System.out.println("No overlay found, proceeding...");
				}
			}

			System.out.println("Buy Now button clicked successfully!");

		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}
}

