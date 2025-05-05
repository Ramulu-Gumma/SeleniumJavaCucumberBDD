package SeleniumTopics;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TC_018_ReadDataFromTheExcel {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
		driver.manage().window().maximize();

		//Read 2ndrow and 3rd column data from the excel file
		FileInputStream file = new FileInputStream("xlfilepath");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("sheetName");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(2);
		if(cell!=null) {
			switch (cell.getCellType()) {
			case STRING:
				System.out.println("cell value: "+cell.getStringCellValue());
				break;

			default:
				break;
			}
		}


	}

}
