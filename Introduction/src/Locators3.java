import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Locators3 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Install\\chromedriver-win64\\chromedriver.exe");		
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameBox = chromeDriver.findElement(By.cssSelector("[name='name']"));
		
		System.out.println(chromeDriver.findElement(with(By.tagName("label")).above(nameBox)).getText());

		WebElement dateofBirth = chromeDriver.findElement(By.cssSelector("[for='dateofBirth']"));
		chromeDriver.findElement(with(By.tagName("input")).below(dateofBirth)).click();
		
		WebElement checkBoxIceCream = chromeDriver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		chromeDriver.findElement(with(By.tagName("input")).toLeftOf(checkBoxIceCream)).click();
		
		WebElement redioButton = chromeDriver.findElement(By.id("inlineRadio1"));
		System.out.println(chromeDriver.findElement(with(By.tagName("label")).toRightOf(redioButton)).getText());
		
	}

}
