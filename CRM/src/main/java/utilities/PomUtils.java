package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PomUtils 
{
	public static String logindata1(int x, int y) throws IOException
	{ 	
		try 
		{
			String path = "C:\\Users\\HP\\git\\CRM\\CRM\\src\\test\\java\\testdata\\CRMDATA.xlsx";
			FileInputStream file = new FileInputStream (path);
			String credentials1= WorkbookFactory.create(file).getSheet("contacts").getRow(x).getCell(y).getStringCellValue();
			return credentials1;
		} 
		catch (EncryptedDocumentException e) 
		{
			e.printStackTrace();
			return null;
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return null;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		}	
	}
	
	public static String logindata2(int x, int y) throws IOException
	{
		try 
		{
			String path =  "C:\\Users\\HP\\git\\CRM\\CRM\\src\\test\\java\\testdata\\CRMDATA.xlsx";
			FileInputStream file = new FileInputStream(path);
			Cell credentials2= WorkbookFactory.create(file).getSheet("contacts").getRow(x).getCell(y);
			DataFormatter formatter = new DataFormatter();
			String s = formatter.formatCellValue(credentials2);
			return s;
		} 
		catch (EncryptedDocumentException e) 
		{
			e.printStackTrace();
			return null;
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return null;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		}		
	}
	
	public static void testcaseresult(int x, int y, boolean result) throws IOException
	{
		try {
			String path = "C:\\Users\\HP\\git\\CRM\\CRM\\src\\test\\java\\testdata\\CRMDATA.xlsx";
			FileInputStream file = new FileInputStream(path);
			Workbook wb = new XSSFWorkbook(file);
			wb.getSheet("contacts").getRow(x).createCell(y).setCellValue(result);
			FileOutputStream fos = new FileOutputStream(path);
			wb.write(fos);
			wb.close();
			fos.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static int sheetLength()
	{
		try 
		{
			String path = "C:\\Users\\HP\\git\\CRM\\CRM\\src\\test\\java\\testdata\\CRMDATA.xlsx";
			FileInputStream file = new FileInputStream (path);
			int length= WorkbookFactory.create(file).getSheet("contacts").getLastRowNum();
			return length;
		} 
		catch (EncryptedDocumentException e) 
		{
			e.printStackTrace();
			return 0;
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return 0;
		} catch (IOException e) 
		{
			e.printStackTrace();
			return 0;
		}
	}

}
