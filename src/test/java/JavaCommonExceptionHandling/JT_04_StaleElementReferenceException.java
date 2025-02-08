package JavaCommonExceptionHandling;

//What is StaleElementReferenceException in Selenium?
//StaleElementReferenceException occurs when an element that was previously located is no longer attached to the DOM. This can happen in the following scenarios:
//
//Common Causes of StaleElementReferenceException:
//Page refresh or navigation – The element reference becomes invalid after a page reload.
//DOM update – The element is removed and recreated dynamically (e.g., after an AJAX call).
//JavaScript modifications – The element is changed or replaced in the background.
//How to Handle StaleElementReferenceException?
//✅ Solutions:
//
//Use try-catch block – Re-locate the element if it becomes stale.
//Use WebDriverWait – Wait for the element to be re-attached to the DOM.
//Use a loop to retry – Reattempt the action if a StaleElementReferenceException occurs.
//Real-Time Scenario:
//🔹 Scenario: Suppose you are testing a to-do list application where a "Delete" button appears dynamically after adding an item. If the DOM updates after adding an item, the initially located "Delete" button reference may become stale.

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class JT_04_StaleElementReferenceException {
	public static void main(String[] args) {
		// Set up WebDriver
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://example.com/todo");

			// Add a new to-do item
			WebElement addItemInput = driver.findElement(By.id("newItem"));
			addItemInput.sendKeys("Buy groceries");
			WebElement addButton = driver.findElement(By.id("addBtn"));
			addButton.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteBtn")));

			try {
				deleteButton.click(); // Try clicking the delete button
			} catch (StaleElementReferenceException e) {
				System.out.println("Element became stale. Retrying...");

				// Re-locate the element
				deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteBtn")));
				deleteButton.click();
			}

			System.out.println("Item deleted successfully!");

		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}

