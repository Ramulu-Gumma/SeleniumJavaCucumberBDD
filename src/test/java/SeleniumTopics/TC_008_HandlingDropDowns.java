package SeleniumTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_008_HandlingDropDowns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver; 
		driver = new ChromeDriver();
		driver.get("https://www.example.com");  // Replace with the actual URL

		// Locate the dropdown element
		WebElement dropdown = driver.findElement(By.id("dropdownId"));
		// Create a Select object to interact with the dropdown
		Select select = new Select(dropdown);

		// Select an option by visible text
		select.selectByVisibleText("Option 1");
		// Select an option by index (0 is the first option)
		select.selectByIndex(2);  // Selects the third option (index starts at 0)
		// Select an option by value attribute
		select.selectByValue("optionValue");

		//2. Handling Multi-Select Dropdowns
		// Locate the multi-select dropdown element
		WebElement multiSelectDropdown = driver.findElement(By.id("multiSelectDropdownId"));
		// Create a Select object to interact with the dropdown
		Select multiSelect = new Select(multiSelectDropdown);
		// Select multiple options by index
		multiSelect.selectByIndex(1);  // Select second option
		multiSelect.selectByIndex(3);  // Select fourth option
		// Deselect an option by index
		multiSelect.deselectByIndex(1);  // Deselect the second option
		
		//3. Handling Custom Dropdowns (Non-HTML Select Elements)
		// Open the custom dropdown
        WebElement dropdownButton = driver.findElement(By.id("customDropdownButton"));
        dropdownButton.click();
        // Select an option from the custom dropdown (based on visible text)
        WebElement option = driver.findElement(By.xpath("//li[text()='Option 1']"));
        option.click();

	}

}
