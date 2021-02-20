package com.bnk.actions;

import java.io.IOException;
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

import com.bnk.base.Page;
import com.bnk.base.Constants;
import com.bnk.locators.newCustomerLocators;

import utilities.parameterization;

public class newCustomer extends Page{
	public newCustomerLocators cp;
	
	
	public newCustomer()
	{
		this.cp=new newCustomerLocators();
		PageFactory.initElements(driver, this.cp);
	}
	
	public void getCustId()
	{
		String url=driver.getCurrentUrl();
		String[] arr=url.split("=");
		custId=arr[1];
	}
	
	
	public void validatePageHeading()
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
	
	public void validateCustomerNameField(String dataToTest, String messageToValidate)
	{
		//Only allow characters in customer name field
		//Should not allow special characters or numbers
		//Should not allow blank
		type(cp.customerName,dataToTest);
		String actualCustomerMessage=cp.customerNameMessage.getText();
		Assert.assertEquals(messageToValidate, actualCustomerMessage);
		cp.customerName.clear();
	}
	
	public void validateAddressField(String dataToTest, String messageToValidate)
	{
		//Only allow characters and numbers
		//Should not allow special characters
		//Should not allow blank
		type(cp.address,dataToTest);
		String actualaddrMessage=cp.addressMessage.getText();
		Assert.assertEquals(messageToValidate, actualaddrMessage);
		cp.address.clear();
		
	}
	public void addCustomerData(String emailId)
	{
		//Method to fill the form with customer information
		Constants.custData[7]=emailId;
		type(cp.customerName,Constants.custData[0]);
		type(cp.dob,Constants.custData[1]);
		type(cp.address,Constants.custData[2]);
		type(cp.city,Constants.custData[3]);
		type(cp.state,Constants.custData[4]);
		type(cp.pinno,Constants.custData[5]);
		type(cp.telephoneno,Constants.custData[6]);
		type(cp.emailid,Constants.custData[7]);
		type(cp.password,Constants.custData[8]);
	}
	public void validateSubmitwithCorrectData(String emailId)
	{
		
		addCustomerData(emailId);
		click(cp.submitbtn);
		String actualMsg=cp.heading.getText();
		String expectedMsg="Customer Registered Successfully!!!";
		Assert.assertEquals(actualMsg, expectedMsg);
		getCustId();
		try {
			Page.storeCustomerData(custId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void validateCustomerIdWithLink()
	{
		//addCustomerData(emailId);
	//	click(cp.submitbtn);
		String actulaID=cp.customerId.getText();
		String url=Page.driver.getCurrentUrl();
		System.out.println(url);
		String[] arr=url.split("=");
		String expectedId=arr[1];
		System.out.println(actulaID);
		System.out.println(actulaID);
		
		Assert.assertEquals(actulaID, expectedId);
		Page.custId=expectedId;
		try {
			Page.storeCustomerData(custId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void validateAddedDetails()
	{
		//copying the original Array
		//addCustomerData(emailId);
	//	click(cp.submitbtn);
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
		getCustId();
		try {
			Page.storeCustomerData(custId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void addingCustomerWithExistingEmail()
	{
		//Email Address Already Exist !!
		//email id=DebraFPonce28@gmail.com
		//clear all the data in the screen
		
	}
	
	public void validateReset(String emailId)
	{
		addCustomerData(emailId);
		click(cp.reset);
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
	
	
	public void newCutomerVerify(String emailId)
	{
		addCustomerData(emailId);
		click(cp.submitbtn);
		getCustId();
		try {
			Page.storeCustomerData(custId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url=driver.getCurrentUrl();
		String[] arr=url.split("=");
		String customerID=arr[1];
		String password=Constants.custData[8].toString();
		click(cp.logOut);
		Alert alert=driver.switchTo().alert();
		alert.accept();
		Page.login(customerID, password);
		String actualTitle="Guru99 Bank Customer HomePage";
		String expectedTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		Page.allLinks.customizedStatementLink();
		Page.allLinks.logOutLink();
		
	}
	public void deleteCustomerVerfiy(String emailId)
	{
		//delete will have 2 scenarios
		//create customer and delete
		//create customer, this customer has account and delete
		//---system wont allow to delete
		//this method works when no account is create for the customer
		addCustomerData(emailId);
		click(cp.submitbtn);
		getCustId();
		try {
			Page.storeCustomerData(custId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url=driver.getCurrentUrl();
		String[] arr=url.split("=");
		String customerID=arr[1];
		click(cp.deleteCustomer);
		type(cp.deletePageCustID,customerID);
		click(cp.deletePageSubmit);
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		Page.allLinks.newCustomerLink();
		validateSubmitwithCorrectData(emailId);
		
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
