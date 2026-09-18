package utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	 XSSFWorkbook wb;

	    public ExcelReader() 
	    {
	        try {  
	        	FileInputStream fis = new FileInputStream("src/test/resources/loginData.xlsx");
	            wb = new XSSFWorkbook(fis);

	        } catch (IOException e) 
	        {
	            e.printStackTrace();
	        }
	    }

	    public String getData(String sheetName, int row, int column) {

	        return wb.getSheet(sheetName)
	                 .getRow(row)
	                 .getCell(column)
	                 .toString();
	    }
}
