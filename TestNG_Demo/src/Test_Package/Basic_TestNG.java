package Test_Package;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Basic_TestNG {
	
	@AfterTest
	public void AfterAll() {
		System.out.println("This should be execute after all tests.");
	}

	@Test
	public void Demo() {
		System.out.println("Hello");		
	}

	@Parameters({ "URL", "APIKey/username" }) // applies only for this method
	@Test
	public void SecondDemo(String urlName, String apikey) {
		System.out.println("Hello second demo.");
		System.out.println(urlName);
		System.out.println(apikey);
	}
	
	@AfterSuite
	public void AfterSuite() {
		System.out.println("After suite.");
	}
}
