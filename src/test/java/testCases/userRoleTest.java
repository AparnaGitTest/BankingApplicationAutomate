package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bnk.actions.userRole;
import com.bnk.base.Page;

public class userRoleTest {
	
	
	@BeforeTest
	public void setUp()
	{
		Page.initConfigurations();
	}
	
	
	@Test
	public void checkNoOfLinks()
	{
		Page.login();
		userRole ur=new userRole();
		ur.noOfLinks("Manager");
		ur.linkNameVerify("Manager");
		
		Page.allLinks.logOutLink();
		Page.login("47274", "a");
		ur.noOfLinks("Customer");
		ur.linkNameVerify("Customer");
		
	}

	
}
