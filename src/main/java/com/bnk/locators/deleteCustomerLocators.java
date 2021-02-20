package com.bnk.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class deleteCustomerLocators {

	@FindBy(xpath="//input[@name='cusid']")
	public WebElement customerID;
	
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	public WebElement submit;
	
	@FindBy(xpath="//input[@name='res']")
	public WebElement reset;
	
}
