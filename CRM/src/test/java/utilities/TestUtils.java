package utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basepack.Baseclass;

public class TestUtils extends Baseclass
{
	public static void takescreenshot(WebDriver driver, int Testid) throws IOException
	{
		 LocalDateTime snap = LocalDateTime.now();
		 DateTimeFormatter dateformat =  DateTimeFormatter.ofPattern("dd-MM-yyyy-HH_mm_ss");
		 String finaltime =snap.format(dateformat);
		 File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		 File Destination = new File ("C:\\Users\\HP\\git\\CRM\\CRM\\test-output\\Screenshot" + "Test_"+Testid +" "+finaltime +".png");
		 FileHandler.copy(screenshot, Destination);
	}
	 


}
