package com.jci.ImapFramework.helper.assertions;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.jci.ImapFramework.TestBase.TestBase;
import com.jci.ImapFramework.helper.logger.LoggerHelper;

public class AssertionHelper extends TestBase {

	
	private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);
	
	public static void makeText(String text1,String text2)
	{
		log.info(" Verifying test "+text1+" with "+text2);
		Assert.assertEquals(text1, text2);
	}
	
	public static void makeTrue()
	{
		log.info("making script is pass");
		Assert.assertTrue(true);
	}
	
	public static void makeTrue(String Message)
	{
		log.info("making script is Pass"+Message);
		Assert.assertTrue(true,Message);
	}
	
	public static void makeFalse()
	{
		log.info("making script is Fail");
		Assert.assertTrue(false);
	}
	
	public static void makeFalse(String Message)
	{
		log.info("making script is Fail"+Message);
		Assert.assertTrue(false,Message);
	}
	
	public static void VerifyTrue(boolean status)
	{
		Assert.assertTrue(status);
	}
	
	public static void VerifyFalse(boolean status)
	{
		Assert.assertFalse(status);
	}
	
	public static void VerifyNull(String status)
	{
		log.info("Verifying object is null");
		Assert.assertNull(status);
	}
	
	
	public static void VerifyNotNull(String status)
	{
		log.info("Verifying object is Notnull");
		Assert.assertNotNull(status);
	}
}
