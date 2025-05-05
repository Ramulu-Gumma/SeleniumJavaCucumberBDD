package SeleniumTopics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_016_HandleBrokenLinks {

	public static void main(String[] args) {
		// Setup WebDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Open target website
		driver.get("https://amazon.in"); // Replace with the actual URL

		// Get all links from the webpage
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links found: " + links.size());

		List<String> urlList = new ArrayList<String>();
		for(WebElement ele: links) {
			String url = ele.getAttribute("href");
			urlList.add(url);
			//checkBrokenLink(url);
		}
		long stTime = System.currentTimeMillis();
		urlList.parallelStream().forEach(e->checkBrokenLink(e));
		//urlList.stream().forEach(e->checkBrokenLink(e));
		long endTime = System.currentTimeMillis();
		System.out.println("total time taken:" +(endTime-stTime));
		driver.quit();
	}

	public static void checkBrokenLink(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("HEAD");
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.connect();

			if (httpURLConnection.getResponseCode()>= 400) {
				System.out.println("Broken Link: " + linkUrl + " | HTTP Response Code: " + httpURLConnection.getResponseMessage());
			} else {
				System.out.println("Valid Link: " + linkUrl + " | HTTP Response Code: " + httpURLConnection.getResponseMessage());
			}
		} catch (IOException e) {
			System.out.println("Error checking link: " + linkUrl + " | Exception: " + e.getMessage());
		}
	}
}