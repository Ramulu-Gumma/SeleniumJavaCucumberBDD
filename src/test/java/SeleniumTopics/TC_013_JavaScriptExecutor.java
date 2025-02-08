package SeleniumTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_013_JavaScriptExecutor {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		WebDriver driver; 
		driver = new ChromeDriver();
		driver.get("https://www.example.com");  // Replace with the actual URL

		//1. Scrolling the Page Using JavaScriptExecutor
		// Find an element to scroll into view
		WebElement element = driver.findElement(By.id("someElementId"));
		// Create an instance of JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll the page to the element
		js.executeScript("arguments[0].scrollIntoView(true);", element);

		//2. Clicking on Hidden Elements Using JavaScriptExecutor
		// Click a hidden element using JavaScript
		js.executeScript("document.getElementById('hiddenButton').click();");

		//3. Changing the DOM Using JavaScriptExecutor
		// Change the text of an element using JavaScript
		js.executeScript("document.getElementById('elementId').innerText = 'New Text';");

		//4. Getting the Page Title Using JavaScriptExecutor
		// Get the title of the page using JavaScript
		String pageTitle = (String) js.executeScript("return document.title;");
		System.out.println("Page Title: " + pageTitle);

		//5. Executing Asynchronous JavaScript Code (executeAsyncScript)
		// Execute asynchronous script
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
		// Print a message after waiting for 3 seconds
		System.out.println("Asynchronous script executed!");

		//6. Scroll to a Specific Element
		// Scroll to the element
		js.executeScript("arguments[0].scrollIntoView(true);", element);

		//7. Scroll by a Specific Pixel Value
		// Scroll down by 500 pixels
		js.executeScript("window.scrollBy(0, 500);");
		
		//8. Scrolling to the Bottom of the Page
		// Scroll to the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	}

}
