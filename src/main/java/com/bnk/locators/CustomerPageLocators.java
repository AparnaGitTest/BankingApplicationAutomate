package com.bnk.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPageLocators {
	
	
	@FindBy(xpath="//*[text()='New Customer']")
	public WebElement newCustomerLink;
	
	@FindBy(xpath="//tr//tr[1]/td/p")
	public WebElement heading;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement submitbtn;
	
	@FindBy(xpath="//input[@type='reset']")
	public WebElement reset;
	
	
	
	@FindBy(xpath="//input[@name='name']/following-sibling::label")
	public WebElement customerNameMessage;
	
	@FindBy(xpath="//textarea[@name='addr']/following-sibling::label")
	public WebElement addressMessage;
	
	

	@FindBy(xpath="//input[@name='name']")
	public WebElement customerName;
	
	@FindBy(xpath="//textarea[@name='addr']")
	public WebElement address;
	

	
	@FindBy(xpath="//input[@name='city']")
	public WebElement city;
	
	@FindBy(xpath="//input[@name='state']")
	public WebElement state;
	
	@FindBy(xpath="//input[@name='pinno']")
	public WebElement pinno;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	public WebElement telephoneno;
	
	@FindBy(xpath="//input[@name='emailid']")
	public WebElement emailid;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@name='dob']")
	public WebElement dob;
	
	@FindBy(xpath="//tr//tr[4]/td[2]")
	public WebElement customerId;
	
	
	@FindBy(xpath="//*[text()='Log out']")
	public WebElement logOut;
	
	@FindBy(xpath="//*[text()='Delete Customer']")
	public WebElement deleteCustomer;
	
	@FindBy(xpath="//input[@name='cusid']")
	public WebElement deletePageCustID;
	
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	public WebElement deletePageSubmit;
	
	
	
	
	
	
	
	
	
	
	

}
