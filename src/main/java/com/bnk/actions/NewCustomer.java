package com.bnk.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.bnk.base.BaseClass;
import com.bnk.base.Constants;
import com.bnk.locators.CustomerPageLocators;

import utilities.parameterization;

public class NewCustomer extends BaseClass{
	public CustomerPageLocators cp;
	
	
	public NewCustomer()
	{
		this.cp=new CustomerPageLocators();
		PageFactory.initElements(driver, this.cp);
	}
	
	
	public void NewCustomerClick()
	{
		click(cp.newCustomerLink);
	}
	
	public void validatePageName()
	{
		
		String actual="Add New Customer";
		String expected=cp.heading.getText();
		Assert.assertEquals(actual, expected);
		
	}
	
	
	public void clickOnSubmitWhenNoData()
	{
		click(cp.submitbtn);
		Alert alert=driver.switchTo().alert();
		String actualalertText=alert.getText();
		String expectedAlertText="please fill all fields";
		Assert.assertEquals(actualalertText, expectedAlertText);
		alert.accept();
		
	}
	
	public void validateCustomerName(String dataToTest, String messageToValidate)
	{
		cp.customerName.sendKeys(dataToTest);
		String actualCustomerMessage=cp.customerNameMessage.getText();
		Assert.assertEquals(messageToValidate, actualCustomerMessage);
		cp.customerName.clear();
	}
	
	public void validateAddress(String dataToTest, String messageToValidate)
	{
		
		cp.address.sendKeys(dataToTest);
		String actualaddrMessage=cp.addressMessage.getText();
		Assert.assertEquals(messageToValidate, actualaddrMessage);
		cp.address.clear();
		
	}
	public void addCustomerData()
	{
		cp.customerName.sendKeys(Constants.custData[0]);
		cp.dob.sendKeys(Constants.custData[1]);
		cp.address.sendKeys(Constants.custData[2]);
		cp.city.sendKeys(Constants.custData[3]);
		cp.state.sendKeys(Constants.custData[4]);
		cp.pinno.sendKeys(Constants.custData[5]);
		cp.telephoneno.sendKeys(Constants.custData[6]);
		cp.emailid.sendKeys(Constants.custData[7]);
		cp.password.sendKeys(Constants.custData[8]);
	}
	public void validateSubmitwithCorrectData()
	{
		addCustomerData();
		cp.submitbtn.click();
		
		String actualMsg=cp.heading.getText();
		String expectedMsg="Customer Registered Successfully!!!";
		
		Assert.assertEquals(actualMsg, expectedMsg);
		
	}
	
	public void validateCIDwithTheLink()
	{
		String actulaID=cp.customerId.getText();
		String url=BaseClass.driver.getCurrentUrl();
		System.out.println(url);
		String[] arr=url.split("=");
		String expectedId=arr[1];
		System.out.println(actulaID);
		System.out.println(actulaID);
		
		Assert.assertEquals(actulaID, expectedId);
		
	}
	public void validateAddedDetails()
	{
		//copying the original Array
		String[] custDatacopy=Constants.custData.clone();
		
		//removing the last element
		custDatacopy = ArrayUtils.remove(custDatacopy, custDatacopy.length-1);
		
		ArrayList<String> custdetails=new ArrayList<String>();
		for(int i=5;i<=13;i++)
		{
			
			String data=driver.findElement(By.xpath("//tr//tr["+i+"]/td[2]")).getText();
			if(i==7)
			{
				data=data.replace("-", "");
			}
			custdetails.add(data);
		}
		
		custdetails.remove(1);
		String sb=custdetails.get(1);
		StringBuilder newSB=new StringBuilder();
		newSB.append(sb);
		newSB.delete(0, 4);
		System.out.println(sb);
		System.out.println(newSB);
		newSB.insert(4, sb);
		System.out.println(newSB);
		newSB.delete(8, 12);
		System.out.println(newSB);
		String sb2=newSB.toString();
		custdetails.remove(1);
		custdetails.add(1, sb2);
		
		Assert.assertEquals(custDatacopy, custdetails.toArray());
		
		
	}
	
	public void addingCustomerWithExistingEmail()
	{
		//Email Address Already Exist !!
		//email id=DebraFPonce28@gmail.com
		//clear all the data in the screen
		
	}
	
	public void validateReset()
	{
		addCustomerData();
		cp.reset.click();
		int count=0;
		for(int i=4;i<=13;i++)
		{
			if(i!=5 && i!=7)
			{
				WebElement emptyTextBox=driver.findElement(By.xpath("//tr//tr["+i+"]/td[2]/input"));
				if(emptyTextBox.getAttribute("value").isEmpty())
				{
					count=count+1;
				}
			}
		}
		WebElement emptyAddres=driver.findElement(By.xpath("//tr//tr[7]/td[2]/textarea"));
		if(emptyAddres.getAttribute("value").isEmpty())
		{
			count=count+1;
		}
		Assert.assertEquals(9, count);
		
		
	}
	
	
	public void newCutomerVerify()
	{
		addCustomerData();
		cp.submitbtn.click();
		String url=driver.getCurrentUrl();
		String[] arr=url.split("=");
		String customerID=arr[1];
		String password=Constants.custData[8].toString();
		cp.logOut.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		BaseClass.login(customerID, password);
		String actualTitle="Guru99 Bank Customer HomePage";
		String expectedTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		
	}
	public void deleteCustomerVerfiy()
	{
		addCustomerData();
		cp.submitbtn.click();
		String url=driver.getCurrentUrl();
		String[] arr=url.split("=");
		String customerID=arr[1];
		cp.deleteCustomer.click();
		cp.deletePageCustID.sendKeys(customerID);
		cp.deletePageSubmit.click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		NewCustomerClick();
		validateSubmitwithCorrectData();
		
	}
	public void validateCity()
	{
		
	}
	
	public void validateState()
	{
		
	}
	
	public void validatePin()
	{
		
	}
	
	public void validateMobileNumber()
	{
		
	}
	public void validateEmail()
	{
		
	}
	
	
	
	

}
