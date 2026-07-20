import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {
    WebDriver driver;

    @BeforeTest
    public void dropdownTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void leafGroundDropDownTest() throws InterruptedException {
        //1.1) ways of selecting a values in Basic drop down
        driver.get("https://www.leafground.com/select.xhtml");
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);

        //1.2)Get the number of dropdown options
        //generics
        List<WebElement> listofOptions = select.getOptions();
        int size = listofOptions.size();
        System.out.println("Number of dropdown options: " + size);

        for (WebElement option : listofOptions) {
            System.out.println("Dropdown option: " + option.getText());
        }

        //1.3) Selecting a value in the dropdown using sendKeys
        dropdown.sendKeys("Puppeteer");
        Thread.sleep(3000);

        //1.4) Selecting a value in a Bootstrap dropdown
        WebElement dropdown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropdown2.click();
        List<WebElement> listdropdown2values = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement option : listdropdown2values) {
            String dropDownvalue = option.getText();
            if (dropDownvalue.equals("USA")) {
                option.click();
                break;
            }
        }
    }

    //google search dropdown
    @Test
    public void googleSearchdropdown() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("palitha");
        Thread.sleep(3000);
        List<WebElement> googlesearchList = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']"));
        System.out.println(googlesearchList.size());
        for (WebElement element : googlesearchList) {
            System.out.println(element.getText());
        }
    }

    //3.Handle hidden Auto Suggestion dropdown and search using DOM Debugger Trick


}

