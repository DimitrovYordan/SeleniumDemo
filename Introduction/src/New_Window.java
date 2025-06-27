import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class New_Window {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);		
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/angularpractice/");
		
		// open new TAB and new page
		chromeDriver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles = chromeDriver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		chromeDriver.switchTo().window(childWindow);
		chromeDriver.get("https://rahulshettyacademy.com");
		
		// get name of course and switch to parent window
		String courseName = chromeDriver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
							.get(1).getText();
		chromeDriver.switchTo().window(parentWindow);
		
		// pass course name to input field in parent window
		//chromeDriver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);
		
		// take screenshoot to specific WebElement
		WebElement element = chromeDriver.findElement(By.cssSelector("[name='name']"));
		element.sendKeys(courseName);
		File file = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		// get height & width all 4 methods give same result
		System.out.println(element.getRect().height);
		System.out.println(element.getRect().getHeight());
		System.out.println(element.getRect().getDimension().height);
		System.out.println(element.getRect().getDimension().getHeight());
		
		System.out.println(element.getRect().width);
		System.out.println(element.getRect().getWidth());
		System.out.println(element.getRect().getDimension().width);
		System.out.println(element.getRect().getDimension().getWidth());		
		
		//chromeDriver.quit();

	}

}
