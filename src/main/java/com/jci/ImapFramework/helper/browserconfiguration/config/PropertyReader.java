package com.jci.ImapFramework.helper.browserconfiguration.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.jci.ImapFramework.helper.browserconfiguration.BrowserType;
import com.jci.ImapFramework.helper.recourse.Recourcehelper;

public class PropertyReader implements ConfigReader {

	private static FileInputStream file;
	public static Properties OR;

	public PropertyReader() {
		
		try {
			String filepath = Recourcehelper.getRecourcePath("/src/main/recources/configfile/config.properties");
			file = new FileInputStream(new File(filepath));
			OR = new Properties();
			OR.load(file);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public int getimplicitWait() {
		return Integer.parseInt(OR.getProperty("implicitwait"));
	}

	@Override
	public int getexplicitWait() {
		return Integer.parseInt(OR.getProperty("explicitwait"));
	}

	@Override
	public int getpageloadTime() {
		return Integer.parseInt(OR.getProperty("pageloadtime"));
	}

	@Override
	public BrowserType getBrowserType() {
		return BrowserType.valueOf(OR.getProperty("browserType"));
	}

	@Override
	public String getUrl() 
	{
		if(System.getProperty("url")!=null)
		{
			return System.getProperty("url");
		}
		return OR.getProperty("applicationUrl");
	}

	@Override
	public String getUserName() 
	{
		
		if(System.getProperty("userName")!=null)
		{
			return System.getProperty("userName");
		}
		return OR.getProperty("userName");
	}

	@Override
	public String getPassword()
	{
		if(System.getProperty("password")!=null)
		{
			return System.getProperty("password");
		}
		return OR.getProperty("password");
	}

}
