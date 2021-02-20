package com.bnk.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class linkNavigationLocators {
	
	
	@FindBy(xpath="//a[text()='New Customer']")
	public WebElement newCustomer;
	
	@FindBy(xpath="//a[text()='Edit Customer']")
	public WebElement editCustomer;
	
	@FindBy(xpath="//a[text()='Delete Customer']")
	public WebElement deleteCustomer;
	
	@FindBy(xpath="//a[text()='New Account']")
	public WebElement newAccount;
	
	@FindBy(xpath="//a[text()='Edit Account']")
	public WebElement editAccount;
	
	@FindBy(xpath="//a[text()='Delete Account']")
	public WebElement deleteAccount;
	
	@FindBy(xpath="//a[text()='Deposit']")
	public WebElement deposit;
	
	@FindBy(xpath="//a[text()='Withdrawal']")
	public WebElement withdrawal;
	
	@FindBy(xpath="//a[text()='Fund Transfer']")
	public WebElement fundTransfer;
	
	@FindBy(xpath="//a[text()='Change Password']")
	public WebElement changePassword;
	
	@FindBy(xpath="//a[text()='Balance Enquiry']")
	public WebElement balanceEnquiry;
	
	@FindBy(xpath="//a[text()='Mini Statement']")
	public WebElement miniStatement;
	
	@FindBy(xpath="//a[text()='Customised Statement']")
	public WebElement customizedStatement;
	
	@FindBy(xpath="//a[text()='Log out']")
	public WebElement logOut;
	

}
