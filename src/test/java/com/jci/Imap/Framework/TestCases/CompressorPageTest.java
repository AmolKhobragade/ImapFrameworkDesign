package com.jci.Imap.Framework.TestCases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.jci.ImapFramework.PageObject.CompressorPage;
import com.jci.ImapFramework.PageObject.LoginPage;
import com.jci.ImapFramework.TestBase.TestBase;
import com.jci.ImapFramework.helper.browserconfiguration.ObjectReader;
import com.jci.ImapFramework.helper.logger.LoggerHelper;

public class CompressorPageTest extends TestBase
{
	LoginPage loginpage;
	CompressorPage cp;
	private final Logger log = LoggerHelper.getLogger(CompressorPageTest.class);
	
	@Test(priority=1)
	//@Test(description="Login test with valid credential")
	public void testLoginPage()
	{
    	getApplicationUrl(ObjectReader.reader.getUrl());
    	loginpage = new LoginPage(driver);
    	loginpage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
	}
	
	@Test(priority=2)
	//@Test(description="Clicking on the my project icon of the dashboard page")
	public void Verify_clickMyprojectIcon()
	{
		cp = new CompressorPage(driver);
		cp.clickMyproject_icon();
	}
	
	@Test(priority=3)
	//@Test(description="Searching project name using the name search box of My Project page")
	public void Verify_searchProjectname()
	{
		cp = new CompressorPage(driver);
		cp.searchProjectname(2, "RAC PAC 25 July Shared");
	}
	
}
