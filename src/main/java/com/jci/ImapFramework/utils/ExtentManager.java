package com.jci.ImapFramework.utils;

import java.util.Locale;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.jci.ImapFramework.TestBase.TestBase;

public class ExtentManager extends TestBase {

	private static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			return createInstance("test-output/ImapTestReports.html");
		}
		else
		{
			return extent;
		}
	}
	
	public static ExtentReports createInstance(String filename)
	{
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(filename);
		htmlreporter.config().setTheme(Theme.STANDARD);
		htmlreporter.config().setDocumentTitle(filename);
		htmlreporter.config().setEncoding("utf-8");
		htmlreporter.config().setReportName(filename);
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		Locale.setDefault(Locale.ENGLISH);
		extent.setSystemInfo("Host Name", "Window");
		extent.setSystemInfo("Global id", "ckhobra");
		extent.setSystemInfo("Environment", "Imap Automation Testing");
		extent.setSystemInfo("Project Name", "Imap");
		extent.setSystemInfo("Imap_Version", "8.8.9");
		return extent;
	}
}
