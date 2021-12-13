package propertiespack;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readproperties 
{

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("F:\\VELOCITY\\ECLIPSE\\CRM\\src\\main\\resources\\config\\config.properties");
		prop.load(input);
		System.out.println(prop.getProperty("browser"));
	}

}
