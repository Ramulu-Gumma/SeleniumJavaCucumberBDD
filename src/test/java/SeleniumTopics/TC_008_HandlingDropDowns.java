package SeleniumTopics;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_008_HandlingDropDowns {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
		driver.manage().window().maximize();
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
