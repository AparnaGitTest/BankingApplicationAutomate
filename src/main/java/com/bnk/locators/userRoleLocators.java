package com.bnk.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class userRoleLocators {
	
	public String[] linkListManager= {"Manager","New Customer","Edit Customer","Delete Customer",
			"New Account","Edit Account","Delete Account","Deposit","Withdrawal","Fund Transfer",
			"Change Password","Balance Enquiry","Mini Statement","Customised Statement","Log out"};
	
	
	public String[] linkListCustomer= {"Customer","Balance Enquiry","Fund Transfer","Changepassword",
	"Mini Statement","Customised Statement","Log out"};

	@FindBy(xpath="//ul[@class='menusubnav']/li/a")
	public List<WebElement> linkList;
	
	
}
