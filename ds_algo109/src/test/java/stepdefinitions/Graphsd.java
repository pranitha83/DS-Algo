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
//import PageObjects.GraphPage;
//import PageObjects.HomePage;
import PageObjects.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class Graphsd extends BasePage {
	WebDriver driver = driversetup.getDriver();
	String excelpath = ".\\ExcelData/Pythoncode.xlsx";
	String output="";
	String expmsg;
	String actmsg;
	String windowtitle;
	GraphPage graphpage = new GraphPage(driver);
	Arrays arrays =new Arrays(driver);
	
	@Given("user able to click on dropdown for Graph")
	public void user_able_to_click_on_dropdown_for_graph() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.dropDownclk();
		
		
	}

	@When("user select Graph option")
	public void user_select_graph_option() {
	    homepage.Graphclick();
	}

	@When("user clicks on Graph topic")
	public void user_clicks_on_graph_topic() {
graphpage.graphHomepage();
	}

	@Given("click Try here button and navigate to tryEditor page")
	public void click_try_here_button_and_navigate_to_try_editor_page() {
		//graphpage.Tryhere();
		arrays.TryHere();
	}

	@When("user enter valid python code in tryEditor from sheet {string} and {int}")
	public void user_enter_valid_python_code_in_try_editor_from_sheet_and(String string, Integer int1) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter valid code in Graph");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String pycode=testData.get(int1).get("pythoncode"); // Column heading
		output=testData.get(int1).get("output"); // Column heading

		expmsg=output;
		System.out.println(pycode);
		System.out.println(output);
	
		graphpage.Textarea(pycode,output);
		//arrays.Runbutton();
	}

	@Then("User should be presented with run output")
	public void user_should_be_presented_with_run_output() {
		actmsg=graphpage.output();
		System.out.println(actmsg);
		driver.navigate().back();
	}

	@When("user enter invalid python code in tryEditor from sheet {string} and {int}")
	public void user_enter_invalid_python_code_in_try_editor_from_sheet_and(String string, Integer int1) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter invalid code in Graph");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String pycode=testData.get(int1).get("pythoncode"); // Column heading
		output=testData.get(int1).get("output"); // Column heading

		expmsg=output;
		System.out.println(pycode);
		System.out.println(output);
		graphpage. Textarea(pycode,output);
	}

	@Given("user select graph representations")
	public void user_select_graph_representations() {
		graphpage.ClickgraphRepresentations();
	}

	@Given("user select practice questions from graph")
	public void user_select_practice_questions_from_graph() throws InterruptedException {
		LoggerLoad.info("select practice questions in graph");
		graphpage.ClickpracticeQuestions();		
		
	}

	@Given("user navigate back and sign out from project")
	public void user_navigate_back_and_sign_out_from_project() {
		//driversetup.NavBack();
		login = new LoginPage(driver);
		login.signout();
	}


}
