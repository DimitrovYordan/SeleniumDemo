import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Parent_Class {

	public void doThis() {
		System.out.println("I am here");
	}
	
	@BeforeMethod
	public void beforeRun() {
		System.out.println("I should be run first.");
	}
	
	@AfterMethod
	public void afterRun() {
		System.out.println("I should be run last.");
	}
	
}
