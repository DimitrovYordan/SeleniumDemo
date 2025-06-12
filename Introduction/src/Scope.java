import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Install\\chromedriver-win64\\chromedriver.exe");		
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://qaclickacademy.com/practice.php/");
		System.out.println(chromeDriver.findElements(By.tagName("a")).size());
		WebElement footer = chromeDriver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		WebElement column = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(column.findElements(By.tagName("a")).size());
		for(int i = 1; i < column.findElements(By.tagName("a")).size(); i++) {
			
			String clickLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			column.findElements(By.tagName("a")).get(i).sendKeys(clickLink);
			Thread.sleep(2000);
		}		
		Set<String> some = chromeDriver.getWindowHandles();
		Iterator<String> iterator = some.iterator();
		while(iterator.hasNext()){
			chromeDriver.switchTo().window(iterator.next());
			System.out.println(chromeDriver.getTitle());
		}		
		
	}

}
