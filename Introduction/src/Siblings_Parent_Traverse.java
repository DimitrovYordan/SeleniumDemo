import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Siblings_Parent_Traverse {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", chromeDriverPath);		
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// siblings
		System.out.println(chromeDriver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		// Child - parent
		System.out.println(chromeDriver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
	}

}
