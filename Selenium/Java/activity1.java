package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
try {
		driver.get("https://training-support.net/");
		System.out.println("Page title is : " + driver.getTitle());
		
		// driver.findElement(By.className("card"));
		driver.findElement(By.cssSelector("a.card"));
		
		driver.findElement(By.linkText("About Us")).click();
		System.out.println("New page title is : "+driver.getTitle());
	}catch(Exception e) {
		
		System.out.println(e.getMessage());
	}finally {
		driver.quit();
	}

}
}