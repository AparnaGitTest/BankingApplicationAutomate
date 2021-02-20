package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bnk.actions.customerRolePage;
import com.bnk.actions.fundTransfer;
import com.bnk.base.Page;

public class rough {
	public static customerRolePage crp;
	
	@BeforeTest
	public void setUp()
	{
		Page.initConfigurations();
		crp=new customerRolePage();
	}
	
	@Test
	public void transaction()
	{
		//login as customer 32100
		Page.login("32100", "a");
		crp.fetchBalanceAmount("89790");
		Page.allLinks.logOutLink();
		
		//login as customer 57686
		Page.login("57686", "a");
		crp.fetchBalanceAmount("89792");
		Page.allLinks.logOutLink();
		
		System.out.println(crp.list);
		
		//login as customer 32100
		//Now we are performing transaction 
		//This is a from account
		Page.login("32100", "a");
		int balance_fromAccount=crp.getActualBalance("32100");
		int balance_ToAccount=crp.getActualBalance("57686");
		System.out.println("The original balance in 32100:"+balance_fromAccount);
		System.out.println("The original balance in 57686:"+balance_ToAccount);
		Page.allLinks.fundTransferLink();
		fundTransfer fc=new fundTransfer();
		fc.transferAmount("89790", "89792", "1000", "desc");
		
		System.out.println("The amount transferred from 32100 to 57686 is: "+fc.amountToTransfer);
		
		int balanceAfterTransfer_fromAccount=balance_fromAccount-Integer.parseInt(fc.amountToTransfer);
		int balanceAfterTransfer_ToAccount=balance_ToAccount+Integer.parseInt(fc.amountToTransfer);
		
		System.out.println("The expected balance in 32100:"+balanceAfterTransfer_fromAccount);
		System.out.println("The expected balance in 57686:"+balanceAfterTransfer_ToAccount);
		crp.list.clear();
		
		crp.fetchBalanceAmount("89790");
		Page.allLinks.logOutLink();
		
		Page.login("57686", "a");
		crp.fetchBalanceAmount("89792");
		
		balance_fromAccount=crp.getActualBalance("32100");
		balance_ToAccount=crp.getActualBalance("57686");
		
		System.out.println("The balance feteched in 32100:"+balance_fromAccount);
		System.out.println("The balance feteched in 57686:"+balance_ToAccount);
		Assert.assertEquals(balanceAfterTransfer_fromAccount, balance_fromAccount);
		Assert.assertEquals(balanceAfterTransfer_ToAccount, balance_ToAccount);
		
		
	}

}
