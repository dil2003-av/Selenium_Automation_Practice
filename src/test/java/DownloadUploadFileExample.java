import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadUploadFileExample {
    WebDriver driver;

    @BeforeTest
    public void windowTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

    @Test
    public void downloadFile() throws InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");
        WebElement downloadButton = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadButton.click();
        Thread.sleep(3000);

        File file = new File("C:\\Users\\dilmi kaushalya\\Downloads");
        File[] totalFiles = file.listFiles();

        for (File findFile : totalFiles) {
            if (findFile.getName().equals("TestLeaf Logo.png")) {
                System.out.println("File downloaded successfully: " + findFile.getAbsolutePath());
                break;
            }
        }
    }

    @Test
    public void uploadFile() throws InterruptedException, AWTException {
        driver.get("https://www.leafground.com/file.xhtml");
        WebElement uploadButton = driver.findElement(By.id("j_idt88:j_idt89"));
        uploadButton.click();

        //windows control begin here
//        String data = "C:\\Users\\dilmi kaushalya\\Downloads\\TestLeaf Logo.png"; //Create a StringSelection object with the file path
//        StringSelection selection = new StringSelection(data); //  text to be copied to the clipboard
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
//
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);//windows+ctrl+O
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        Thread.sleep(2000);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);

     //2nd way to upload file
        String data = "C:\\Users\\dilmi kaushalya\\Downloads\\TestLeaf Logo.png"; //Create a StringSelection object with the file path

        // ID එක වෙනුවට සියලුම type='file' input සොයාගන්නා පොදු XPath එක මෙන්න:
        WebElement uplaodusingSendKeys = driver.findElement(By.xpath("//input[@type='file']"));

        uplaodusingSendKeys.sendKeys(data);
        Thread.sleep(2000);
    }
}
