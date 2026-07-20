import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FrameExample {
    WebDriver driver;

    @BeforeTest
    public void windowTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");
    }

    @Test
    public void frameTests(){
        //1.Click Me (Inside Frame) - Click the button inside the frame and verify the text change

        driver.switchTo().frame(0);
        WebElement button1 = driver.findElement(By.xpath("//button[@id='Click']"));
        button1.click();

        String afterClickButtonText = button1.getText();
        System.out.println("After click button text: " + afterClickButtonText);


        //2.Click Me (Inside Nested Frame) - Click the button inside the nested frame and verify the text change
        driver.switchTo().defaultContent();
        driver.switchTo().frame(2);//inside to 3 frame
        driver.switchTo().frame("frame2");//inside into third frame>child frame

        WebElement button3 = driver.findElement(By.id("Click"));
        button3.click();

        String afterClickNestedFrameButtonText= button3.getText();
        System.out.println("After click nested frame button text: " + afterClickNestedFrameButtonText);


        //How many frames are there in the page
        driver.switchTo().defaultContent();
       List<WebElement> getIframeTagCount =  driver.findElements(By.tagName("iframe"));
       int size = getIframeTagCount.size();
        System.out.println("Total number of frames in the page: " + size);

    }
}
