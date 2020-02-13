package com.jci.ImapFramework.helper.javascript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jci.ImapFramework.TestBase.TestBase;
import com.jci.ImapFramework.helper.logger.LoggerHelper;

public class JavaScriptHelper extends TestBase {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);
	
	
	public JavaScriptHelper(WebDriver driver)
	{
		this.driver=driver;
		log.info("Java script helper has been initialised");
	}
	
	public Object ExecuteScript(String script)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script);
	}
	
	public  Object ExecuteScript(String script,Object...args)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script,args);
		
	}
	
	public void ScrollToElement(WebElement element)
	{
		log.info("Scoll to webelement....");
		ExecuteScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
	}
	
	public void scrollToelelementandclick(WebElement element)
	{
		ScrollToElement(element);
		element.click();
		log.info("Scrolling to the element and Click"+element.toString());
	}
	
	public void scrollIntoview(WebElement element)
	{
		log.info("Scroll till the web element");
		ExecuteScript("arguments[0].scrollIntoView()",element);
	}
	
	public void scrollIntoviewClick(WebElement element)
	{
		scrollIntoview(element);
		element.click();
		ExecuteScript("arguments[0].scrollIntoView()",element);
		log.info("element Click"+element.toString());
	}
	
	public void ScrolldownVertical()
	{
		log.info("Scrolling down page veritcally");
		ExecuteScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void ScrollupVertical()
	{
		log.info("Scrolling up page veritcally");
		ExecuteScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	
	/**
	 * This method is scrolling page down and up using pixel
	 * 
	 */
	public void ScrolldownbyPixel(int pixel)
	{
		ExecuteScript("window.scrollBy(0,"+pixel+")");
	}
	
	public void ScrollupbyPixel(int pixel)
	{
		ExecuteScript("window.scrollBy(0,-"+pixel+")");
		
	}
	
	/**
	 * This method is used to zoom the screen by 100%
	 */
	public void ZoomInBy100Percentage()
	{
		ExecuteScript("document.body.style.zoom='100%'");
	}
	
	/**
	 * This method is used to zoom the screen by 60%
	 */
	public void ZoomInBy60Percentage()
	{
		ExecuteScript("document.body.style.zoom='60%'");
	}
	
	/**
	 * This method is used to click on the any element
	 * this method is used when selenium click is not perform
	 * @param element
	 */
	public void ClickElement(WebElement element)
	{
		ExecuteScript("arguments[0].click();",element);
	}
}
