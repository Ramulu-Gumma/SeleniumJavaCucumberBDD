package SeleniumTopics;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TC_018_ReadDataFromTheExcel {

	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Launch chrome Browser
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "chromedriverpath");
		driver = new ChromeDriver();
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
