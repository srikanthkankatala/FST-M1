package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
	
    WebDriver driver;
    WebDriverWait wait;
    
    @BeforeClass
    public void beforeClass() {
    	driver = new FirefoxDriver();
    	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
    	driver.get("https://training-support.net/webelements/login-form");
    }
    
    @Test
    @Parameters({"username", "password"}) 
    public void test(String username, String password) {
    	
    	driver.findElement(By.id("username")).sendKeys(username);
    	driver.findElement(By.id("password")).sendKeys(password);
    	
    	driver.findElement(By.xpath("//button[text()='Submit']")).click();
    	
    	wait.until(ExpectedConditions.titleContains("Success"));    	
    	
    	Assert.assertEquals("Welcome Back, Admin!", driver.findElement(By.cssSelector("h2.text-center")).getText());
    }
     
    
    
    @AfterClass
    public void close() {
    	driver.quit();
    }
    
	


}
