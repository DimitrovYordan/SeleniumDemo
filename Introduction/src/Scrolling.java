import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scrolling {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", chromeDriverPath);		
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/AutomationPractice");
		
		JavascriptExecutor js = (JavascriptExecutor)chromeDriver;
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> tableData = chromeDriver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		for (int i = 0; i < tableData.size(); i++) {
			//System.out.println(Integer.parseInt(tableData.get(i).getText()));
			//sum = sum + Integer.parseInt(tableData.get(i).getText());
			//System.out.println(sum);
			sum += Integer.parseInt(tableData.get(i).getText());
		}
		System.out.println(sum);
		int total = Integer.parseInt(chromeDriver.findElement(By.cssSelector(".totalAmount")).getText().split(": ")[1]);
		
		Assert.assertEquals(sum, total);
	}

}
