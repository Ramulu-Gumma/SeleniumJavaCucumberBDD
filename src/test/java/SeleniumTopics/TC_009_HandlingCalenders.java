package SeleniumTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_009_HandlingCalenders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver; 
		driver = new ChromeDriver();
		driver.get("https://www.example.com");  // Replace with the actual URL

		//1. Handling Standard HTML Date Picker ( <input type="date">)
		// Locate the date picker input element
		driver.findElement(By.id("datePicker")).sendKeys("2025-02-15");

		// 2. Handling JavaScript-based Calendar (Dynamic Calendar)
		// Open the calendar by clicking on the date input field
		WebElement dateField = driver.findElement(By.id("dateField"));
		dateField.click();
		// Select a specific date from the calendar (e.g., 15th Feb)
		WebElement date = driver.findElement(By.xpath("//td[text()='15']"));
		date.click();

		// 3. Handling Calendars with Navigation (Month/Year Navigation)
		// Open the calendar by clicking on the input field
		WebElement dateFl = driver.findElement(By.id("dateField"));
		dateFl.click();

		// Navigate to the required month (e.g., March 2025)
		WebElement nextMonthButton = driver.findElement(By.xpath("//span[@class='nextMonth']"));
		WebElement prevMonthButton = driver.findElement(By.xpath("//span[@class='prevMonth']"));

		// If the required month is in the next or previous months, click the navigation button
		while (!driver.findElement(By.xpath("//span[@class='monthLabel']")).getText().equals("March 2025")) {
			nextMonthButton.click();  // or prevMonthButton.click() depending on the case
		}

		// Select a specific day (e.g., 15th)
		WebElement day = driver.findElement(By.xpath("//td[text()='15']"));
		day.click();

		//4. Handling Time-based Calendars (Time Picker)
		// Open the time picker input field
		WebElement timeField = driver.findElement(By.id("timeField"));
		timeField.click();

		// Select the time (e.g., 10:30 AM)
		WebElement hour = driver.findElement(By.xpath("//option[text()='10']"));
		WebElement minute = driver.findElement(By.xpath("//option[text()='30']"));

		hour.click();
		minute.click();
	}

}
