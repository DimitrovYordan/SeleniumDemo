import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Update_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Install\\chromedriver-win64\\chromedriver.exe");		
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Assert.assertFalse(chromeDriver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
		chromeDriver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).click();
		Assert.assertTrue(chromeDriver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
		//System.out.println(chromeDriver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
		// count checkboxes
		System.out.println(chromeDriver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
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

	}

}
