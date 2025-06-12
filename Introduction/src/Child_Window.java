import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Child_Window {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Install\\chromedriver-win64\\chromedriver.exe");		
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		chromeDriver.findElement(By.cssSelector(".blinkingText")).click();
		// change to child window
		Set<String> windows = chromeDriver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parentId = iterator.next();
		String childId = iterator.next();
		chromeDriver.switchTo().window(childId);
		System.out.println(chromeDriver.findElement(By.cssSelector(".im-para.red")).getText());
		String emailId = chromeDriver.findElement(By.cssSelector(".im-para.red")).getText().split(" ")[4];
		chromeDriver.switchTo().window(parentId);
		chromeDriver.findElement(By.id("username")).sendKeys(emailId);
		
	}

}
