package com.jci.ImapFramework.helper.assertions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jci.ImapFramework.TestBase.TestBase;
import com.jci.ImapFramework.helper.logger.LoggerHelper;

public class VerificationHelper extends TestBase{

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(VerificationHelper.class);
	
	public VerificationHelper(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public boolean isDisplayed(WebElement element)
	{
		try
		{
			element.isDisplayed();
			log.info("element is Displayed"+element.getText());
			return true;
		}
		catch(Exception e)
		{
		log.error("element is not Displayed",e.getCause());
		return false;
		}
	}
	
	public boolean isnotDisplayed(WebElement element)
	{
		try
		{
			element.isDisplayed();
			log.info("element is Displayed..."+element.getText());
			return false;
		}
		catch(Exception e)
		{
		log.error("element is not Displayed..."+element);
		return true;
		}
	}
	
	public String getText(WebElement element)
	{
		if(null==element)
		{
			
		log.info("WebElement is null...");
		return null;
		}
		
		boolean status = isDisplayed(element);
		if(status)
		{
			log.info("Element text is...."+element.getText());
			return element.getText();
		}
		else
		{
			return null;
		}
	}
	
	public String getTitle()
	{
		log.info("Page title is: "+driver.getTitle());
		return driver.getTitle();
	}
	
}
