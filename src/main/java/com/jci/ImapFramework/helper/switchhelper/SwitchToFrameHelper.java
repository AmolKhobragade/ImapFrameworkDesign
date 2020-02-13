package com.jci.ImapFramework.helper.switchhelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jci.ImapFramework.TestBase.TestBase;
import com.jci.ImapFramework.helper.logger.LoggerHelper;


public class SwitchToFrameHelper extends TestBase {

	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(SwitchToFrameHelper.class);
	
	
	public SwitchToFrameHelper(WebDriver driver)
	{
		this.driver=driver;
	}
	
	/**
	 * This method is used to switch the frame using frame index
	 * @param frameindex
	 */
	public void SwithtoFrameusingIndex(int frameindex)
	{
		
		driver.switchTo().frame(frameindex);
		log.info("switch to the "+ frameindex +" frame ");
	}
	
	/**
	 * This method is used to switch the frame using frame name
	 * @param framename
	 */
	public void SwithtoFrameusingframename(String framename)
	{
		
		driver.switchTo().frame(framename);
		log.info("switch to the "+ framename +" frame ");
	}
	
	/**
	 * This method is used to switch the frame using frame web element
	 * @param element
	 */
	public void SwithtoFrameusingelelement(WebElement element)
	{
		
		driver.switchTo().frame(element);
		log.info("switch to the" + element.toString());
	}
}
