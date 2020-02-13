package com.jci.ImapFramework.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.jci.ImapFramework.TestBase.TestBase;
import com.jci.ImapFramework.helper.logger.LoggerHelper;
import com.jci.ImapFramework.helper.wait.WaitHelper;

public class LoginPage extends TestBase
{

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	WaitHelper wait;
	
	@FindBy(xpath="//input[@ng-model='LoginData.UserCredentials.UserName']")
	WebElement txt_globalid;
	
	@FindBy(xpath="//input[@ng-model='LoginData.UserCredentials.Password']")
	WebElement txt_password;
	
	@FindBy(id="btnLogin")
	WebElement btn_login;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
		wait.waitforelementvisiblewithpollingtime(btn_login, 15, 5);
		
	}
	
	public void enterGlobalid(String globalid)
	{
		
		txt_globalid.sendKeys(globalid);
		log.info("Entering global id..."+globalid);
		TestBase.logExtendReport("Entering global id...");
	}
	
	public void enterPassword(String password)
	{
		
		txt_password.sendKeys(password);
		log.info("Entering Password..."+password);
		TestBase.logExtendReport("Entering Password...");
	}
	
	public CompressorPage clickLogin()
	{
		
		
		log.info("Clicking on the login button ......");
		TestBase.logExtendReport("Clicking on the login button ......");
		btn_login.click();
		wait.loaderDismiss();
		return new CompressorPage(driver);
	}
	
	public void loginToApplication(String globalid,String password)
	{
		enterGlobalid(globalid);
		enterPassword(password);
		clickLogin();
		
	}
	
	
	
	
	
}
