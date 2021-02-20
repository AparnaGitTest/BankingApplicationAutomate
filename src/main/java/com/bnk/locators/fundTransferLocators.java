package com.bnk.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class fundTransferLocators {
	
	@FindBy(xpath="//input[@name='payersaccount']")
	public WebElement fromAccount;
	
	
	@FindBy(xpath="//input[@name='payeeaccount']")
	public WebElement toAccount;
	

	@FindBy(xpath="//input[@name='ammount']")
	public WebElement amount;
	
	
	@FindBy(xpath="//input[@name='desc']")
	public WebElement description;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	public WebElement submit;
	
	
}
