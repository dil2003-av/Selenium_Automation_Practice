import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImageExample {
    WebDriver driver;

    @BeforeTest
    public void OpenImagePage() throws InterruptedException {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        File file = new File("C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

    //identify broken image
    @Test
    public void brokenImageTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='example']//img"));

        //"natural" way to check if image is broken or not is to check the src attribute of the image. If the src attribute is empty or null, then the image is broken. If the src attribute is not empty or null, then the image is valid.
        int i = 0;
        for (WebElement image : images) {
            if (image.getAttribute("naturalWidth").equals("0")) {
                System.out.println("Image" + i + " is broken");
            } else {
                System.out.println("Image" + i + " is valid");
            }
            i++;
        }
    }
}


