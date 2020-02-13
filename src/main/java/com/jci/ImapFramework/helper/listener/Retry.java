package com.jci.ImapFramework.helper.listener;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.jci.ImapFramework.helper.logger.LoggerHelper;

public class Retry implements IRetryAnalyzer
{

private int retrycount=0;
private int maxretrycount=3;

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(IRetryAnalyzer.class);
	
	public boolean retry(ITestResult arg0) 
	{
		if(retrycount<maxretrycount)
		{
			log.info(" Retrying test " +arg0.getName()+" with a status "+getresultstatusname(arg0.getStatus())+" For the "+(retrycount+1)+" times ");
			retrycount++; 
		    return true;
			
	    }
            return false;
}
	public String getresultstatusname(int status)
	{
		String resultname=null;
		if(status==1)
		{
			resultname="SUCCESS";
		}
		if(status==2)
		{
			resultname="FAILURE";
		}
		if(status==3)
		{
			resultname="SKIP";
		}
		return resultname;
	}
	
}
