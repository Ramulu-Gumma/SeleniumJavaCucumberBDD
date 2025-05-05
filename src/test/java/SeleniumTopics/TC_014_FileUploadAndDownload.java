package SeleniumTopics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_014_FileUploadAndDownload {

	public static void main(String[] args) throws InterruptedException, AWTException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
		driver.manage().window().maximize();

		//1: Uploading a File Using SendKeys
		// Locate the file input element
		WebElement uploadElement = driver.findElement(By.id("fileUpload"));
		// Send the file path to the file input element
		uploadElement.sendKeys("C:/path/to/your/file.txt");
		// Click the upload button if necessary
		WebElement uploadButton = driver.findElement(By.id("uploadButton"));
		uploadButton.click();
		
		//2: Handling File Upload Using the Robot Class
		// Locate the file input element and click it to open the file dialog
        WebElement uploadEle = driver.findElement(By.id("fileUpload"));
        uploadEle.click();  // This triggers the file dialog to open
        
        // Wait for the file dialog to open
        Thread.sleep(2000);  // Adjust the sleep time if necessary

        // Create an instance of the Robot class
        Robot robot = new Robot();

        // Use Robot class to simulate typing the file path
        String filePath = "C:\\path\\to\\your\\file.txt";

        // Type the file path
        for (char c : filePath.toCharArray()) {
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
        }

        // Press Enter to confirm the file selection
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Wait for the upload to complete
        Thread.sleep(2000);

        // Optionally, submit the form or click the upload button
         WebElement uploadBtn = driver.findElement(By.id("uploadButton"));
         uploadBtn.click();


         //3: Handling File Upload with AutoIt (for Pop-ups)
         //WinWaitActive("Open", "", 10)
         //Send("C:\path\to\your\file.txt")
         //Send("{ENTER}")
         // Locate and click the file input element (this opens the file upload dialog)
         WebElement uploadElem = driver.findElement(By.id("fileUpload"));
         uploadElem.click();

         // Execute the AutoIt script to handle the file upload dialog
         try {
             Runtime.getRuntime().exec("C:\\path\\to\\AutoIt\\fileUpload.exe");
         } catch (IOException e) {
             e.printStackTrace();
         }
         
         
         //1. File Download with ChromeDriver
         // // Set download directory in Chrome preferences
         String downloadDir = "C:\\path\\to\\download\\directory";
         
         ChromeOptions options = new ChromeOptions();
         options.addArguments("download.default_directory=" + downloadDir);
         
         WebDriver driver1 = new ChromeDriver(options);
         // Open the URL that has the download link/button
         driver1.get("https://www.example.com/download");
         // Locate the download link or button
         driver.findElement(By.id("downloadButton")).click();  // Adjust the selector as needed
         // Wait for the download to complete (you might need to wait longer depending on file size)
         TimeUnit.SECONDS.sleep(5);

         // Verify if the file is downloaded
         File downloadedFile = new File(downloadDir + "\\filename.extension");  // Replace with actual file name

         if (downloadedFile.exists()) {
             System.out.println("Download successful!");
         } else {
             System.out.println("Download failed.");
         }
         
	}

}
