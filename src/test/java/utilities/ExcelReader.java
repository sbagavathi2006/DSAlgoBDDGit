package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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



//	public static List<Map<String, String>> getAllLoginData(String sheetName, String filePath) {
//	    List<Map<String, String>> dataList = new ArrayList<>();
//
//	    try (FileInputStream fis = new FileInputStream(filePath);
//	         Workbook workbook = WorkbookFactory.create(fis)) {//workbookfactory-automatically detects the Excel format
//
//	        Sheet sheet = workbook.getSheet(sheetName);
//	        Row headerRow = sheet.getRow(0);
//
//	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//	            Row row = sheet.getRow(i);
//	            Map<String, String> rowData = new HashMap<>();
//	            for (int j = 0; j < headerRow.getLastCellNum(); j++) {
//	                String key = headerRow.getCell(j).getStringCellValue().trim();
//
//	                Cell cell = row.getCell(j);
//	                String value = "";
//
//	                if (cell != null) {
//	                    value = cell.getStringCellValue().trim(); // safe to call
//	                }
//
//	                rowData.put(key, value); 
//	            }
//
//	            dataList.add(rowData);
//	        }
//
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//
//	    return dataList;
//	}

}
