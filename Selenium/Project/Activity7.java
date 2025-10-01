package activities;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {
	
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
public void verifyJobPage() throws InterruptedException {
	
	driver.findElement(By.xpath("//div[@class='main-navigation']/ul/li[@id='menu-item-26']/a")).click();
	Assert.assertEquals(driver.getTitle(), "Post a Job – Alchemy Jobs");
	String email = "Jobs"+System.currentTimeMillis()+"@ibm.com";
	driver.findElement(By.cssSelector("input[id='create_account_email']")).sendKeys(email);
	driver.findElement(By.cssSelector("input[id='job_title']")).sendKeys("SAP JOB");
	driver.findElement(By.cssSelector("input[id='job_location']")).sendKeys("Hyderabad");

	WebElement dropdown = driver.findElement(By.id("job_type"));
	Select select = new Select(dropdown);
	select.selectByVisibleText("Internship");
	select.selectByIndex(2);
	WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='job_description_ifr']"));
	System.out.println(driver.switchTo().frame(frameElement));
	
	//WebElement DescBox =driver.findElement(By.cssSelector("body.mce-content-body"));
	//DescBox.click();
//	DescBox.sendKeys("Should have 5 year of experience in SAP JOB.");
	Thread.sleep(3000);
	//driver.findElement(By.id("tinymce")).sendKeys("HELLO");
	
	WebElement editable = driver.findElement(By.xpath("//html[1]/body[1]"));
    editable.clear(); 
    editable.sendKeys("This is an automated job description entered using Selenium.");
	
	driver.switchTo().defaultContent(); 
	driver.findElement(By.id("application")).sendKeys(email);
	driver.findElement(By.id("company_name")).sendKeys("SAP");
	driver.findElement(By.id("company_website")).sendKeys("www.SAP.com");
	driver.findElement(By.id("company_tagline")).sendKeys("TheSAPCompany");
	driver.findElement(By.id("company_video")).sendKeys("VIDEO Link");
	driver.findElement(By.id("company_twitter")).sendKeys("@SAP");
	driver.findElement(By.name("submit_job")).click();

	Thread.sleep(3000);
	driver.findElement(By.id("job_preview_submit_button")).click();
	
	driver.close();
	}
}