package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bnk.actions.customerRolePage;
import com.bnk.actions.fundTransfer;
import com.bnk.base.Page;

public class testFundTransfer {
	
	public static fundTransfer fc;
	public static WebDriver driver;

	@BeforeTest
	public void setUp()
	{
		Page.initConfigurations();
		
		
	}
	
	@Test
	public void transaction()
	{
		//login as customer 32100
		Page.login("32100", "a");
	
		Page.allLinks.fundTransferLink();
		fc=new fundTransfer();
		fc.transferAmount("89790", "89792", "10", "desc");
	}
	

}
