package activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void beforclass() {
		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://training-support.net/webelements/login-form");

	}
	
	@DataProvider(name="Authentication")
	public static Object[][] credentials() {
	    // Declares a static method named 'credentials' that returns a 2D array of Objects.
	    // This is typically used as a data provider in TestNG for parameterized tests.
	    
	    return new Object[][] {
	        // Returns a 2D array containing multiple sets of test data.
	        // Each inner array represents one test case with three values:
	        // - Username
	        // - Password
	        // - Expected result or message

	        {"test_user1", "test_password1", "Invalid credentials"},
	        // First test case: uses test_user1 and test_password1, expecting "Invalid credentials" message.

	        {"test_user2", "test_password2", "Invalid credentials"}
	        // Second test case: uses test_user2 and test_password2, also expecting "Invalid credentials".
	    };
	}

	
	@Test(dataProvider = "Authentication")
	public void test(String username, String password, String expectedmessage) {
		//before passing the parameters we need to clear the fields
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("password")).clear();
		
		driver.findElement(By.id("username")).sendKeys(username);
    	driver.findElement(By.id("password")).sendKeys(password);
    	
    	driver.findElement(By.xpath("//button[text()='Submit']")).click();
    	
  //  	wait.until(ExpectedConditions.titleContains("Success"));    	
    	
    	Assert.assertEquals(expectedmessage, driver.findElement(By.id("subheading")).getText());
		
	}
	

	@AfterClass
	public void close() {
	driver.quit();
	}
}