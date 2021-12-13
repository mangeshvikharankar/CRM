import java.util.Properties;

public class Readproperties 
{

	public static void main(String[] args) 
	{
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("F:\\VELOCITY\\ECLIPSE\\CRM\\src\\main\\resources\\config\\config.properties");
		prop.load(input);
		System.out.println(prop.getProperty("browser"));
		String browsername = prop.getProperty("browser"));
		if browsername = "chrome"
		
	}

}
