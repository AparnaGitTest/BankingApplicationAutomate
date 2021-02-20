package com.bnk.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bnk.base.Page;
import com.bnk.locators.userRoleLocators;

public class userRole extends Page {
	public userRoleLocators url;
	
	
	public userRole()
	{
		this.url=new userRoleLocators();
		PageFactory.initElements(driver, this.url);
	}
	
	
	
	public void noOfLinks(String roleName)
	{
		int size=url.linkList.size();
		if(roleName.equalsIgnoreCase("Manager"))	
		{
			Assert.assertEquals(15, size);
		}
		else if(roleName.equalsIgnoreCase("Customer"))
		{
			Assert.assertEquals(7, size);
		}

		
	}
	public void linkNameVerify(String roleName)
	{
		List<WebElement> listNames=url.linkList;
		List<String> listNameFetched=new ArrayList<String>();
		
		for(WebElement i:listNames)
		{
			
			listNameFetched.add(i.getText());
		}
		if(roleName.equalsIgnoreCase("Manager"))
		{
			List al=Arrays.asList(url.linkListManager);
			Assert.assertEquals(listNameFetched,al);
		}else if(roleName.equalsIgnoreCase("Customer"))
		{
			List al=Arrays.asList(url.linkListCustomer);
			Assert.assertEquals(listNameFetched, al);
		}
		
	}
	
	

}
