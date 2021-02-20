package com.bnk.base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.bnk.actions.linkNavigation;
import com.bnk.locators.linkNavigationLocators;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExtentManager;

public class Page {
	
	
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static linkNavigation allLinks;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static File f;
	public static String custId;
	public ExtentReports rep=ExtentManager.getInstance();
	public static ExtentTest test;
	
	public  static void initConfigurations()
	{
		//if(driver==null)
	//	{
			if(Constants.browser.equals("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\executableFiles\\New folder\\chromedriver.exe");
				driver=new ChromeDriver();
				log.config("Chrome Driver launched!!!");
				
				
			}
			else
			{
				System.setProperty("webdriver.firefox.driver", "D:\\Selenium\\executableFiles\\geckodriver.exe");
				driver=new FirefoxDriver();
				log.info("Firefox Driver launched!!!");
			}
			driver.get(Constants.url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Constants.implicitWait, TimeUnit.SECONDS);
			wait=new WebDriverWait(driver, 10);
			allLinks=new linkNavigation(driver);
			//login();
		//}
		
		
		
	}
	public static void login()
	{
		driver.findElement(By.name("uid")).sendKeys(Constants.username);
		driver.findElement(By.name("password")).sendKeys(Constants.password);
		driver.findElement(By.name("btnLogin")).click();;
		//test.log(LogStatus.INFO, "Manager login Sucessfulll");
		
	}
	
	public static void login(String username,String password)
	{
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();;
		custId=username;
		//test.log(LogStatus.INFO, "Customer login Sucessfulll with username "+username);
		
	}
	
	public static void click(WebElement element)
	{
		element.click();
		//Reporter.log(" Clicking on :"+element.getText());
		test.log(LogStatus.INFO, " Clicking on :" + element.getText());
	}
	public static void type(WebElement element,String value)
	{
		element.sendKeys(value);
		//Reporter.log("Typing in :" + element.getText() + " entered value as " + value);
		test.log(LogStatus.INFO, " Typing in :" + element.getText() + " entered value as " + value);
	}
	
	public static void storeCustomerData(String custId) throws IOException
	{
		Date D=new Date();
		DateFormat format=new SimpleDateFormat("ddMMyyyyhhmmss");
		String dateGenerate=format.format(D);
		f=new File(System.getProperty("user.dir")+custId+dateGenerate+".txt");
		FileWriter fw=new FileWriter(f);
		BufferedWriter writer=new BufferedWriter(fw);
		for(int i=4;i<=13;i++)
		{
			String title=driver.findElement(By.xpath("//tr["+i+"]/td[1]")).getText();
			String value=driver.findElement(By.xpath("//tr["+i+"]/td[2]")).getText();
			writer.write(title);
			writer.write(" : ");
			writer.write(value);
			writer.newLine();
		}
		writer.close();
		//test.log(LogStatus.INFO, "Customer data stored sucessfully for custId:"+custId);
	}
	
	
	
	
	

}
