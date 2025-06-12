import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Table_Sorting {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Install\\chromedriver-win64\\chromedriver.exe");		
		WebDriver chromeDriver = new ChromeDriver();
		//chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		chromeDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		chromeDriver.findElement(By.xpath("//tr/th[1]")).click();
		
		List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr/td[1]"));
		
		List<String> original = elements.stream().map(s -> s.getText()).collect(Collectors.toList());
		
		List<String> sorted = original.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(original.equals(sorted));
		
		List<String> price;		
		do {
			List<WebElement> newElements = chromeDriver.findElements(By.xpath("//tr/td[1]"));
			price = newElements.stream().filter(s -> s.getText().contains("Rice"))
					.map(s -> getPrice(s)).collect(Collectors.toList());		
					price.forEach(i -> System.out.println(i));
					
					if (price.size() < 1) {
						chromeDriver.findElement(By.cssSelector("[aria-label='Next']")).click();
					}
		}
		while (price.size() < 1);
		
	}
	
	private static String getPrice(WebElement s) {
		
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return price;
	}

}
