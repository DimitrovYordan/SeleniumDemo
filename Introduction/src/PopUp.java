import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUp {

	public static void main(String[] args) throws InterruptedException {
		
		String text = "Dani";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);		
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
		chromeDriver.findElement(By.id("name")).sendKeys(text);
		chromeDriver.findElement(By.cssSelector("[id='alertbtn']")).click();
		System.out.println(chromeDriver.switchTo().alert().getText());
		Thread.sleep(1000);
		chromeDriver.switchTo().alert().accept();
		chromeDriver.findElement(By.id("name")).sendKeys(text);
		Thread.sleep(1000);
		chromeDriver.findElement(By.id("confirmbtn")).click();
		System.out.println(chromeDriver.switchTo().alert().getText());
		Thread.sleep(1000);
		chromeDriver.switchTo().alert().dismiss();
				
	}

}
