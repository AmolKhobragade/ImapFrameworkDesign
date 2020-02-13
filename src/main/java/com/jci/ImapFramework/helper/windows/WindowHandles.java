package com.jci.ImapFramework.helper.windows;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.jci.ImapFramework.TestBase.TestBase;
import com.jci.ImapFramework.helper.logger.LoggerHelper;

public class WindowHandles extends TestBase{

	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(WindowHandles.class);
	
	public WindowHandles(WebDriver driver)
	{
		this.driver=driver;
	}
	/**
	 * This method is used to switch the parent window
	 */
	public void SwitchtoParentWindow()
	{
		log.info("Switching to parent window");
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used when multiple windows or tabs are opened
	 * and we want to switch to the particular window
	 * @param index
	 */
	
	public void SwitchTowindow(int index)
	{
		
		Set<String> window = driver.getWindowHandles();
		int i=1;
		for(String windows:window)
		{
			if(i==index)
			{
				log.info("switched to :"+index+"window");
				driver.switchTo().window(windows);
			}
			else
			{
				i++;
			}
		}
		
	}
	
	
	/**
	 * This method is used when multiple window or single windows is opened
	 * then closing the all windows one by one and switching to the main window or tab
	 */
	public void closealltabsandswitchtomainwindow()
	{
		Set<String> window = driver.getWindowHandles();
		String mainwindow = driver.getWindowHandle();
		for(String windows:window)
		{
			if(!windows.equalsIgnoreCase(mainwindow))
			{
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		log.info("switched to main window");
	}
	
	/**
	 * This method is used to navigate back
	 */
	public void NavigateBack()
	{
		log.info("Navigating to the back page");
		driver.navigate().back();
	}
	
	
	/**
	 * This method is used to navigate forward
	 */
	public void NavigateForward()
	{
		log.info("Navigating to the forward page");
		driver.navigate().forward();
	}
	
}
