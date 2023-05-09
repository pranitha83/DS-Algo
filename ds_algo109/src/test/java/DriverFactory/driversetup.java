package DriverFactory;

import java.time.Duration;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.LoggerLoad;

public class driversetup {
	private static WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	static ResourceBundle rb; // for reading properties file
	static String br; //to store browser name
public static driversetup driversetup;
	private driversetup() {

		rb=ResourceBundle.getBundle("Config");
		br=rb.getString("browser");
		
		if(br.equals("CHROME"))
		{
			LoggerLoad.info("enter getchromedriver");
			/*System.setProperty("webdriver.chrome.driver",".\\src/test/resources/drivers/chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--incognito");
			driver=new ChromeDriver(options);*/
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//tlDriver.set(new ChromeDriver());
		}
		/*else if br.equals("FIREFOX"){
		//Firefox
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if (br.equals("edge")) {
		//Edge
		System.setProperty("webdriver.msedge.driver", "C:/Users/sange/OneDrive/Desktop/Drivers/msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		}*/
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}

	public static void openPage(String url) {
		driver.get(url);
	}
	public static String getTitle() {
		return driver.getTitle();
	}
	public static void NavBack() {
		driver.navigate().back();
	}
	public static WebDriver getDriver() {
		//LoggerLoad.info("enter getdriver");
		//return driver;
		return driver;
	}
	
	public static void setUpDriver() {
		if (driversetup==null) {
			driversetup= new driversetup();
		}
	}
	
	public static void tearDown() {
		if(getDriver()!=null) {
			LoggerLoad.info("enter teardown");
			getDriver().close();
			getDriver().quit();
		}
		driversetup = null;
	}
}
