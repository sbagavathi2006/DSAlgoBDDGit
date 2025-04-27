package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	private String filePath;

    public ExcelReader(String filePath) {
        this.filePath = filePath;
    }
	
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
	
	public List<Map<String, String>> getDataAll(String sheetName){
        List<Map<String, String>> sheetData = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Map<String, String> rowData = new LinkedHashMap<>();
                Row row = sheet.getRow(i);
                if (row == null) continue;

                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                    Cell headerCell = headerRow.getCell(j);
                    Cell cell = row.getCell(j);
                    String header = headerCell.getStringCellValue();
                    String value = (cell == null) ? "" : cell.toString();
                    rowData.put(header.trim(), value.trim());
                }

                sheetData.add(rowData);
            }
        }catch (IOException e) {
                e.printStackTrace();
            }
            return sheetData;
        }
	
}
