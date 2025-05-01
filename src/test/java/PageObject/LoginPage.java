package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.model.Driver;

public class LoginPage {
	
	WebDriver localDriver;
	
	public LoginPage(WebDriver RemoteDrive)
	{
		localDriver = RemoteDrive;
		
		PageFactory.initElements(RemoteDrive, this);
	}

	
	@FindBy(id = "username")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "sub")
	WebElement LoginBtn;
	
	@FindBy(xpath="//span[@class='font-weight-bold']")
	WebElement profileBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logout;
	
	
	public void enterEmail(String emailAddress)
	{
		username.sendKeys(emailAddress);
	}
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickOnLoginButton()
	{
		LoginBtn.click();
	}
	
	public void clickOnProfileButton()
	{
		profileBtn.click();
	}
	
	public void clickOnLogOutButton()
	{
		logout.click();
	}
	
}
