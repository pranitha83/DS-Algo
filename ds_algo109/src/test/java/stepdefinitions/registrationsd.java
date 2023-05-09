package stepdefinitions;
import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.*;
import PageObjects.LoginPage;
import PageObjects.registrationpage;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import utilities.*;
public class registrationsd extends BasePage {
	WebDriver driver;
	
	 
//String excelpath ="C:\\Users\\yours\\Desktop\\Data\\data_dsalgo.xlsx";
String excelpath =".\\ExcelData/data_dsalgo.xlsx";
int rowval =0;
	
	String expmsg="";
	@Given("user click registration link")
	public void user_click_registration_link() throws InterruptedException  {
		
		//driver.switchTo().window(driver.getWindowHandle());
		driver= (driversetup.getDriver());
		registerPage = new registrationpage(driver);
		login = new LoginPage(driver);
		registerPage.registrationlink();
		//Thread.sleep(2000);
	}

	@When("user enter username,password,confirm password from given {string} and {int}")
	public void user_enter_username_password_confirm_password_from_given_and(String string, Integer int1) throws IOException, InvalidFormatException, InterruptedException {	  

		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter registration credentials");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		//rowval=testData.size();
		String User_name=testData.get(int1).get("username"); // Column heading
		String Pass_word=testData.get(int1).get("password"); // Column heading
		String Pass_wordcnf = testData.get(int1).get("passwordconfirm");
		expmsg=testData.get(int1).get("expectedmsg");
		registerPage.readusernameandpassword(User_name, Pass_word,Pass_wordcnf);
		LoggerLoad.info("Registration credentials entered");
		//Thread.sleep(2000);
		rowval=int1;
	}

	@Then("user click register button with expected message")
	public  void user_click_register_button_with_expected_message() throws InterruptedException, Throwable {
		registerPage.regbtnclk();
		String actmsg="";
		
		/*Scenario scenario = null;
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName()); 
		}   
		//driversetup.tearDown();*/
		if (rowval<=2) {
			WebElement hidtext=new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='username']"))));
			System.out.println(hidtext.getAttribute("validationMessage"));
			LoggerLoad.info(hidtext.getAttribute("validationMessage"));
			actmsg=hidtext.getAttribute("validationMessage");
			Assert.assertEquals(actmsg, expmsg);
			
		}
		else if ((rowval>2) && (rowval<10)){
			actmsg=registerPage.alert();
			Assert.assertEquals(actmsg, expmsg);
			
		}
		else if(rowval==10) {
			
			actmsg=login.alertdismsg();
			
			Assert.assertEquals(actmsg, expmsg);
			login.signout();
			Thread.sleep(1000);
			login.alertdismsg();
			System.out.print(login.alertdismsg());
			//Thread.sleep(1000);
			login.signin();
			
			
		}
		
	}		
	
}
		
		
	

