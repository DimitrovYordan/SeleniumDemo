import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public static void main(String[] args) throws IOException {
		
	}
	
	public ArrayList<String> getData(String testCaseName) throws IOException {
		// create object that can read file
		FileInputStream fis = new FileInputStream("C:\\Tests\\TestData.xlsx");
		//ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				// loop all rows
				Iterator<Row> rows = sheet.iterator();
				
				Row currRow = rows.next();
				// loop all cells
				Iterator<Cell> cell = currRow.cellIterator();
				// if next cell has value return true
				int count = 0;
				int coloumnInd = 0;
				while (cell.hasNext()) {
					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase("Test Cases")) {
						coloumnInd = count;
					}
					
					count++;
				}
				
				System.out.println(coloumnInd);
				// if next row has value return true
				while (rows.hasNext()) {
					Row curr = rows.next();
					// this if prevent null exception
					if (curr.getCell(coloumnInd) != null) {
						if (curr.getCell(coloumnInd).getStringCellValue().equalsIgnoreCase("Add Profile")) {
							Iterator<Cell> currCell = curr.cellIterator();
							// get founded row all cells info
							while (currCell.hasNext()) {
								Cell cellValue = currCell.next();
								if (cellValue.getCellType() == CellType.STRING) {									
									list.add(cellValue.getStringCellValue());
								}
								else {
									// Convert number to string
									list.add(NumberToTextConverter.toText(cellValue.getNumericCellValue()));
								}
							}
						}
					}
				}
			}			
		}
		
		return list;
	}

}
