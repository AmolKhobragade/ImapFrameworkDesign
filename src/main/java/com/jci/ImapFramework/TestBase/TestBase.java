package com.jci.ImapFramework.TestBase;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.jci.ImapFramework.helper.browserconfiguration.BrowserType;
import com.jci.ImapFramework.helper.browserconfiguration.ChromeBrowser;
import com.jci.ImapFramework.helper.browserconfiguration.ObjectReader;
import com.jci.ImapFramework.helper.browserconfiguration.config.PropertyReader;
import com.jci.ImapFramework.helper.logger.LoggerHelper;
import com.jci.ImapFramework.helper.recourse.Recourcehelper;
import com.jci.ImapFramework.helper.wait.WaitHelper;
import com.jci.ImapFramework.utils.ExtentManager;

public class TestBase 

{
	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	private static Logger log = LoggerHelper.getLogger(TestBase.class);
	public static File reportDirectory;
	
	@BeforeSuite
	public void beforeSuite()
	{
		extent = ExtentManager.getInstance();
	}

	@BeforeTest
	public void beforeTest() throws Exception
	{
		ObjectReader.reader=new PropertyReader();
		reportDirectory= new File(Recourcehelper.getRecourcePath("/src/main/recources/ScreenShots"));
		setupDriver(ObjectReader.reader.getBrowserType());
	}
	
	@BeforeClass
	public void beforeClass()
	{
		test = extent.createTest(getClass().getName());
	}

	@BeforeMethod
	public void beforeMethod(Method method)
	{
		test.log(Status.INFO, method.getName() + " Test Case Started ");
	}

	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName() + " is Pass ");
		} else if (result.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP, result.getThrowable());
		}
		extent.flush();
	}
	
	@AfterTest
	public void afterTest() throws Exception
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}

	public WebDriver getBrowserObjects(BrowserType btype) throws Exception
	{

		try 
		{

			switch (btype)
			{
			case Chrome:
				// get object of chrome browser class
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				ChromeOptions option = chrome.getChromeOptions();
				return chrome.getChromeDriver(option);
			

			default:
				
				throw new Exception("Driver not found"+btype.name());
			}

		} 
		catch (Exception e)
		{

			log.info("Driver not found"+e.getMessage());
			throw e;
			
		}
	

	}
	
	public void setupDriver(BrowserType btype) throws Exception
	{
		driver = getBrowserObjects(btype);
		log.info("Intitialize Web driver"+driver.hashCode());
		WaitHelper wait = new WaitHelper(driver);
		wait.setImplicitwait(ObjectReader.reader.getimplicitWait(), TimeUnit.SECONDS);
		wait.pageloadtime(ObjectReader.reader.getpageloadTime(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	public String captureScreen(String filename, WebDriver driver)
	{
		if(driver==null)
		{
			log.info("driver is null...");
			return null;
		}
		if(filename=="")
		{
			filename="blank";
		}
		File destFile =null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File screenFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			destFile=new File(reportDirectory+"/"+filename+"_"+formater.format(calendar.getTime())+".png");
			Files.copy(screenFile.toPath(), destFile.toPath());
			Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src'"+destFile.getAbsolutePath()+"'height='100' width='100'/></a>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filename;
	}
	
	public void getNavigationScreen(WebDriver driver)
	{
		log.info("capturing the UI navigational screen");
		String screen = captureScreen("",driver);
		try
		{
			test.addScreencastFromPath(screen);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void logExtendReport(String logname)
	{
		TestBase.test.log(Status.INFO, logname);
	}
	
	public void getApplicationUrl(String url)
	{
		driver.get(url);
		logExtendReport("Navigating to the url");
	}
}
