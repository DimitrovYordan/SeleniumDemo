import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {

		String year = "2026";
		String month = "9";
		String date = "21";
		String[] expectedDate = {month, date, year};
		
		System.setProperty("webdriver.chrome.driver", "C:\\Install\\chromedriver-win64\\chromedriver.exe");		
		WebDriver chromeDriver = new ChromeDriver();
		//chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		chromeDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		chromeDriver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		chromeDriver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		chromeDriver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		Thread.sleep(2000);
		chromeDriver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		Thread.sleep(2000);
		chromeDriver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month) - 1).click();
		Thread.sleep(1000);
		chromeDriver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		//System.out.println(chromeDriver.findElement(By.cssSelector(".react-date-picker__inputGroup")).getText());
		List<WebElement> actualDate = chromeDriver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for (int i = 0; i < actualDate.size(); i++) {
			System.out.println(actualDate.get(i).getDomAttribute("value"));
			Assert.assertEquals(actualDate.get(i).getDomAttribute("value"), expectedDate[i]);
		}
		chromeDriver.close();
		
	}

}
