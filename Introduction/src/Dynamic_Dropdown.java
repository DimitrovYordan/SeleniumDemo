import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Dynamic_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Install\\chromedriver-win64\\chromedriver.exe");		
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		chromeDriver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		//with index
		//chromeDriver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		//with parent - child, no index
		chromeDriver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		chromeDriver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(chromeDriver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		if(chromeDriver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
			System.out.println("It's enabled");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		//chromeDriver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
		

	}

}
