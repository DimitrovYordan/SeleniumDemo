import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UploadDownloadExcel {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		String fruitName = "Apple";
		String updatedValue = "610";
		String fileName = excelPath;
		
		// download
		driver.findElement(By.cssSelector("#downloadButton")).click();
		
		// edit excel
		int col = getColumnNumber(fileName, "price");
		int row = getRowNumber(fileName, fruitName);
		Assert.assertTrue(updateCell(fileName, col, row, updatedValue));
		
		// upload
		WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
		upload.sendKeys(fileName);
		
		// wait message to show up and disappear
		By locator = By.cssSelector(".Toastify__toast-body div:nth-child(2)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		String message = driver.findElement(locator).getText();
		Assert.assertEquals("Updated Excel Data Successfully.", message);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

		// verify updated excel data showing in the web table
		String priceColumn = driver.findElement(By.xpath("//div[text()='Price']")).getDomAttribute("data-column-id");
		String actualPrice = driver.findElement(By.xpath("//div[text()='"+fruitName+"']/parent::div/parent::div/div[@id='cell-"+ priceColumn +"-undefined']")).getText();
		Assert.assertEquals("350", actualPrice);
		
		driver.close();
	}

	private static boolean updateCell(String fileName, int col, int row, String updatedValue) throws IOException {

		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Row rowField = sheet.getRow(row - 1);
		Cell cellField = rowField.getCell(col - 1);
		cellField.setCellValue(updatedValue);
		FileOutputStream fos = new FileOutputStream(fileName);
		workbook.write(fos);
		workbook.close();
		fis.close();
		return true;
	}

	private static int getRowNumber(String fileName, String cellText) throws IOException {

		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Iterator<Row> rows = sheet.iterator();
		int currRow = 1;
		int rowIndex = -1;
		
		while (rows.hasNext()) {
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			
			while (cells.hasNext()) {
				Cell cell = cells.next();
				if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equalsIgnoreCase(cellText)) {
					rowIndex = currRow;
				}
			}
			
			currRow++;
		}
		
		return rowIndex;
	}

	private static int getColumnNumber(String fileName, String colName) throws IOException {
		
		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Iterator<Row> rows = sheet.iterator();
		Row firstRow = rows.next();
		Iterator<Cell> cells = firstRow.cellIterator();
		int count = 0;
		int column = 0;
		
		while (cells.hasNext()) {
			Cell cell = cells.next();
			
			if (cell.getStringCellValue().equalsIgnoreCase(colName)) {
				column = count;
			}
			
			count++;
		}
		
		return column;
	}

}
