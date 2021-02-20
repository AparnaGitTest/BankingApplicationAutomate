package utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			
			extent=new ExtentReports("D:\\CDriver-eclipse\\eclipse-workspace\\ProjectsPrac\\BankProject\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File("D:\\CDriver-eclipse\\eclipse-workspace\\ProjectsPrac\\BankProject\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));
		}
		return extent;
	}
	
	

}
