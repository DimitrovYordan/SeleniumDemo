package Test_Package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Basic_TestNG_3 {
	
	@BeforeClass
	public void BeforeAnyClass() {
		System.out.println("Before class.");
	}
	
	@AfterMethod
	public void AfterMethod() {
		System.out.println("After every method in this class.");
	}

	@Test(enabled=false) // stop from being executed
	public void WebLoginHome() {
		// selenium
		System.out.println("Hello WebLoginHome.");
	}
	
	@Test(dataProvider="getData")
	public void TestDataProvider(String username, String pass) {
		// selenium
		System.out.println("Hello WebLoginHome.");
		System.out.println(username);
		System.out.println(pass);
	}
	
	@Test(groups= {"DemoGr"})
	public void MobileAppLoginHome() {
		// appium
		System.out.println("Hello MobileAppLoginHome.");
	}
	
	@AfterClass
	public void AfterClass() {
		System.out.println("After class.");
	}
	
	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("Before Suite.");
	}
	
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("Before every method in this class.");
	}
	
	@Test(timeOut=4000) // wait 4 sec before you failed if execution run slow
	public void LoginAPIHome() {
		// REST API automation
		System.out.println("Hello LoginAPIHome.");
	}
	
	@DataProvider
	public Object[][] getData() {
		// 1. username password - good credit history
		// 2. username password - no credit history
		// 3. wrong credit history
		Object[][] data = new Object[3][2]; // test cases / provided data
		data[0][0] = "firstUsername";
		data[0][1] = "password";
		
		data[1][0] = "secondUsername";
		data[1][1] = "secondPassword";
		
		data[2][0] = "thirdUsername";
		data[2][1] = "thirdPassword";
		
		return data;
	}
}
