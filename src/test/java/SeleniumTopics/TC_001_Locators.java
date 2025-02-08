package SeleniumTopics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class TC_001_Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromepath");
		WebDriver driver = new ChromeDriver();
		driver.get("");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Locate an element using ID (Assuming the element has id="username")
		WebElement usernameField = driver.findElement(By.id("username"));
		// Interact with the element (enter text into a username field)
		usernameField.sendKeys("testUser");

		// Locate an element using Name (Assuming the element has name="email")
		WebElement emailField = driver.findElement(By.name("email"));
		// Interact with the element (enter email)
		emailField.sendKeys("test@example.com");

		// Locate an element using Class Name (Assuming the element has class="submit-btn")
		WebElement submitButton = driver.findElement(By.className("submit-btn"));
		// Interact with the element (click the submit button)
		submitButton.click();

		// Locate a link by full Link Text (Assuming a link with text "Contact Us")
		WebElement contactLink = driver.findElement(By.linkText("Contact Us"));
		// Interact with the element (click the link)
		contactLink.click();

		// Locate a link by Partial Link Text (Assuming a link with text "Terms")
		WebElement termsLink = driver.findElement(By.partialLinkText("Terms"));
		// Interact with the element (click the link)
		termsLink.click();

		// Locate the first button element by Tag Name (Assuming there is a <button> tag)
		WebElement button = driver.findElement(By.tagName("button"));
		// Interact with the element (click the button)
		button.click();

		// Locate an input element by CSS Selector (Assuming input with name='email')
		WebElement email = driver.findElement(By.cssSelector("input[name='email']"));
		// Interact with the element (enter email)
		email.sendKeys("user@example.com");

		//Locating by ID
		WebElement byId = driver.findElement(By.cssSelector("#loginBtn"));
		byId.click();

		//Locating by Class	
		WebElement byClass = driver.findElement(By.cssSelector(".inputField"));
		byClass.click();
		
		//Locating by Tag Name
		WebElement byTagName = driver.findElement(By.cssSelector("p"));
		byTagName.click();
		
		//Locating by Attribute
		WebElement byAttribute = driver.findElement(By.cssSelector("input[type='password']"));
		byAttribute.click();
		

		// Locate an input field by XPath (Assuming the field has name='username')
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		// Interact with the element (enter text into the username field)
		username.sendKeys("testUser");

		// Locate an input field inside a div with class 'form-group'
		WebElement passwordField = driver.findElement(By.xpath("//div[@class='form-group']//input[@type='password']"));
		// Interact with the element (enter password)
		passwordField.sendKeys("securePassword");

		//By ID:
		driver.findElement(By.xpath("//*[@id='elementID']"));
		//By Class:
		driver.findElement(By.xpath("//*[@class='elementClass]"));
		//By Attribute (e.g., type="text"):
		driver.findElement(By.xpath("//input[@type='text']"));
		//By Text (matching the exact text):
		driver.findElement(By.xpath("//button[text()='Submit']"));
		//Using Contains() with Attributes:
		driver.findElement(By.xpath("//button[contains(text(), 'Sub')]"));
		driver.findElement(By.xpath("//input[contains(@name, 'username')]"));
	}

}
