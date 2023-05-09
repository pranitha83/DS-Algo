package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepdefinitions.BasePage;
import utilities.LoggerLoad;

public class DataStucturesIntr extends BasePage {
 WebDriver driver;
 @FindBy(xpath = "//body//div[1]//a[text()='Get Started']") WebElement GetStarted;
 @FindBy(linkText =  "Time Complexity") WebElement Timecomplexity;
 @FindBy(linkText = "Practice Questions") WebElement practiesQuestions;
 
 public  DataStucturesIntr(WebDriver driver) {
		
		LoggerLoad.info("enter homepage feature");
		PageFactory.initElements(driver,this);
		driver.switchTo().window(driver.getWindowHandle());
	
}
 public void getstarted() {
	 GetStarted.click();
 }
 public void timecomplexity() {
	 Timecomplexity.click();
 }
 
 public void practicequestions() {
	 practiesQuestions.click();
 }
}

