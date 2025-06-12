import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shopping_Cart {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Install\\chromedriver-win64\\chromedriver.exe");		
		WebDriver chromeDriver = new ChromeDriver();
		//chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		chromeDriver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		String[] veggetables = {"Cucumber", "Brocolli"};
		//Thread.sleep(2000);
		addItems(chromeDriver, veggetables);
		chromeDriver.findElement(By.cssSelector("img[alt='Cart']")).click();
		chromeDriver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
		// explicit wait
		WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		chromeDriver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");	
		chromeDriver.findElement(By.cssSelector("button.promoBtn")).click();
		// explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(chromeDriver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		
		
	}
	
	public static void addItems(WebDriver chromeDriver, String[] veggetables) {
		
		List<String> neededVeggetables = Arrays.asList(veggetables);
		List<WebElement> products = chromeDriver.findElements(By.cssSelector("h4.product-name"));
		int count = 0;
		for (int i = 0; i < products.size(); i++) {
			
			String[] nameProduct = products.get(i).getText().split("-");
			String formattedName = nameProduct[0].trim();
			if (neededVeggetables.contains(formattedName)) {
				// click on ADD TO CART - не работи при динамичен текст заради бързото изпълнение на програмата
				//chromeDriver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				// хваща целия блок на ADD TO CART и така не зависи на текста на бутона, който е динамичен
				chromeDriver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				count++;
				
				if (count == veggetables.length) {
					break;
				}
			}		
		}
		
	}

}
