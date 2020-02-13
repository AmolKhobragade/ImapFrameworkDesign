package com.jci.ImapFramework.helper.recourse;

import com.jci.ImapFramework.TestBase.TestBase;

public class Recourcehelper extends TestBase{

	/**
	 * This is path for log4j properties file
	 * @param path
	 * @return
	 */
	public static String getRecourcePath(String path)
	{
		String basePath=System.getProperty("user.dir");
		return basePath+path;
	}
	public static void main(String[] args) {
		String path=Recourcehelper.getRecourcePath("/src/main/recources/configfile/log4j.properties");
		System.out.println(path);
	}
}
