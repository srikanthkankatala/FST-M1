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
	    
	    return new Object[][] {

	        {"test_user1", "test_password1", "Invalid credentials"},
	        
	        {"test_user2", "test_password2", "Invalid credentials"}
	        };
	}

	
	@Test(dataProvider = "Authentication")
	public void test(String username, String password, String expectedmessage) {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("password")).clear();
		
		driver.findElement(By.id("username")).sendKeys(username);
    	driver.findElement(By.id("password")).sendKeys(password);
    	
    	driver.findElement(By.xpath("//button[text()='Submit']")).click();
      	Assert.assertEquals(expectedmessage, driver.findElement(By.id("subheading")).getText());
		
	}
	

	@AfterClass
	public void close() {
	driver.quit();
	}

}
