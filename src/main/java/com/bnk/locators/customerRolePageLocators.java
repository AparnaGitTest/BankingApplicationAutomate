package com.bnk.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class customerRolePageLocators {
	
	@FindBy(xpath="//select")
	public WebElement selectAccount;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	public WebElement submitBalEnquiry;
	

	@FindBy(xpath="(//td)[8]")
	public WebElement balanceAmount;
	
	@FindBy(xpath="//tr[16]/td[2]")
	public WebElement balanceOnBalanceEnquiry;
	
	
	

}
