package Java8;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01_LamdaExpressions {
	//1. Lambda Expressions--Lambda expressions allow you to write instances of single-method interfaces (functional interfaces) more concisely.

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElements(By.xpath("//a")).stream()
		.map(e->e.getText())
		.filter(s->!s.isBlank())
		.distinct()
		.sorted()
		.filter(s->s.startsWith("C")||s.startsWith("D"))
		.forEach(s->System.out.println(s));
		driver.close();

	}
}


