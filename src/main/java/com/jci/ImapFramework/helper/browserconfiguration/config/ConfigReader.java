package com.jci.ImapFramework.helper.browserconfiguration.config;

import com.jci.ImapFramework.helper.browserconfiguration.BrowserType;

public interface ConfigReader 
{

	public int getimplicitWait();
	public int getexplicitWait();
	public int getpageloadTime();
	public BrowserType getBrowserType();
	public String getUrl();
	public String getUserName();
	public String getPassword();
}
