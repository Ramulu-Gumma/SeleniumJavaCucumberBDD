package SeleniumTopics;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_006_HandlingCheckBoxes {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
		driver.manage().window().maximize();

		//1. Checking if a Checkbox is Selected--The isSelected() method is used to determine whether a checkbox is checked
		WebElement checkbox = driver.findElement(By.id("subscribeCheckbox"));
		
		// Check if the checkbox is selected
		boolean isChecked = checkbox.isSelected();
		System.out.println("Is the checkbox selected? " + isChecked);

		//2. Clicking a Checkbox--To interact with a checkbox, you use the click() method.
		// Locate the checkbox using its ID or other locator
		WebElement selectbox = driver.findElement(By.id("subscribeCheckbox"));

		// Check if the checkbox is not selected
		if (!selectbox.isSelected()) {
			selectbox.click();  // Check the checkbox
			System.out.println("Checkbox checked.");
		} else {
			selectbox.click();  // Uncheck the checkbox
			System.out.println("Checkbox unchecked.");

			//3. Handling Multiple Checkboxes--When dealing with multiple checkboxes on a page (form with several options), you might need to interact with a list of checkboxes.
			// Locate the checkboxes (assuming they have the same class name or a shared identifier)
			List<WebElement> multipleCheckboxes = driver.findElements(By.className("checkboxClass"));

			// Loop through each checkbox and select it if it's not already selected
			for (WebElement multiple : multipleCheckboxes) {
				if (!multiple.isSelected()) {
					multiple.click();  // Check the checkbox
				}
			}
		}

		//5. Wait for Checkbox to be Visible or Clickable
		// Wait for the checkbox to be clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement selectCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("subscribeCheckbox")));

		// Now interact with the checkbox
		selectCheckbox.click();  // Click to check/uncheck

	}

}
