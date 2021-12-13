package basepack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Baseclass 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public Baseclass()  
	{
		try 
		{
			Properties prop = new Properties();
			FileInputStream input = new FileInputStream("F:\\VELOCITY\\ECLIPSE\\CRM\\src\\main\\java\\config\\config.properties");
			prop.load(input);
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
	
	public static void driverintialization()
	{
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src" + File.separator + "test" + File.separator + "resources" + File.separator + "browsers" + File.separator + "chromedriver.exe");
			 driver = new ChromeDriver ();
		}
		else if(browsername.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","src" + File.separator + "test" + File.separator + "resources" + File.separator + "browsers" + File.separator + "geckodriver.exe" );
			  driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
