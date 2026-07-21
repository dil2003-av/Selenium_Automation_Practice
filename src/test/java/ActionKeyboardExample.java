import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ActionKeyboardExample {
    WebDriver driver;

    @BeforeTest
    public void windowTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void testKeyboardActions() throws InterruptedException {
        driver.get("https://www.google.com"); // Replace with the URL of the page you want to test
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("Welcome");

        Actions actions = new Actions(driver);
        //select the text in the search box
        actions.keyDown(Keys.CONTROL) .sendKeys("a").keyUp(Keys.CONTROL).build().perform();

        Thread.sleep(5000);
        actions.keyDown(Keys.SHIFT)
                .sendKeys("Written").perform();
        Thread.sleep(5000);

        actions.keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL)
                .sendKeys("x")
                .build().perform();

    }

    @Test
    public void testKeyboardActions2() throws InterruptedException {
        driver.get("https://www.leafground.com/list.xhtml"); // Replace with the URL of the page you want to test

        Thread.sleep(4000);
        List<WebElement> selectable = driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int size = selectable.size();
        System.out.println("Size of the list: " + size);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(selectable.get(0))//action class click method is used to click on the element not the click method of the WebElement
                .click(selectable.get(1))
                .click(selectable.get(2))
                .perform();

    }
}
