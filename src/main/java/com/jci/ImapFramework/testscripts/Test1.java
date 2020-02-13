package com.jci.ImapFramework.testscripts;

import org.testng.annotations.Test;

import com.jci.ImapFramework.TestBase.TestBase;
import com.jci.ImapFramework.helper.assertions.AssertionHelper;

public class Test1  extends TestBase{

	@Test
	public void testLogin()
	{
		AssertionHelper.makeTrue();
	}
	
	@Test
	public void testLogin1()
	{
		AssertionHelper.makeFalse();
	}
	
	@Test
	public void testLogin2()
	{
		AssertionHelper.makeTrue();
	}
	
	@Test
	public void testLogin3()
	{
		AssertionHelper.makeFalse();
	}
	
	@Test
	public void testLogin4()
	{
		AssertionHelper.makeTrue();
	}
}
