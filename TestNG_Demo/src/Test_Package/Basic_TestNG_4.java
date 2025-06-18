package Test_Package;

import org.testng.annotations.Test;

public class Basic_TestNG_4 {

	@Test
	public void WebLogin() {
		// selenium
		System.out.println("Hello WebLogin.");
	}
	
	@Test(groups= {"DemoGr"}) // help us to start only those methods have this group testng3.xml
	public void MobileAppLogin() {
		// appium
		System.out.println("Hello MobileAppLogin.");
	}
	
	@Test(dependsOnMethods={"WebLogin"}) // will be executed immediately after given method
	public void LoginAPI() {
		// REST API automation
		System.out.println("Hello LoginAPI.");
	}
}
