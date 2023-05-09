package AllHooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import DriverFactory.driversetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.LoggerLoad;

public class Hooks {
	@Before(order=0)
    public static void setUp() {
		LoggerLoad.info("before order 1");//Driverset=new driversetup();
	driversetup.setUpDriver();
	 
    }
@Before(order=1)
public static void setup2() {
	driversetup.getDriver();
	LoggerLoad.info("order 0");
}

 
 @After(order=1)
    public static void tearDown(Scenario scenario) {
 
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot)driversetup.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName()); 
            
            
        }   
       // driversetup.tearDown();
       }
 
	

}
