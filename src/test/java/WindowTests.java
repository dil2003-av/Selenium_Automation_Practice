import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowTests {
    WebDriver driver;

    @BeforeTest
    public void windowTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
    }

    @Test
    public void windowTests() throws InterruptedException {
        //Click on the "Open" button to open a new window
        String oldWindow = driver.getWindowHandle();
        System.out.println("Old window handle: " + oldWindow);

        WebElement openButton = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        openButton.click();
        Thread.sleep(3000);

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("handle size: " + windowHandles.size());

        //First method - using for-each loop
        for (String newWindow : windowHandles) {
            System.out.println(newWindow);
            driver.switchTo().window(newWindow);
            System.out.println("Page Title is: " + driver.getTitle());
        }
        driver.close();

        driver.switchTo().window(oldWindow);
        WebElement openButton1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        boolean openbuttonVisibility = openButton1.isDisplayed();
        System.out.println("Open button visibility: " + openbuttonVisibility);

        //Second method - using list
        /*List<String> windowHandlesList = new ArrayList<>(windowHandles);
        driver.switchTo().window(windowHandlesList.get(1));
        System.out.println("Page Title is: " + driver.getTitle());
        driver.close();
        driver.switchTo().window(windowHandlesList.get(0));
        WebElement openButton1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        boolean openbuttonVisibility = openButton1.isDisplayed();
        System.out.println("Open button visibility: " + openbuttonVisibility);*/


        //2)Fined the number of opened tabs
        WebElement multiWindow = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']/span"));
        multiWindow.click();
        Thread.sleep(3000);
        Set<String> windowHandles1 = driver.getWindowHandles();
        int howmanyWindows = windowHandles1.size();
        System.out.println("Number of opened tabs: " + howmanyWindows);

        //3)Close all windows except primary
        WebElement dontcloseButtoon = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt93']/span"));
        dontcloseButtoon.click();
        Thread.sleep(3000);
        Set<String> windowHandles2 = driver.getWindowHandles();
        for (String allwindows : windowHandles2) {
            if (!allwindows.equals(oldWindow)) {
                driver.switchTo().window(allwindows);
                driver.close();
            }
        }
    }
}


