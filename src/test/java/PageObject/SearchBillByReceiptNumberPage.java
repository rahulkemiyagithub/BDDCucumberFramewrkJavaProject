package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchBillByReceiptNumberPage {
	
	public WebDriver localDriver;
	
	//Constructor
	public SearchBillByReceiptNumberPage(WebDriver RemoteDriver)
	{
		localDriver = RemoteDriver;
		PageFactory.initElements(RemoteDriver, this);
	}
	
	
	//Find WebElements on web page
	
	@FindBy(xpath = "//a[contains(text(),'View & Update Bills')]")
	WebElement View_Update_Bills;
	
	@FindBy(name = "searchText")
	WebElement searchTextByReceiptNo;
	
	@FindBy(id = "searchButton")
	WebElement searchBtn;
	
	@FindBy(xpath = "//div[@role='tabpanel']")
	WebElement searchResult;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr")
	List<WebElement> tableRows;
	
	/*@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[1]/td")
	List<WebElement> tableColumns;*/
	
	@FindBy(name = "department")
	WebElement departmentName;
	
	@FindBy(name = "status")
	WebElement billStatus;
	
	
	//Perform Actions on Find WebElements 
	public void clickOnViewUpdateBills()
	{
		View_Update_Bills.click();
	}
	
	public void enterReceiptNumber(String eReceiptNumber)
	{
		searchTextByReceiptNo.sendKeys(eReceiptNumber);
	}
	
	public void clickOnSearchButton()
	{
		searchBtn.click();
	}
	
	public boolean searchBillByReceiptNumber(String expectedReceiptNumber)
	{
		boolean found = false;
		
		//total no. of rows in a grid
		int ttlRows = tableRows.size();
		
		//total no. of columns
		//int ttlColumns = tableColumns.size();
		
		for(int i=1; i<=ttlRows; i++)
		{
			WebElement webElementReceiptNumber = localDriver.findElement(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr["+ i +"]/td[4]"));
			
			String actualReceiptNumber = webElementReceiptNumber.getText();
			
			if(actualReceiptNumber.equals(expectedReceiptNumber));
			{
				found = true;
			}
				
		}
		return found;
	}
	
	/////////////////////Search Bill By Department Name///////////////////////////////
	
	public void selectDepartmentName(String getDepartmentName)
	{
		Select select = new Select(departmentName);
		select.selectByVisibleText(getDepartmentName);
		
	}
	
	public void selectBillStatus(String getBillStatus)
	{
		Select select = new Select(billStatus);
		select.selectByVisibleText(getBillStatus);
		
	}
	
	
	public boolean searchBillByDepartmentName(String expectedDepartmentName)
	{
		boolean found = false;
		
		//total no. of rows in a grid
		int ttlRows = tableRows.size();
		
		//total no. of columns
		//int ttlColumns = tableColumns.size();
		
		for(int i=1; i<=ttlRows; i++)
		{
			WebElement webElementDepartmentName = localDriver.findElement(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr["+ i +"]/td[2]"));
			
			String actualDepartmentName = webElementDepartmentName.getText();
			
			if(actualDepartmentName.equals(expectedDepartmentName));
			{
				found = true;
			}
				
		}
		return found;
	}
	
}
