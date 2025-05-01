package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewBillsPage {
	
	public WebDriver localDriver;
	
	//constructor
	public AddNewBillsPage(WebDriver RemoteDriver)
	{
		localDriver = RemoteDriver;
		PageFactory.initElements(RemoteDriver, this);
	}
	
	//Find web elements on the web page
	@FindBy(xpath = "//span[text()='BILLS']")
	WebElement Bills;
	
	@FindBy(linkText = "Add Bills")
	WebElement add_Bills;
	
	@FindBy(xpath = "//h6[contains(text(),'Fill Details')]")
	WebElement fillDetailsPage;
	
	@FindBy(id = "departmentName")
	WebElement selectDepartment;
	
	@FindBy(id = "receipt_no")
	WebElement eoffice_Receipt_Number;
	
	@FindBy(id = "bill_no")
	WebElement bill_Number;
	
	@FindBy(id = "billRev_date")
	WebElement bill_Receiving_Date;
	
	@FindBy(id = "vendor_name")
	WebElement name_Of_Vendor;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	WebElement NextBtn;
	
	@FindBy(xpath = "//h5[contains(text(),'Review Details')]")
	WebElement reviewDetails;
	
	@FindBy(xpath = "//button[contains(text(),'Edit')]")
	WebElement EditBtn;
	
	@FindBy(id = "submitForm")
	WebElement submitFormBtn;
	
	@FindBy(xpath = "(//div[@class='col-md-9'])/h4")
	WebElement submittedSuccessfully;
	
	@FindBy(id = "errDiv")
	WebElement receiptNumberAlreadyAdded;
	
	
	//Perform action on find web elements
	public void mouseOverOnBills()
	{
		Actions action = new Actions(localDriver);
		action.moveToElement(Bills).build().perform();
	}
	
	public void clickOnAddBills()
	{
		add_Bills.click();
	}
	
	public String getTextFillDetailsPage()
	{
		return fillDetailsPage.getText();
	}
	
	public void select_Department_From_Dropdown(String selectDepartmentName)
	{
		Select selectDepart = new Select(selectDepartment);
		selectDepart.selectByVisibleText(selectDepartmentName);
	}
	
	public void enterEOfficeRecepitNumber(String eOfficeRecepitNumber)
	{
		eoffice_Receipt_Number.sendKeys(eOfficeRecepitNumber);
	}
	
	public void enterBillNumber(String billNumber)
	{
		bill_Number.sendKeys(billNumber);
	}
	
	public void enterbillReceivingDate(String billReceivingDate)
	{
		bill_Receiving_Date.sendKeys(billReceivingDate);
	}
	
	public void enterNameOfVendor(String NameOfVendor)
	{
		name_Of_Vendor.sendKeys(NameOfVendor);
	}
	
	public void clickOnNextButton()
	{
		NextBtn.click();
	}
	
	public String getTextOfReviewDetailsPage()
	{
		return reviewDetails.getText();
	}
	
//	public void clickOnEditButton()
//	{
//		EditBtn.click();
//	}
	
	public void clickOnSubmitFormButton()
	{
		submitFormBtn.click();
	}
	
	public String successMasg()
	{
		return submittedSuccessfully.getText();
	}
	
	public String notSucceedMasg()
	{
		return receiptNumberAlreadyAdded.getText();
	}
	
}
