import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);		
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// flight destination
		chromeDriver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		chromeDriver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(2000);
		// calendar
		chromeDriver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		chromeDriver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
		if(chromeDriver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
			System.out.println("It's disabled");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		chromeDriver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).click();
		// passengers
		chromeDriver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		int count = 1;
		while(count < 5) {
			chromeDriver.findElement(By.id("hrefIncAdt")).click();
			count++;
		}
		chromeDriver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(chromeDriver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(chromeDriver.findElement(By.id("divpaxinfo")).getText());
		// click search button by Id
		//chromeDriver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
		// click search button by tag name
		//chromeDriver.findElement(By.cssSelector("input[value='Search'")).click();
		// click search button by xpath - it's not working
		chromeDriver.findElement(By.xpath("//input[@value='Search']")).click();
		// click search button by name
		//chromeDriver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();		
		
	}

}
