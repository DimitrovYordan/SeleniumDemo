import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// DO NOT RUN
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setAcceptInsecureCerts(true);
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:0000");
		chromeOptions.setCapability("proxy", proxy);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Install\\chromedriver-win64\\chromedriver.exe");		
		WebDriver chromeDriver = new ChromeDriver(chromeOptions);
		chromeDriver.get("https://expired.badssl.com/");
		
		System.out.println(chromeDriver.getTitle());

	}

}
