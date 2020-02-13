package com.jci.ImapFramework.helper.browserconfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.jci.ImapFramework.TestBase.TestBase;
import com.jci.ImapFramework.helper.recourse.Recourcehelper;

public class ChromeBrowser extends TestBase
{

	public ChromeOptions getChromeOptions()
	{
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--test-type");
		Options.addArguments("--disable-popup-blocking");
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		Options.setCapability(ChromeOptions.CAPABILITY, chrome);
		//Linux
		if(System.getProperty("os.name").contains("Linux"))
		{
			Options.addArguments("--headless","window-size=1024,768","--no-sandbox");
		}
		return Options;
	}
	
	public WebDriver getChromeDriver(ChromeOptions cap)
	{
		
		if(System.getProperty("os.name").contains("Window"))
		{
			System.setProperty("webdriver.chrome.driver", Recourcehelper.getRecourcePath("/src/main/recources/drivers/chromedriver.exe"));
			return new ChromeDriver(cap);
		}
		
			return null;
		}
	}

