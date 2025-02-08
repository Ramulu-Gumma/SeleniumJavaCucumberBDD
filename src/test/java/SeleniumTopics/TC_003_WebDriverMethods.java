package SeleniumTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_003_WebDriverMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromepath");
		WebDriver driver = new ChromeDriver();
		//1. get()--Opens a URL in the browser.
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		//2. getTitle()--Returns the title of the current page.
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("Page Title: " + title);
		
		//3. getCurrentUrl()--Returns the URL of the current page.
		driver.get("https://www.example.com");
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL: " + currentUrl);
		
		//4. submit()--Submits a form by simulating pressing the "Enter" key in a text field or a submit button.
		WebElement form = driver.findElement(By.id("loginForm"));
		form.submit();
		
		//5. getText()--Returns the visible text of an element.
		driver.get("https://www.example.com");
		WebElement message = driver.findElement(By.id("welcomeMessage"));
		String welcomeText = message.getText();
		System.out.println("Welcome message: " + welcomeText);
		
		//6. getAttribute(String name)-Retrieves the value of an element's attribute (e.g., href, value, class, etc.).
		WebElement link = driver.findElement(By.id("myLink"));
		String linkHref = link.getAttribute("href");
		System.out.println("Link URL: " + linkHref);
		
		
		//7. switchTo()--Switches the context to a different frame, alert, or window.
		driver.switchTo().frame("frameName");
		driver.switchTo().alert().accept();
		driver.switchTo().window("windowHandle");
		
		//8. quit()--Closes all browser windows and ends the WebDriver session.
		driver.quit();
		
		//9. close()-closes current opened window
		driver.close();

		
		

	}

}
