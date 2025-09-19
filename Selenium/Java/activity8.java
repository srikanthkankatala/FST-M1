package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
public class activity8 {
		public static void main(String[] args) {
			WebDriver driver = new FirefoxDriver();
			Actions builder = new Actions(driver);
			driver.get("https://training-support.net/webelements/mouse-events");
			System.out.println("Page Title: " + driver.getTitle());
			WebElement cargoLock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
			WebElement cargoToml = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
	        WebElement srcButton = driver.findElement(By.xpath("//h1[text()='src']"));
	        WebElement targetButton = driver.findElement(By.xpath("//h1[text()='target']"));

	        // Perform left click on Cargo.lock and then on Cargo.toml
	        builder.click(cargoLock).pause(1000).moveToElement(cargoToml).pause(1000).click(cargoToml).build().perform();
	        // Print the front side text
	        String actionMessage = driver.findElement(By.id("result")).getText();
	        System.out.println(actionMessage);

	        // Perform double click on src
	        // then right click on target
	        builder.doubleClick(srcButton).pause(3000).pause(5000)
	        .contextClick(targetButton).pause(3000).build().perform();
	        // and then open it
	        builder.click(driver.findElement(By.xpath("//div[@id='menu']/div/ul/li[1]"))).pause(5000).build().perform();
	        // Print the front side text
	        actionMessage = driver.findElement(By.id("result")).getText();
	        System.out.println(actionMessage);

	        // Close the browser
	        driver.quit();
		}}