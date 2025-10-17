package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class Activity6 extends ActionsBase {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverURL = new URI("http://localhost:4723").toURL();
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://training-support.net/webelements/sliders");
    }

    @Test
    public void volume75Test() throws InterruptedException {
        WebElement slider = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));
        moveSliderToPercentage(slider, 0.75);

        // Wait briefly for text update
        Thread.sleep(1500);

        String volumeText = driver
                .findElement(AppiumBy.xpath("//android.view.View/android.widget.TextView[contains(@text, '%')]"))
                .getText();
        System.out.println("Volume text after swipe: " + volumeText);

        int volumeValue = extractPercentage(volumeText);
        assertTrue(volumeValue >= 70 && volumeValue <= 80,
                "Expected around 75%, but found " + volumeValue + "%");
    }

    @Test
    public void volume25Test() throws InterruptedException {
        WebElement slider = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));
        moveSliderToPercentage(slider, 0.25);

        Thread.sleep(1500);

        String volumeText = driver
                .findElement(AppiumBy.xpath("//android.view.View/android.widget.TextView[contains(@text, '%')]"))
                .getText();
        System.out.println("Volume text after swipe: " + volumeText);

        int volumeValue = extractPercentage(volumeText);
        assertTrue(volumeValue >= 20 && volumeValue <= 30,
                "Expected around 25%, but found " + volumeValue + "%");
    }

    private void moveSliderToPercentage(WebElement slider, double percent) {
        Point location = slider.getLocation();
        Dimension size = slider.getSize();

        int startX = location.getX();
        int endX = startX + size.getWidth();
        int y = location.getY() + (size.getHeight() / 2);

        int moveToX = startX + (int) (size.getWidth() * percent);

        System.out.println("Swiping from X=" + startX + " to X=" + moveToX + " at Y=" + y);
        doSwipe(driver, new Point(startX, y), new Point(moveToX, y), 800);
    }

    private int extractPercentage(String text) {
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
