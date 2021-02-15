package com.bnk.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static leftMenuList lml;
	
	public  static void initConfigurations()
	{
		if(driver==null)
		{
			if(Constants.browser.equals("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\executableFiles\\New folder\\chromedriver.exe");
				driver=new ChromeDriver();
				
			}
			else
			{
				System.setProperty("webdriver.firefox.driver", "D:\\Selenium\\executableFiles\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
			driver.get(Constants.url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Constants.implicitWait, TimeUnit.SECONDS);
			wait=new WebDriverWait(driver, 10);
			lml=new leftMenuList();
			login();
		}
		
		
		
	}
	public static void login()
	{
		driver.findElement(By.name("uid")).sendKeys(Constants.username);
		driver.findElement(By.name("password")).sendKeys(Constants.password);
		driver.findElement(By.name("btnLogin")).click();;
		
	}
	
	public static void login(String username,String password)
	{
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();;
		
	}
	
	public static void click(WebElement locator)
	{
		locator.click();
	}
	
	
	
	
	

}
