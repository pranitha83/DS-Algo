package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import stepdefinitions.BasePage;

public class DataStucturesIntr extends BasePage {
 WebDriver driver;
 @FindBy(xpath = "//body//div[2]//a[text()='Get Started']") WebElement GetStarted;
 @FindBy(linkText =  "Time Complexity") WebElement Timecompexity;
 @FindBy(linkText = "Practice Questions") WebElement practiesQuestions;
 
 
	
}
