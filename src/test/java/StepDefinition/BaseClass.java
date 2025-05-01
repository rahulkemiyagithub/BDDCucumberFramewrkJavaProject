package StepDefinition;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import PageObject.AddNewBillsPage;
import PageObject.LoginPage;
import PageObject.SearchBillByReceiptNumberPage;
import Utilities.ReadConfigPropertiesFile;

import org.apache.logging.log4j.*;

/*Parent Class*/
public class BaseClass {
	
	
	//Generate unique e-receipt number with 5 length
	public String getRandomNumber()
	{
		return RandomStringUtils.randomAlphanumeric(7);
	}
	
	
	public static WebDriver driver;
	public LoginPage loginPage;
	public AddNewBillsPage addBillsPage;
	public BaseClass baseClass;
	public SearchBillByReceiptNumberPage searchBillByReceiptNo;
	public static Logger log;
	public ReadConfigPropertiesFile readConfig;

}
