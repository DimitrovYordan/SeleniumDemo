import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Install\\chromedriver-win64\\chromedriver.exe");		
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.get("https://google.com"); // зарежда всички елементи на страницата и тогава продължава към следващата
		chromeDriver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		chromeDriver.navigate().back();
		chromeDriver.navigate().forward();
				
	}

}
