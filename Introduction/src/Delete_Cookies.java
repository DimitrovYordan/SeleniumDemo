import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class Delete_Cookies {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", chromeDriverPath);		
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().deleteAllCookies();
		// изтриване на определена бисквитка
		//chromeDriver.manage().deleteCookieNamed("");
		// добавяне на бисквитка
		//chromeDriver.manage().addCookie(null);
		//  
		chromeDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// screen shot
		File screenShot = ((TakesScreenshot)chromeDriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File("C://screenShot.png"));
		
	}

}
