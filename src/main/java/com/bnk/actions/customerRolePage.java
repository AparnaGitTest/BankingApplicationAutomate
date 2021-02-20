package com.bnk.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bnk.base.Page;
import com.bnk.locators.customerRolePageLocators;

public class customerRolePage extends Page {
	
	public static int balAmount=0;
	public Select select;
	public customerRolePageLocators ctl;
	public static HashMap<String, String> maps;
	public static List<HashMap<String, String>> list;
	
	
	public customerRolePage()
	{
		this.ctl=new customerRolePageLocators();
		PageFactory.initElements(driver,this.ctl);
	
		list=new ArrayList();
		
	}
	 
	public void fetchBalanceAmount(String accountNumber)
	{
		maps=new HashMap<String,String>();

		Page.allLinks.balanceEnquiryLink();
		select=new Select(ctl.selectAccount);
		select.selectByVisibleText(accountNumber);
		ctl.submitBalEnquiry.click();
		balAmount=Integer.parseInt(ctl.balanceAmount.getText());
		maps.put("CustomerId", Page.custId);
		maps.put("Account Number",accountNumber);
		maps.put("balance", ctl.balanceOnBalanceEnquiry.getText());
		
		list.add(maps);
	}
	
	public int getActualBalance(String custId)
	{
		 int balance = 0;
		for(int i=0;i<list.size();i++)
		{
			String customerID=list.get(i).get("CustomerId");
			if(customerID.equalsIgnoreCase(custId))
			{
				balance=Integer.parseInt(list.get(i).get("balance"));
			}
			
		}
		return balance;
	}
	
	
	
	 

	
}
