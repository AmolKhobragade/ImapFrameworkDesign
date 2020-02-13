package com.jci.Imap.Framework.TestCases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.jci.ImapFramework.PageObject.LoginPage;
import com.jci.ImapFramework.TestBase.TestBase;
import com.jci.ImapFramework.helper.browserconfiguration.ObjectReader;
import com.jci.ImapFramework.helper.logger.LoggerHelper;

public class LoginPageTest extends TestBase
{

	private final Logger log = LoggerHelper.getLogger(LoginPageTest.class);
	
    @Test(description="Login test with valid credential")
	public void testLoginPage()
	{
    	getApplicationUrl(ObjectReader.reader.getUrl());
    	LoginPage loginpage = new LoginPage(driver);
    	loginpage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
	}
}
