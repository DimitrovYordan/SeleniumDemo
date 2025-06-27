import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Handle_Broken_Links {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {

		//System.setProperty("webdriver.chrome.driver", chromeDriverPath);		
		WebDriver chromeDriver = new ChromeDriver();
		//chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		chromeDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//String url = chromeDriver.findElement(By.cssSelector("a[href*='soapui']")).getDomAttribute("href");
		//String brokenUrl = chromeDriver.findElement(By.cssSelector("a[href*='brokenlink']")).getDomAttribute("href");
		//HttpURLConnection conn = (HttpURLConnection)new URL(brokenUrl).openConnection();
		//conn.setRequestMethod("HEAD");
		//conn.connect();
		//int responseCode = conn.getResponseCode();
		//System.out.println(responseCode);
		
		List<WebElement> links = chromeDriver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert softAssert = new SoftAssert();
		for(int i = 1; i < links.size(); i++) {
			
			String url = links.get(i).getDomAttribute("href");
			System.out.println(url);
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			softAssert.assertTrue(responseCode>400, "Link with text " + links.get(i).getText() + "is broken with code" + responseCode);
			
		}
		
		softAssert.assertAll();
	}

}
