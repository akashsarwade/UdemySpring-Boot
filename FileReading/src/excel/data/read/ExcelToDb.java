package excel.data.read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

public class ExcelToDb {

	public static void main(String[] args) {
		String excelFilePath="C:\\Akash\\Student.xlsx";
		String username="";
		String password="";
		
		
		try {
			FileInputStream file=new FileInputStream(excelFilePath);
			
			Workbook workbook=XSSFWorkbookFactory.
			
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
