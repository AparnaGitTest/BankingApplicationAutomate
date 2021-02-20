package com.bnk.actions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.bnk.base.Page;
import com.bnk.locators.fundTransferLocators;

public class fundTransfer extends Page {
	
	public fundTransferLocators ftl;
	public String amountToTransfer;

	public fundTransfer()
	{
		this.ftl=new fundTransferLocators();
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(driver, this.ftl);
		
		
		
	}
	
	public void transferAmount(String fromAccount,String toAccount,String amount,String desc)
	{
		System.out.println(driver.getWindowHandle());
		
		//type(ftl.fromAccount,fromAccount);
		//type(ftl.toAccount,toAccount);
		
		type(ftl.fromAccount,fromAccount);
		type(ftl.toAccount,toAccount);
		type(ftl.amount,amount);
		type(ftl.description,desc);
		click(ftl.submit);
		this.amountToTransfer=amount;
		
	}
}
