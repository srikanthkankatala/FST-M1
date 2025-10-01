package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	
WebDriver driver;

// Setup function
@BeforeClass
public void setUp() {
    // Initialize Firefox driver
    driver = new FirefoxDriver();
    // Open the page
    driver.get("https://alchemy.hguy.co/jobs");
    
}

@Test
public void verifyHeader() {
	Assert.assertEquals(driver.findElement(By.cssSelector("h1[class='entry-title']")).getText(), "Welcome to Alchemy Jobs");
	driver.close();
		}
}
