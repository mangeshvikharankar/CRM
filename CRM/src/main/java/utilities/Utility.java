package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility 
{

	public static String logindata1(int x, int y) throws IOException
	{
		String path = "F:\\VELOCITY\\CRM\\excel.xlsx";
		FileInputStream file = new FileInputStream (path);
		String credentials1= WorkbookFactory.create(file).getSheet("CRM").getRow(x).getCell(y).getStringCellValue();
		return credentials1;
	}
	
	public static String logindata2(int x, int y) throws IOException
	{
		String path = "F:\\VELOCITY\\CRM\\excel.xlsx";
		FileInputStream file = new FileInputStream(path);
		Cell credentials2= WorkbookFactory.create(file).getSheet("CRM").getRow(x).getCell(y);
		DataFormatter formatter = new DataFormatter();
		String s = formatter.formatCellValue(credentials2);
		return s;
		
	}
	
	public static void testcaseresult(int x, int y, boolean result) throws IOException
	{
		String path = "F:\\VELOCITY\\CRM\\excel.xlsx";
		FileInputStream file = new FileInputStream(path);
	    Workbook wb = new XSSFWorkbook(file);
	    wb.getSheet("CRM").getRow(x).createCell(y).setCellValue(result);
	    FileOutputStream fos = new FileOutputStream(path);
	    wb.write(fos);
	    wb.close();
	    fos.close();
	}
	

}
