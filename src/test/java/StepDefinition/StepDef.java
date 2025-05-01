package StepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AddNewBillsPage;
import PageObject.LoginPage;
import PageObject.SearchBillByReceiptNumberPage;
import Utilities.ReadConfigPropertiesFile;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

/*Child class of BaseClass*/
public class StepDef extends BaseClass {

	@Before
	public void setUp()
	{
		readConfig = new ReadConfigPropertiesFile();
		
		//initialize logger
		log = LogManager.getLogger("StepDef");
		
		//System.out.println("Setup method executed...");
		log.info("Before setup method executed.");
		
		//Launch browser
		String browser = readConfig.getBrowser();
		switch(browser.toLowerCase())
		{
			case "chrome": 
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				break;
				
			case "msedge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				break;
				
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;
			
			default :
				driver = null;
				
		}
	}
	
	
	@Given("User Lauch chrome browser")
	public void user_lauch_chrome_browser() 
	{
		loginPage = new LoginPage(driver);
		addBillsPage = new AddNewBillsPage(driver);
		baseClass = new BaseClass();
		searchBillByReceiptNo = new SearchBillByReceiptNumberPage(driver);
		
		log.info("launched chrome browser.");
	}
	
	@When("User opens URL {string}")
	public void user_opens_url(String OpenURL) 
	{
		driver.get(OpenURL);
		
		log.info("Opened url");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAddress, String password) 
	{
		loginPage.enterEmail(emailAddress);
		loginPage.enterPassword(password);
		
		log.info("EmailAddress and password entered.");
	}

