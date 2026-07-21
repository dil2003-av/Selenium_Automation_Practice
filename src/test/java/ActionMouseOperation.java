import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionMouseOperation {
    WebDriver driver;

    @BeforeTest
    public void windowTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void mouseOperation() throws InterruptedException {
        driver.get("https://www.leafground.com/drag.xhtml");
        System.out.println("1.move to an element");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();
//        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt38"))).perform();
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();

        System.out.println("2.Drag and drop an element");
        WebElement from = driver.findElement(By.id("form:drag"));
        WebElement to = driver.findElement(By.id("form:drop"));
       // actions.clickAndHold(from).moveToElement(to).release().perform(); //1 st way
        actions.dragAndDrop(from, to).perform(); //2 nd way

        System.out.println("3.slider");
        WebElement slider1 = driver.findElement(By.xpath("//div[@id='form:j_idt125']/span[1]"));
        System.out.println("slider1 location before moving: " + slider1.getLocation());
        actions.dragAndDropBy(slider1, 100, 0).perform();
        System.out.println("slider1 location after moving: " + slider1.getLocation());
    }

    @Test
    public void mouseOperation2() throws InterruptedException {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        System.out.println("4.right click");
        WebElement rightClickButtonElement = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickButtonElement).perform();
       driver.findElement(By.xpath("//span[text()='Edit']")).click();
        Alert alertPopup = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println("Alert text: " + alertPopup.getText());
        alertPopup.accept();

    }
}
