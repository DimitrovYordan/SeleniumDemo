import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class TestSelenium {
	
	public static void main(String[] args) {
		
	//Chromedriver.exe -> Chrome browser
	//System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	//Selenium Manager
	WebDriver chromeDriver = new ChromeDriver();
	chromeDriver.get("https://dariknews.bg/novini/bylgariia/tezhka-katastrofa-s-zhertva-na-magistrala-trakiia-dvizhenieto-se-prenasochva-2419593");
	System.out.println(chromeDriver.getTitle());
	System.out.println(chromeDriver.getCurrentUrl());
	//close only current window
	//chromeDriver.close();
	//close all related windows
	chromeDriver.quit();
	
	
	}
}
