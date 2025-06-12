import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Search_Field {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Install\\chromedriver-win64\\chromedriver.exe");		
		WebDriver chromeDriver = new ChromeDriver();
		//chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		chromeDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		chromeDriver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veggies = chromeDriver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> result = veggies.stream().filter(v -> v.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(veggies.size(), result.size());
		
	}

}
