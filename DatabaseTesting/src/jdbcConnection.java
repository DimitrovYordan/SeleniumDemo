import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.chrome.ChromeDriver;

public class jdbcConnection {

	public static void main(String[] args) throws SQLException {

		// NOT TESTED - MYSQL
		ChromeDriver driver = new ChromeDriver();
		driver.get("address");
		
		Connection conn = DriverManager.getConnection("database", "user", "password");
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery("query");	
		
		while (result.next()) {
			driver.findElement(By.xpath()).sendKeys(result.getString("colName"));
		}		
		
	}

}
