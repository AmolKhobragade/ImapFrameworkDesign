package com.jci.ImapFramework.helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.jci.ImapFramework.TestBase.TestBase;
import com.jci.ImapFramework.helper.recourse.Recourcehelper;



public class LoggerHelper extends TestBase
{

	private static boolean root = false;
	
	public static Logger getLogger(Class cls)
	{
		if(root)
		{
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure(Recourcehelper.getRecourcePath("/src/main/recources/configfile/log4j.properties"));
	    root=true;
	   return Logger.getLogger(cls);
	}
	public static void main(String[] args) {
		Logger log = LoggerHelper.getLogger(LoggerHelper.class);
		log.info("Logger is configured");
		log.info("Logger is configured2");
		
	}
	
}