	@When("Click on Login")
	public void click_on_login() 
	{
		loginPage.clickOnLoginButton();
		
		log.info("clicked on login button.");
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) 
	{
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) 
		{
			log.warn("Test Passed : Page title matched.");
			Assert.assertTrue(true);
		} 
		else 
		{
			log.warn("Test Failed : Page title not matched.");
			Assert.assertTrue(false);
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() 
	{
		loginPage.clickOnProfileButton();
		loginPage.clickOnLogOutButton();
		
		log.info("clicked on logout button.");
	}

	@Then("Page Titel should be {string}")
	public void page_titel_should_be(String expectedTitle) 
	{
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle))
		{
			log.warn("Test Passed : Page title matched.");
			Assert.assertTrue(true);
		}
		else
		{
			log.warn("Test Failed : Page title not matched.");
			Assert.assertTrue(false);
		}
	}

	/*@Then("Close browser")
	public void close_browser() 
	{
		driver.close();
		//driver.quit();
		log.info("browser closed.");
	}*/
	

	///////////////////////// Add Bills/////////////////////////////////

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() 
	{
		String actualTitle = driver.getTitle();
		String expectedTitle = "Invoice Management System";

		if (actualTitle.equals(expectedTitle)) 
		{
			log.warn("Test Passed : User can view dashboard page title matched.");
			Assert.assertTrue(true);
		} 
		else 
		{
			log.warn("Test Failed : User can view dashboard page title not matched.");
			Assert.assertTrue(false);
		}
	}

	@Then("Click on Bills")
	public void click_on_bills() 
	{
		addBillsPage.mouseOverOnBills();

		log.info("clicked on bills.");
	}

	@Then("Click on Add Bills")
	public void click_on_add_bills() throws InterruptedException 
	{
		Thread.sleep(2000);
		addBillsPage.clickOnAddBills();
		
		log.info("clicked on add bill.");
	}

	@Then("User can view Fill Details page under Add Bills as {string}")
	public void user_can_view_fill_details_page_under_add_bills_as(String TextOfFillDeatailsPage) 
	{
		String actualText = addBillsPage.getTextFillDetailsPage();
		String expectedText = "Fill Details";

		if (actualText.equals(expectedText)) 
		{
			log.warn("Test Passed : User can view Fill Details page under Add Bills.");
			Assert.assertTrue(true);
		} 
		else 
		{
			log.warn("Test Failed : User can not view Fill Details page under Add Bills.");
			Assert.assertTrue(false);
		}
	}

	@When("User enter bill info")
	public void user_enter_bill_info() 
	{
		addBillsPage.select_Department_From_Dropdown("Technology");
		addBillsPage.enterEOfficeRecepitNumber(baseClass.getRandomNumber());
		addBillsPage.enterBillNumber("Test123");
		addBillsPage.enterbillReceivingDate("02/18/2025");
		addBillsPage.enterNameOfVendor("Test121234");
		
		log.info("User entered all the bill info.");
	}

	@When("Click on Next button")
	public void click_on_next_button() 
	{
		addBillsPage.clickOnNextButton();
		
		log.info("Clicked on next button.");
	}

	@Then("User can view pop-up window form as {string}")
	public void user_can_view_pop_up_window_form_as(String TextOfReviewDetailsPage) throws InterruptedException 
	{
		Thread.sleep(2000);
		String actualTextOfReviewDetailsPage = addBillsPage.getTextOfReviewDetailsPage();
		String expectedTextOfReviewDetailsPage = "Review Details";

		if (actualTextOfReviewDetailsPage.equals(expectedTextOfReviewDetailsPage)) 
		{
			log.warn("Test Passed : User can view pop-up window form as Review Details.");
			Assert.assertTrue(true);
		} 
		else 
		{
			log.warn("Test Failed : User can not view pop-up window form as Review Details.");
			Assert.assertTrue(false);
		}

	}

	@Then("User click on Submit button")
	public void user_click_on_submit_button() 
	{
		addBillsPage.clickOnSubmitFormButton();
		log.info("Clicked on submit button.");
	}

	@Then("User click on Edit button")
	public void user_click_on_edit_button() 
	{

	}
	
	
	@Then("User can view confirmation Success message1 as {string}")
	public void user_can_view_confirmation_Success_message1_as(String expectedSuccessMsg1) 
	{
		String actualConfMessage1 = addBillsPage.successMasg();
		if (actualConfMessage1.equals(expectedSuccessMsg1)) 
		{
			log.warn("Test Passed : User can view confirmation Success message1 as matched.");
			Assert.assertTrue(true);
		} 
		else 
		{
			log.warn("Test Failed : User can not view confirmation Success message1 as matched.");
			Assert.assertTrue(false);
		}
	}
	
	/*@Then("User can view confirmation not Success message2 as {string}")
	public void user_can_view_confirmation_not_Success_message2_as(String expectedNotSuccessMsg2) 
	{
		String actualConfMessage2 = addBillsPage.notSucceedMasg();
		if (actualConfMessage2.equals(expectedNotSuccessMsg2)) 
		{
			Assert.assertTrue(true);
		} 
		else 
		{
			Assert.assertTrue(false);
		}
	}*/
	
	
	/////////////////////////// Search Bill By Receipt Number /////////////////////////////////
	
	@Then("Click on View & Update Bills")
	public void click_on_view_update_bills() 
	{
		searchBillByReceiptNo.clickOnViewUpdateBills();
		
		log.info("Clicked on view & updated bills.");
	}

	@Then("Enter Receipt Number")
	public void enter_receipt_number() 
	{
		searchBillByReceiptNo.enterReceiptNumber("qwerty");
		
		log.info("Entered receipt number on the search page.");
	}

	@When("Click on Search button")
	public void click_on_search_button() 
	{
		searchBillByReceiptNo.clickOnSearchButton();
		
		log.info("Clicked on search button.");
	}

	@Then("User should found Receipt Number in the Search table")
	public void user_should_found_receipt_number_in_the_search_table() throws InterruptedException 
	{
	   Thread.sleep(2000);
	   String expectedEReceiptNo = "Qe4MO";
	   //Assert.assertTrue(searchBillByReceiptNo.searchBillByReceiptNumber(expectedEReceiptNo));
	   
	   if(searchBillByReceiptNo.searchBillByReceiptNumber(expectedEReceiptNo) == true)
	   {
		   log.warn("Test Passed : User should found Receipt Number in the Search table.");
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   log.warn("Test Failed : User should not found Receipt Number in the Search table.");
		   Assert.assertTrue(false);
	   }
	   
	}

	/////////////////////////// Search Bill By Department Name and Status of Bill /////////////////////////////////
	
	@Then("Select department name from dropdown menu")
	public void select_department_name_from_dropdown_menu() 
	{
		searchBillByReceiptNo.selectDepartmentName("e-Mobility");
		
		log.info("Selected department from dropdown as e-Mobility.");
	}

	@Then("Select status of bill from dropdown menu as {string}")
	public void select_status_of_bill_from_dropdown_menu_as(String expectedBillStatus) 
	{
		searchBillByReceiptNo.selectBillStatus("In-Process");
		
		log.info("Selected status of bill from dropdown menu as In-Process.");
	}

	@Then("User should found Name in the search table")
	public void user_should_found_name_in_the_search_table() throws InterruptedException 
	{
		Thread.sleep(3000);
		   String expectedDepartmentName = "e-Mobility";
		   
		   if(searchBillByReceiptNo.searchBillByDepartmentName(expectedDepartmentName) == true)
		   {
			   log.warn("Test Passed : Department name founded in the search table as e-Mobility.");
			   Assert.assertTrue(true);
		   }
		   else
		   {
			   log.warn("Test Failed : Department name not founded in the search table as e-Mobility.");
			   Assert.assertTrue(false);
		   }
	}
	
	
	//@After()
	public void tearDown(Scenario sc) throws IOException
	{
		System.out.println("teardown-sanity method executed...");
		
		if(sc.isFailed() == true)
		{
			//Convert web driver object to TakesScreeshot
			String fileWithPath = "C:\\Users\\CSCSPV868\\eclipse-workspace\\CS_AutomationFramework\\BDDCucumberJavaProject\\Screenshot\\failedScreenshot.png";
			
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			
			//Call getScreesnshotAs method to create image file
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
			
			//Move image file to new destination
			File destiFile = new File(fileWithPath);
			
			//Copy file at Destination
			FileUtils.copyFile(srcFile, destiFile);
	
		}
		driver.quit();
	
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario)
	{

		if(scenario.isFailed())
		{
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				
			//attach image file report(data, media type, name of the attachment)
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		
	}		
	
	
	/*@After()
	public void tearDown2()
	{
		System.out.println("teardown-regression method executed...");
		
		driver.quit();
		
	}*/
	
	/*@BeforeStep
	public void beforeStepMethod()
	{
		System.out.println("This is before step method.............");
	}
	
	@AfterStep
	public void afterStepMethod()
	{
		System.out.println("This is after step method.........");
	}*/
	
		

}
