package utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class parameterization {
	

	@DataProvider(name = "Add")
	public Object[][] getdata2() {
		HashMap<String, String> map1 = new HashMap<String, String>();
		HashMap<String, String> map2 = new HashMap<String, String>();
		

		
		
		map1.put("addressData","test@test");
		map1.put("addressMsg","Special characters are not allowed");
		
		map2.put("addressData","");
		map2.put("addressMsg","Address Field must not be blank");

		List<HashMap<String, String>> lst=new ArrayList();
		lst.add(map1);
		lst.add(map2);
		
		return new Object[][] {{lst.get(0)},{lst.get(1)}};

	}
	@DataProvider(name = "cust")
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "1223";
		data[0][1] = "Numbers are not allowed";

		data[1][0] = "@test";
		data[1][1] = "Special characters are not allowed";

		data[2][0] = "";
		data[2][1] = "Customer name must not be blank";

		return data;

	}
}
