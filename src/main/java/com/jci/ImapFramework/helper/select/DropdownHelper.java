package com.jci.ImapFramework.helper.select;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.jci.ImapFramework.TestBase.TestBase;
import com.jci.ImapFramework.helper.logger.LoggerHelper;

public class DropdownHelper extends TestBase {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(DropdownHelper.class);
	
	
	public DropdownHelper(WebDriver driver)
	{
		this.driver=driver;
		log.info("DropdownHelper object is created");
	}
	
	public void selectUsingValue(WebElement element,String value)
	{
		
		Select select = new Select(element);
		log.info("Select drop down menu using value"+value);
		select.selectByValue(value);
	}
	
	public void selectUsingIndex(WebElement element,int index)
	{
		Select select = new Select(element);
		log.info("Select drop down menu using index"+index);
		select.selectByIndex(index);
	}
	
	public void selectUsingVisibleText(WebElement element,String visibletext)
	{
		Select select = new Select(element);
		log.info("Select drop down menu using VisibleText"+visibletext);
		select.selectByVisibleText(visibletext);
	}
	
	public void deselectUsingValue(WebElement element,String value)
	{
		
		Select select = new Select(element);
		log.info("deSelect drop down menu using value"+value);
		select.deselectByValue(value);
	}
	
	public void deselectUsingIndex(WebElement element,int index)
	{
		Select select = new Select(element);
		log.info("deSelect drop down menu using index"+index);
		select.deselectByIndex(index);
	}
	
	public void deselectUsingVisibleText(WebElement element,String visibletext)
	{
		Select select = new Select(element);
		log.info("deSelect drop down menu using VisibleText"+visibletext);
		select.deselectByVisibleText(visibletext);
	}
	
	public void getFirstSelectedValue(WebElement element)
	{
		Select select = new Select(element);
		log.info("Get first selected or default value");
		select.getFirstSelectedOption();
	}
	
	public void getAllSelectedOption(WebElement element)
	{
		Select select = new Select(element);
		List<WebElement> selectedAllOption = select.getAllSelectedOptions();
		for(WebElement options:selectedAllOption)
		{
			String val = options.getText();
			System.out.println(val);
			log.info(" The all selected value of dropdown menu "+val);
			
		}
	}
		public ArrayList<String> getAllOptions(WebElement element)
		{
			Select select = new Select(element);
			List<WebElement> alloption = select.getOptions();
			ArrayList<String> valuelist = new ArrayList<String>();
			//Either use arraylist or linkedlist
			//LinkedList<String> valuelist = new LinkedList<String>();
			for(WebElement ele: alloption)
			{
				log.info(ele.getText());
				valuelist.add(ele.getText());
			}
			return valuelist;
			
		}
	
}
