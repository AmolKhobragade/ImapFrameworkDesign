package com.jci.ImapFramework.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.jci.ImapFramework.TestBase.TestBase;
import com.jci.ImapFramework.helper.constants.Constant;
import com.jci.ImapFramework.helper.logger.LoggerHelper;
import com.jci.ImapFramework.helper.wait.WaitHelper;

public class CompressorPage extends TestBase
{
	private  WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(CompressorPage.class);
	WaitHelper wait;
	
   @FindBy(xpath="//button[@class='spin circle-dashboard btn-circle allprojects']")
   WebElement icon_Myproject;

   @FindBy(xpath="//input[@ng-model='gridDisplayItem.ProjectId']")
   WebElement project_Id;
   
public CompressorPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	//wait = new WaitHelper(driver);
	//wait.waitforelementvisiblewithpollingtime(icon_Myproject, 15, 5);
}

public void clickMyproject_icon()
{
	log.info("Clicking on the my project icon of dashboard...");
	TestBase.logExtendReport("Clicking on the my project icon of dashboard...");
	icon_Myproject.click();
	
	
}

public void searchProjectname(int projectNameSearchBoxnumber,String projname)
{
	//*[@id='tblUnitList']/thead/tr/th[]/div/div/div[2]/div/input
	//for(int i=1;i<=11;i++)
	//{
		//WebElement ele =driver.findElement(By.xpath("//*[@id='tblUnitList']/thead/tr/th["+i+"]/div/div/div[2]/div/input"));
		//ele.sendKeys(Constant.search_ProjectName);
	//}
	String getprojectidtext = project_Id.getAttribute("value").toString();
	String xpath1="//*[@id='tblProjectList']/thead/tr/th[";
	String xpath2="]/div/div/div[2]/div/input";
	WebElement ele =driver.findElement(By.xpath(xpath1+projectNameSearchBoxnumber+xpath2));
	ele.sendKeys(projname);
	log.info("Entering project name in searchbox.."+projname);
	TestBase.logExtendReport("Entering project name in searchbox..");
	
}

}
