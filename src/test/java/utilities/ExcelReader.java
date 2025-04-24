package utilities;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static Map<String, String> getData(String sheetName, int rowNum, String filePath) {
	    Map<String, String> data = new HashMap<>();

	    try (FileInputStream fis = new FileInputStream(filePath);
	         Workbook workbook = new XSSFWorkbook(fis)) {

	        Sheet sheet = workbook.getSheet(sheetName);
	        Row headerRow = sheet.getRow(0);
	        Row dataRow = sheet.getRow(rowNum);

	        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
	            String key = headerRow.getCell(i).getStringCellValue();
	            String value = "";

	            if (dataRow.getCell(i) != null) {
	                value = dataRow.getCell(i).toString().trim(); // Handles any cell type as string
	            }

	            data.put(key, value);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return data;
	}
}
