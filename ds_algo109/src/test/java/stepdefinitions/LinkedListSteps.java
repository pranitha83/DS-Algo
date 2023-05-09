package stepdefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.driversetup;
import PageObjects.HomePage;
import PageObjects.Lnklist;
import PageObjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class LinkedListSteps extends BasePage {

	WebDriver driver = driversetup.getDriver();
	
	String excelpath = ".\\ExcelData/pythoncode.xlsx";

	String expmsg;

	Lnklist linkedlst= new Lnklist(driver);
	
	

	@When("The user selecting linkedlist item from the drop down menu")
	public void the_user_selecting_linkedlist_item_from_the_drop_down_menu() {
		homepage = new HomePage(driver);
		homepage.dropDownclk();
		LoggerLoad.info("Dropdown got clicked");
		homepage.Linkedlstclk();
	}

	@Then("The user should be directed to Linked List Page")
	public void the_user_should_be_directed_to_linked_list_page() {
		LoggerLoad.info("user is in Linked list page");

	}

	@And("The user clicks on {string} link")
	public void the_user_clicks_on_link(String string) {
		 linkedlst = new Lnklist(driver);
		linkedlst.introOfLinkedlist();
		LoggerLoad.info(string + " link got clicked");
	}

	@When("The user clicks {string} button in the {string} page")
	public void the_user_clicks_button_in_the_page(String TryHere, String introduction) {
		linkedlst.tryHereLink();
		LoggerLoad.info(TryHere + " got clicked on " + introduction + " page");
	}

	@Then("The user should be redirected to a page having an tryEditor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test() {
		linkedlst.codeMirrorText();
		linkedlst.clickRunButton();
		String res = linkedlst.codeOutput();
		System.out.println("result = " + res);
	}

	@And("user will navigate back and returns to tryEditor to give invalid python code")
	public void user_will_navigate_back_and_returns_to_try_editor_to_give_invalid_python_code() {
		driversetup.NavBack();
		linkedlst.tryHereLink();
		linkedlst.invalidPythonCode();
		linkedlst.clickRunButton();

	}

	@Then("user will get alert message and accept it")
	public void user_will_get_alert_message_and_accept_it() {
		Alert alt = driver.switchTo().alert();
		alt.accept();
		driversetup.NavBack();
		

	}

	@Given("The user is in a try here page having  tryEditor with a Run button to test")
	public void the_user_is_in_a_try_here_page_having_try_editor_with_a_run_button_to_test() {
		LoggerLoad.info("In tryEditor page");
		linkedlst = new Lnklist(driver);
	}

	@And("user clicks on tryHere button")
	public void user_clicks_on_try_here_button() {
		linkedlst.tryHereLink();
	}

	@When("The user Enter valid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and(String string, Integer row)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User is in TryEditor page of LinkedList Module");
		List<Map<String, String>> testData = reader.getData(excelpath, "Sheet1");
		String pyCode = testData.get(row).get("pythoncode"); // Column heading
		String output = testData.get(row).get("output"); // Column heading
		expmsg = output;
		
		linkedlst.excelPythonCode(pyCode, output);
		LoggerLoad.info("python code being sent");

	}

	@When("user click on Run button")
	public void user_click_on_run_button() {
		linkedlst.clickRunButton();

	}

	@Then("The user should be presented with the Run output")
	public void the_user_should_be_presented_with_the_run_output() {
		String res = linkedlst.codeOutput();
		System.out.println("result = " + res);
		driversetup.NavBack();

	}

	@When("The user Enter invalid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_invalid_python_code_in_try_editor_from_sheet_and(String string, Integer row)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User is in TryEditor page of LinkedList Module");
		List<Map<String, String>> testData = reader.getData(excelpath, "Sheet1");
		String pyCode = testData.get(row).get("pythoncode"); // Column heading
		String output = testData.get(row).get("result"); // Column heading
		expmsg = output;
		
		linkedlst.excelPythonCode(pyCode, output);
		LoggerLoad.info("python code being sent");
	}

	@Then("The user should get Alert message")
	public void the_user_should_get_alert_message() {
		
		Alert alert = driver.switchTo().alert();
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		if (w.until(ExpectedConditions.alertIsPresent()) == null)
			System.out.println("alert not exist");
		else
			System.out.println("Alert exists");
            alert.accept();
            driversetup.NavBack();
	}
	@Given("The user is in Linked List page")
	public void the_user_is_in_linked_list_page() {
		LoggerLoad.info("User is in linked list page");
	    
	}
	@When("The user clicks the {string} a Linked List button")
	public void the_user_clicks_the_a_linked_list_button(String string) {
		linkedlst.createLnkList();
		LoggerLoad.info("User is ready to create Linked list");
	}
	
	@Then("The user should be redirected to tryEditor page with a Run button to test")
	public void the_user_should_be_redirected_to_try_editor_page_with_a_run_button_to_test() {
		linkedlst.tryHereLink();
	}
	
	@When("The user clicks the {string} Linked List hyperlink")
	public void the_user_clicks_the_linked_list_hyperlink(String string) {
	    linkedlst.typesOfLinkedList();
	    LoggerLoad.info("user clicked on types of linked list link");
	}
	@When("The user clicks the {string} link")
	public void the_user_clicks_the_link(String string) {
	    linkedlst.implementLinkedlist();
	    LoggerLoad.info("User can implement linkedlist" );
	}
	@When("The user clicks {string} link")
	public void the_user_clicks_link(String string) {
	   linkedlst.traversalLink();
	   LoggerLoad.info("user is in Traversal Linked list page");
	}
	@When("The user clicks on {string}")
	public void the_user_clicks_on(String string) {
	   linkedlst.insertionLink();
	   LoggerLoad.info("User in insertion linked list page");
	}
	@When("The user clicks the {string} link of {string}")
	public void the_user_clicks_the_link_of(String string, String string2) {
	   linkedlst.deletionLink();
	   LoggerLoad.info("User is in deletion of Linked list");
	}
	@When("The user clicks on to the {string} link")
	public void the_user_clicks_on_to_the_link(String string) {
	    linkedlst.practiceQuestionsLink();
	    LoggerLoad.info("User is in Practice Questions Page");
	}

	@Then("The user should be directed to Practice Questions of Linked List Page")
	public void the_user_should_be_directed_to_practice_questions_of_linked_list_page() {
	    driversetup.NavBack();
	    LoggerLoad.info("User been Navigated back to Main page of LinkedList");
	    
	}

	
}