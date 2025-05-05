package SeleniumTopics;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_012_MouseActions {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
		driver.manage().window().maximize();
		
		//1. Mouse Hover Action
		// Locate the element to hover over
		WebElement hoverElement = driver.findElement(By.id("menu"));       
		// Initialize Actions class
		Actions actions = new Actions(driver);
		// Perform mouse hover
		actions.moveToElement(hoverElement).perform();

		//2. Left Click Action
		// Locate the element to click
		WebElement button = driver.findElement(By.id("submitButton"));
		// Perform the left click
		actions.click(button).perform();

		//3. Right Click (Context Click)
		// Locate the element to right-click
		WebElement element = driver.findElement(By.id("rightClickElement"));  
		// Perform right-click (context-click)
		actions.contextClick(element).perform();

		//4. Double Click Action
		// Locate the element to double-click
		WebElement ele = driver.findElement(By.id("doubleClickButton"));
		// Perform double-click
		actions.doubleClick(ele).perform();

		//5. Drag and Drop Action
		// Locate the elements to drag and drop
		WebElement source = driver.findElement(By.id("dragElement"));
		WebElement target = driver.findElement(By.id("dropTarget"));
		// Perform drag and drop
		actions.dragAndDrop(source, target).perform();

		//6. Click, Hold, and Release Action
		// Locate the element to click and hold
		WebElement eleme = driver.findElement(By.id("slider"));  
		// Click, hold, and release the slider element
		actions.clickAndHold(eleme).release().perform();

		//7. Move, Click, and Release
		// Locate the element to move, click, and release
		WebElement elements = driver.findElement(By.id("button"));  
		// Move to the element, click it, and release
		actions.moveToElement(elements).click().release().perform();
	}

}
