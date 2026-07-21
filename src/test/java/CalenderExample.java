import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class CalenderExample {
    WebDriver driver;

    @BeforeTest
    public void windowTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");
        Thread.sleep(3000); // Wait for 2 seconds to ensure the page is loaded

    }

    @Test
    //calendar
    public void calendar() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        //Method 1
//        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
//        datePicker.sendKeys("06/15/2024");

        //Method 2
        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.click();
        //selectPassedDate("2021", "May", "10");
        while (true) {
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            if (actualYear.equals("2026") && actualMonth.equals("October")) {
                break;
            } else {
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement date : allDates) {
            if (date.getText().equals("15")) {
                date.click();
                break;

            }
        }
    }
//    public void selectPassedDate(String targetYear, String targetMonth, String targetDate) {
//
//        while (true) {
//            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
//            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
//
//            // Target Year එක සහ Month එක හමු වූ විට Loop එක නතර කිරීම
//            if (actualYear.equals(targetYear) && actualMonth.equals(targetMonth)) {
//                break;
//            } else {
//                // අතීතයට යාමට 'Prev' button එක Click කිරීම
//                driver.findElement(By.xpath("//a[@title='Prev']")).click();
//            }
//        }
//
//        // අදාළ Date එක තෝරාගැනීම
//        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
//        for (WebElement date : allDates) {
//            if (date.getText().equals(targetDate)) {
//                date.click();
//                break;
//            }
//        }
//    }

}

