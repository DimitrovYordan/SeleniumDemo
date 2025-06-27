package dataDriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
	
	DataFormatter formatter = new DataFormatter();
	
	@Test(dataProvider="driveTest")
	public void testCaseData(String greeting, String message, String id) {
		System.out.println(greeting + " " + message + " " + id);
	}

	@DataProvider(name="driveTest")
	public Object[][] getData() throws IOException {
		//Object[][] data = {{"hello", "text", 1}, {"bye", "text 2", 10}, {"han solo", "text 3", 100}};
		//return data;

		FileInputStream fis = new FileInputStream("C:\\Tests\\DataProviderData.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		// -1 because we don't need 1st row
		Object[][] data = new Object[rowCount - 1][colCount];
		// loop rows
		for (int r = 0; r < rowCount - 1; r++) {
			// start from index 1 because we want to skip 1st row
			row = sheet.getRow(r + 1);
			// loop column
			for (int c = 0; c < colCount; c++) {
				XSSFCell cell = row.getCell(c);				
				
				// [r][c] - 1st iteration is 0,0; 2nd is 0,1 ...
				data[r][c] = formatter.formatCellValue(cell);
			}
		}
		
		return data;
	}
	
}
