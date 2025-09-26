package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.*;
import org.testng.annotations.*;
public class Activity2 {

	WebDriver driver;
	@BeforeClass
	public void beforeMethod() {
		
		driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/target-practice");
	}
	
	@Test
	public void testCase1() {
		String title = driver.getTitle();
		System.out.println("Title is: "+title);
	}
	
	@Test
	public void testCase2(){
		WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
		Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "black");
	}
	
	@Test(enabled=false)
	public void testCase3(){
		String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
	}
	
	@Test
	public void testCase4() {
        // This test will be skipped and will be be shown as skipped
        throw new SkipException("Skipping test case");
    }
 
    @AfterTest
    public void afterMethod() {
        // Close the browser
        driver.close();
    }
}
