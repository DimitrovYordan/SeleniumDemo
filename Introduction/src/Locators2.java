import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {		
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);		
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String password = getPassword(chromeDriver);
		chromeDriver.get("https://rahulshettyacademy.com/locatorspractice/");
		chromeDriver.findElement(By.id("inputUsername")).sendKeys("Dani");
		chromeDriver.findElement(By.name("inputPassword")).sendKeys(password);
		chromeDriver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		System.out.println(chromeDriver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(chromeDriver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(chromeDriver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello Dani,");
		Thread.sleep(1000);
		chromeDriver.findElement(By.xpath("//*[text()='Log Out']")).click();
		Thread.sleep(1000);
		chromeDriver.close();
	}
	
	public static String getPassword(WebDriver chromeDriver) throws InterruptedException {
		chromeDriver.get("https://rahulshettyacademy.com/locatorspractice/");
		chromeDriver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		chromeDriver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passText= chromeDriver.findElement(By.cssSelector("form p")).getText();
		String[] passArray = passText.split("'");
		String password = passArray[1];
		return password;
	}
	
}
