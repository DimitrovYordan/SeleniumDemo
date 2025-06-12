import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_Demo {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Install\\chromedriver-win64\\chromedriver.exe");		
		//WebDriver chromeDriver = new ChromeDriver();
		//chromeDriver.get("https://www.amazon.com/");
		//chromeDriver.manage().window().maximize();
		//WebElement element = chromeDriver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		//Actions act = new Actions(chromeDriver);
		
		// moves mouse to specific element
		//act.moveToElement(element).build().perform();
		//act.moveToElement(chromeDriver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("kitty").build().perform();
		// right click
		//act.moveToElement(element).contextClick().build().perform();
		
		// drag and drop
		System.setProperty("webdriver.chrome.driver", "C:\\Install\\chromedriver-win64\\chromedriver.exe");		
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://jqueryui.com/droppable/");
		chromeDriver.switchTo().frame(chromeDriver.findElement(By.cssSelector("iframe.demo-frame")));
		chromeDriver.findElement(By.id("draggable")).click();
		Actions act = new Actions(chromeDriver);
		WebElement source = chromeDriver.findElement(By.id("draggable"));
		WebElement target = chromeDriver.findElement(By.id("droppable"));
		act.dragAndDrop(source, target).build().perform();
		chromeDriver.switchTo().defaultContent();
		
	}

}
