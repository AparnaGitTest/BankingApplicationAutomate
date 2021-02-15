package testCases;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bnk.actions.NewCustomer;
import com.bnk.base.BaseClass;

import utilities.parameterization;

public class newCustomerTest {
	public static NewCustomer nc;
	
	
	@BeforeSuite
	public void setUp()
	{
		BaseClass.initConfigurations();
		nc=new NewCustomer();
		nc.NewCustomerClick();
	}
	
	
	@Test(priority=1,groups="basic")
	public void validatePageName() {
		// TODO Auto-generated method stub
		
		
		nc.validatePageName();
		
	}
	@Test(priority=2,groups="validation")
	public void validateonSubmit()
	{
		nc.clickOnSubmitWhenNoData();
	}
	
	@Test(priority=3,dataProviderClass=parameterization.class,dataProvider="cust",groups="validation")
	public void validateCustomerNameTB(String dataToTest,String messageToValidate)
	{
		
		nc.validateCustomerName(dataToTest, messageToValidate);
	}
	
	@Test(priority=4,dataProviderClass=parameterization.class,dataProvider="Add",groups="validation")
	public void validateAddressTB(HashMap<String, String> data)
	{
		
		nc.validateAddress(data.get("addressData"), data.get("addressMsg"));
	}
	
	@Test(priority=5,groups="newCust")
	public void validateSubmitwithCorrectData()
	{
		nc.validateSubmitwithCorrectData();
	}
	
	@Test(priority=6,groups="newCust")
	public void validateCIDwithTheLink()
	{
		nc.validateCIDwithTheLink();
	}
	
	@Test(priority=7,groups="newCust")
	public void validateAddedDetails()
	{
		nc.validateAddedDetails();
	}
	
	@Test(priority=8,groups="basic")
	public void validateReset()
	{
		nc.validateReset();
	}
	
	@Test(priority=9,groups="newCust")
	public void newCutomerVerify()
	{
		nc.newCutomerVerify();
	}
	@Test(priority=10,groups="basic")
	public void deleteCustomerVerfiy()
	{
		nc.deleteCustomerVerfiy();
	}
	
	
	public void tearDow()
	{
		BaseClass.driver.quit();
	}
}
