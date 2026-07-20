import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertExample {
    WebDriver driver;

    @BeforeTest
    public void alert() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void alertTest() throws InterruptedException {
        // Alert handling code will go here
        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();
        Alert alert= driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();

        //Alert(confirm) handling code will go here
        WebElement confirmBox = driver.findElement(By.id("j_idt88:j_idt93"));
        confirmBox.click();
        Alert confirmAlert = driver.switchTo().alert();
        Thread.sleep(3000);
        confirmAlert.dismiss();

        //Alert (prompt) handling code will go here
        WebElement promptBox = driver.findElement(By.id("j_idt88:j_idt104"));
        promptBox.click();
        Alert promptAlert = driver.switchTo().alert();
        Thread.sleep(3000);
        promptAlert.sendKeys("This is a test");
        String alertText = promptAlert.getText();
        System.out.println("Alert text is: " + alertText);
        promptAlert.sendKeys("This is a test");
        promptAlert.accept();
    }
}
