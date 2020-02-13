package com.jci.ImapFramework.helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jci.ImapFramework.TestBase.TestBase;
import com.jci.ImapFramework.helper.logger.LoggerHelper;

public class WaitHelper extends TestBase {
    private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver)
	{
		this.driver=driver;
		log.info("WaitHelper object created");
	}
	
	/**
	 * This wait is implicit wait
	 * @param timeout
	 * @param timeunit
	 */
	public void setImplicitwait(long timeout,TimeUnit timeunit)
	{
		log.info("Implicitwait has been set to "+timeunit);
		driver.manage().timeouts().implicitlyWait(timeout, timeunit);
		
	}
	
	/**
	 * This will help us to get webdriver object
	 * @param timeoutsec
	 * @param pollingeverysec
	 * @return
	 */
	private WebDriverWait getwait(int timeoutsec,int pollingeverysec)
	{
		WebDriverWait wait=new  WebDriverWait(driver,timeoutsec);
		wait.pollingEvery(Duration.ofSeconds(pollingeverysec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
		
	}
	
	/**
	 * This method is used to check the visibility of element
	 * @param element
	 * @param timeoutsec
	 * @param pollingeverysec
	 */
	public void  waitforelementvisiblewithpollingtime(WebElement element,int timeoutsec,int pollingeverysec)
	{
		log.info("Waiting for :"+element.toString()+" for : "+timeoutsec+"seconds");
		WebDriverWait wait = getwait(timeoutsec, pollingeverysec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now");
	}
	
	
	/**
	 * This method is used to wait until the element is clickable
	 * @param element
	 * @param timeoutsec
	 */
	public void  waitforelementtobeclickable(WebElement element,int timeoutsec)
	{
		log.info("Waiting for :"+element.toString()+" for : "+timeoutsec+"seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeoutsec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("element is Clickable now");
	}
	
	/**
	 * This method is used for to invisible of element 
	 * like loader
	 * @param element
	 * @param timeoutsec
	 * @return
	 */
	public boolean waitforelementtobedisappear(WebElement element,long timeoutsec)
	{
		log.info("Waiting for :"+element.toString()+" for : "+timeoutsec+"seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeoutsec);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("element is disappear now");
		return status;
	}
	
	
	/**
	 * This method is used to check the frame and switch to the frame
	 * @param element
	 * @param timeoutsec
	 */
	public void waitforframeToBeAvailableAndSwitchToIt(WebElement element,long timeoutsec)
	{
		log.info("Waiting for :"+element.toString()+" for : "+timeoutsec+"seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeoutsec);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("frame is available and switched to it now");
		
	}
	
	/**
	 * This method is give us fluent wait object
	 * @param timeoutinsecond
	 * @param pollingeverymillisec
	 * @return
	 */
	private Wait<WebDriver> fluentWait(int timeoutinsecond,int pollingeverymillisec)
	{
		Wait<WebDriver>fluent = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeoutinsecond))
				.pollingEvery(Duration.ofMillis(pollingeverymillisec))
				.ignoring(NoSuchElementException.class)
				.ignoring(WebDriverException.class)
				.ignoring(TimeoutException.class)
				.ignoring(NullPointerException.class);
		return fluent;
	}
	
	/**
	 * This method is used for element is selected or not
	 * using fluent wait
	 * @param element
	 * @param timeoutinsecond
	 * @param pollingeverymillisec
	 * @return 
	 */
	public boolean waitForElement(WebElement element,int timeoutinsecond,int pollingeverymillisec)
	{
		Wait<WebDriver> fwait = fluentWait(timeoutinsecond, pollingeverymillisec);
		boolean status = fwait.until(ExpectedConditions.elementToBeSelected(element));
		return status;
	}
	
	/**
	 * This method is used for to get the page loaded
	 * @param timeout
	 * @param unit
	 */
	public void pageloadtime(int timeout,TimeUnit unit)
	{
		try
		{
			log.info("waiting for page to load for :"+unit+"seconds");
			driver.manage().timeouts().pageLoadTimeout(timeout, unit);
			log.info("Page is loaded completely");
		}
		catch (TimeoutException e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void loaderDismiss()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page_loader")));
		
	}
	
	
}
