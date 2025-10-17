package activities;

import static org.testng.Assert.assertEquals;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity10 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/simple-form");
    }

    public static List<List<String>> readExcel(String filePath) {
        List<List<String>> data = new ArrayList<List<String>>();
        try {
            FileInputStream file = new FileInputStream(filePath);
      XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (Row cells : sheet) {
                List<String> rowData = new ArrayList<String>();
                for (Cell cell : cells) {
                    rowData.add(cell.getStringCellValue());
                }
                data.add(rowData);
            }
            file.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @DataProvider(name = "Events")
    public static Object[][] signUpInfo() {
        String filePath = "src/test/resources/sample.xlsx";
        List<List<String>> data = readExcel(filePath);
        return new Object[][] { 
            { data.get(1) },
            { data.get(2) },
            { data.get(3) }
        };
    }

    @Test(dataProvider = "Events")
    public void registerTest(List<String> rows) throws InterruptedException {
        WebElement fullName = driver.findElement(By.id("full-name"));
        fullName.sendKeys(rows.get(0));
        driver.findElement(By.id("email")).sendKeys(rows.get(1));
        driver.findElement(By.name("event-date")).sendKeys(rows.get(2).replaceAll("\"", ""));
        driver.findElement(By.id("additional-details")).sendKeys(rows.get(3));
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        String message = driver.findElement(By.id("action-confirmation")).getText();
        assertEquals(message, "Your event has been scheduled!");
        driver.navigate().refresh();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}