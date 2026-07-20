import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {

    WebDriver driver;

    @BeforeTest
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void LinkTests(){
        //01) Take me to dashboard page
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        //02) Find my destination link
        WebElement destinationLink = driver.findElement(By.partialLinkText("Find the URL"));
        String destinationUrl = destinationLink.getAttribute("href");
        System.out.println("Destination URL: " + destinationUrl);

        //03) Broken link
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();
       String title = driver.getTitle();
       if(title.contains("404")) {
           System.out.println("The link is broken.");
       } else {
           System.out.println("The link is not broken.");
       }

       driver.navigate().back();//StaleElementReferenceException maga avoid karanna me line eka add karala thiyenawa

       //04)Duplicate Link
        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back(); //StaleElementReferenceException maga avoid karanna me line eka add karala thiyenawa

       //05) Count page Links
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int linkCount = allLinks.size();
        System.out.println("Total number of links on the page: " + linkCount);

        //Count layout links
        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countLayoutLinks = layoutElement.findElements(By.tagName("a"));
        System.out.println("Total number of links in the layout section: " + countLayoutLinks.size());

    }


}
