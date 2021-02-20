package com.bnk.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bnk.base.Page;
import com.bnk.locators.linkNavigationLocators;

public class linkNavigation {
	public linkNavigationLocators lnl;
	
	public linkNavigation(WebDriver driver)
	{
		this.lnl=new linkNavigationLocators();
		PageFactory.initElements(driver, this.lnl);
	}
	
	
	
	public newCustomer newCustomerLink()
	{
		lnl.newCustomer.click();
		return new newCustomer();
	}
	

	public editCustomer editCustomerLink()
	{
		lnl.editCustomer.click();
		return new editCustomer();
	}
	
	
	public deleteCustomer deleteCustomerLink()
	{
		lnl.deleteCustomer.click();
		return new deleteCustomer();
	}
	
	
	public WebElement newAccountLink;
	
	
	public WebElement editAccountLink;
	
	
	public WebElement deleteAccountLink;
	
	
	public WebElement depositLink;
	
	
	public WebElement withdrawalLink;
	
	
	public void fundTransferLink()
	{
		Page.click(lnl.fundTransfer);
		
		
		
	}
	

	public WebElement changePasswordLink;
	
	
	public balanceEnquiry balanceEnquiryLink()
	{
		lnl.balanceEnquiry.click();
		return new balanceEnquiry();
	}
	
	
	
	public WebElement miniStatementLink;
	
	
	public customizedStatement customizedStatementLink() {
		lnl.customizedStatement.click();
		return new customizedStatement();
		
	}
	
	
	public void logOutLink()
	{
		lnl.logOut.click();
		Page.driver.switchTo().alert().accept();
	}
	
	

}
