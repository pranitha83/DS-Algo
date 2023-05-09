package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepdefinitions.BasePage;
import utilities.LoggerLoad;

public class HomePage extends BasePage {
	@FindBy(xpath="//div[@class='nav-item dropdown']/a") WebElement dropdownele;
	@FindBy (xpath="//a[text()='Arrays']") WebElement arraysele;

	@FindBy (xpath="//a[text()='Linked List']")	WebElement linkedlistele;

	@FindBy (xpath="//a[text()='Stack']") WebElement stackele;

	@FindBy (xpath="//a[text()='Queue']") WebElement queueele;

	@FindBy (xpath="//a[text()='Tree']") WebElement treeele;

	@FindBy (xpath="//a[text()='Graph']") WebElement graphele;

	//@FindBy (className="alert alert-primary")WebElement alertele;
	@FindBy(xpath="//div[@role='alert']")WebElement alertele;
	@FindBy (xpath = "//h5[text()='Array']/..//a") WebElement moduleele;

	//constructor of the homepage

	public  HomePage(WebDriver driver) {
		//this.driver=driver;
		LoggerLoad.info("enter homepage feature");
		PageFactory.initElements(driver,this);
		driver.switchTo().window(driver.getWindowHandle());
		//PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);

	}
	public void getstartedbtn() {
		//driver.switchTo().activeElement();
		//getstarted.click();
	}
	public void dropDownclk() {
		
		LoggerLoad.info("enter dropdownclk");
		dropdownele.click();
	}
	public void arrays() {
		LoggerLoad.info("enter arrayselection");
		arraysele.click();
	}
	public String alert() {
		return alertele.getText();
	}
	public void modulegtstarted() {
		moduleele.click();
	}
	public void Linkedlstclk() {
		linkedlistele.click();
	}
	public void treemod() {
		treeele.click();
	}
	public void selectqueue() {
		queueele.click();
		
	}
	public void Graphclick() {
		graphele.click();
	}
}
