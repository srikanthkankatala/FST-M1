package activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {
	
WebDriver driver;
WebDriverWait wait;
// Setup function
@BeforeClass
public void setUp() {
    // Initialize Firefox driver
    driver = new FirefoxDriver();
    
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    // Open the page
    driver.get("https://alchemy.hguy.co/jobs");    
}

@Test
public void verifyJobPage() {
	driver.findElement(By.cssSelector("div[class='main-navigation'] a")).click();
	Assert.assertEquals(driver.getTitle(), "Jobs – Alchemy Jobs");        
	driver.findElement(By.cssSelector("input[id='search_keywords']")).sendKeys("Banking");
	driver.findElement(By.cssSelector("input[value='Search Jobs']")).click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.job_listings li a")));
	List<WebElement> jobs = driver.findElements(By.cssSelector("ul.job_listings li a"));

	if (!jobs.isEmpty()) {
	    Random rand = new Random();
	    WebElement randomJob = jobs.get(rand.nextInt(jobs.size()));
	    randomJob.click();
	} else {
	    System.out.println("No jobs available to click!");
	}

	driver.findElement(By.cssSelector("input[class='application_button button']")).click();
	System.out.println(driver.findElement(By.cssSelector("a[class='job_application_email']")).getText());
	
	driver.close();
		}
}