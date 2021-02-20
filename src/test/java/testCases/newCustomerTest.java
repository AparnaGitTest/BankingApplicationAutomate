package testCases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.chainsaw.Main;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bnk.actions.newCustomer;
import com.bnk.base.Page;

import utilities.parameterization;

public class newCustomerTest {
	public static newCustomer nc;
	DateFormat format=new SimpleDateFormat("ddMMyyyyhhmmss");
	  Date d=new Date();
	  String dategenerate=format.format(d);
	  String[] emailid=new String[4];
	// TODO Auto-generated method stub
	
	
	
	@BeforeTest
	public void setUp()
	{
		Page.initConfigurations();
		Page.login();
		nc=new newCustomer();
		Page.allLinks.newCustomerLink();
		
		emailid[0]="Robert"+dategenerate+"@gmail.com";
		emailid[1]="Vonda"+dategenerate+"@gmail.com";
		emailid[2]="Patric"+dategenerate+"@gmail.com";
		emailid[3]="Joey"+dategenerate+"@gmail.com";
		
	}
	
	
	
	//@Test(priority=1)
	public void validatePageName() {
	
		nc.validatePageHeading();
		
	}
	//@Test(priority=2)
	public void validateonSubmit()
	{
		nc.clickOnSubmitWhenNoData();
	}
	
	@Test(priority=3,dataProviderClass=parameterization.class,dataProvider="cust")
	public void validateCustomerNameTB(String dataToTest,String messageToValidate)
	{
		
		nc.validateCustomerNameField(dataToTest, messageToValidate);
	}
	
	@Test(priority=4,dataProviderClass=parameterization.class,dataProvider="Add")
	public void validateAddressTB(HashMap<String, String> data)
	{
		
		nc.validateAddressField(data.get("addressData"), data.get("addressMsg"));
	}
	@Test(priority=5)
	public void validateSubmitwithCorrectData()
	{
		nc.validateSubmitwithCorrectData(emailid[0]);
		nc.validateCustomerIdWithLink();
		nc.validateAddedDetails();
		nc.cp.Home.click();
		Page.allLinks.newCustomerLink();
	}
	@Test(priority=6)
	public void validateReset()
	{
		nc.validateReset(emailid[1]);
	}
	@Test(priority=7)
	public void newCutomerVerify()
	{
		nc.newCutomerVerify(emailid[2]);
		
		Page.login();
		Page.allLinks.newCustomerLink();
		
	}
	@Test(priority=8)
	public void deleteCustomerVerfiy()
	{
		nc.deleteCustomerVerfiy(emailid[3]);
		nc.cp.Home.click();
		Page.allLinks.newCustomerLink();
	}
	
	@AfterTest
	public void tearDown()
	{
		Page.driver.quit();
	}
}
