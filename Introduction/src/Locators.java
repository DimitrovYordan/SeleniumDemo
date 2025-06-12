import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Install\\chromedriver-win64\\chromedriver.exe");		
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		chromeDriver.get("https://rahulshettyacademy.com/locatorspractice/");
		chromeDriver.findElement(By.id("inputUsername")).sendKeys("Dani");
		chromeDriver.findElement(By.name("inputPassword")).sendKeys("some");
		chromeDriver.findElement(By.className("submit")).click();
		System.out.println(chromeDriver.findElement(By.cssSelector("p.error")).getText());
		chromeDriver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		chromeDriver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Gancho");
		chromeDriver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("ganchovec@abv.bg");
		chromeDriver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		chromeDriver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
		chromeDriver.findElement(By.xpath("//form/input[3]")).sendKeys("984651531");
		chromeDriver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(chromeDriver.findElement(By.cssSelector("form p")).getText());
		chromeDriver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		chromeDriver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		chromeDriver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		chromeDriver.findElement(By.id("chkboxOne")).click();
		chromeDriver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(1000);
		System.out.println(chromeDriver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(chromeDriver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(chromeDriver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello rahul,");
		Thread.sleep(1000);
		chromeDriver.findElement(By.xpath("//*[text()='Log Out']")).click();
		chromeDriver.close();
		
	}
	
}
