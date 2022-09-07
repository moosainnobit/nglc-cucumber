package Utils;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.junit.*;

public class BaseTest {

	public static WebDriver driver;
	protected static Properties ConfigProperties = new Properties();
	public static Properties ConfigObj=new Properties();

	public void setEnviorment() throws Exception
	{

		FileInputStream fis_config=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//Config//config.properties");  //("/home/innobit/eclipse-workspace/nglc-webui-automation/src/main/java/com/nglc/properties/Config.properties");

		ConfigProperties.load(fis_config);
		FileInputStream fis_obj=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//Config//object.properties"); //("/home/innobit/eclipse-workspace/nglc-webui-automation/src/main/java/com/nglc/properties/Object.properties");
		ConfigObj.load(fis_obj);
		if(ConfigProperties.getProperty("browser").equalsIgnoreCase("Chrome")){
			//ConfigPropertieslog.info("Opening Chrome Browser");
			System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromepath"));
			System.out.println(ConfigProperties.getProperty("chromepath"));
			driver=new ChromeDriver();
			

		}
		else if(ConfigProperties.getProperty("browser").equalsIgnoreCase("IE")){
			//log.info("Opening IE Browser");
			System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("driverpath"));
			driver=new InternetExplorerDriver();
		}
		else if(ConfigProperties.getProperty("browser").equalsIgnoreCase("Firefox")){
			//log.info("Opening Firefox Browser");
			System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("driverpath"));
			driver=new FirefoxDriver();
		}


		driver.manage().window().maximize();
		driver.get(ConfigProperties.getProperty("url"));
	}



}
