package com.jci.ImapFramework.testscripts;

import org.testng.annotations.Test;

import com.jci.ImapFramework.TestBase.TestBase;

public class TestScreenShot extends TestBase {

	@Test
	public void testScreen()
	{
		driver.get("https://imap-qa.jci.com/#/login");
		captureScreen("FirstScreen", driver);
	}
}
