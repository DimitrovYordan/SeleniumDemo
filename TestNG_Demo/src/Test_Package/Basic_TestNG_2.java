package Test_Package;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Basic_TestNG_2 {

	@Test(groups= {"DemoGr"})
	public void SecondDemo() {
		System.out.println("Hello Basic_TestNG_2.");
		Assert.assertTrue(false);
	}
	
	@BeforeTest
	public void BeforeAnyMethod() {
		System.out.println("This should be execute before any test.");
	}
	
	@Parameters({"URL"})
	@Test
	public void ThirdDemo(String urlName) {
		System.out.println("Hello Basic_TestNG_2.");
		System.out.println(urlName);
	}
}
