package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Practicing {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
//		WebElement element =  driver.findElement(By.xpath("//textarea[@title='Search']"));
//		element.sendKeys("Selenium Java Tutorial");
		List<WebElement> languages = driver.findElements(By.xpath("//*[@id='SIvCob']/a"));
		languages.get(0).click();
		for(WebElement lang :languages) {
			System.out.println("list of languages are: "+lang.getText());
			//Thread.sleep(3000);
			
			
		}
		driver.quit();
	}

}
