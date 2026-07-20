import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Radio_CheckBox_Example {
    WebDriver driver;

    @BeforeTest
    public void radio_checkbox_BeforeTests() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void radioTests() {
        //<<<<<<<<Radio button example>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        //1)Find the default selected radio button
        driver.get("https://www.leafground.com/radio.xhtml");
        boolean chromeradioOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxradioOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariradioOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeradioOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();

        if (chromeradioOption) {
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("Chrome radio button is selected by default" + chromeText);
        } else if (firefoxradioOption) {
            String firefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("Firefox radio button is selected by default" + firefoxText);
        } else if (safariradioOption) {
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("Safari radio button is selected by default" + safariText);
        } else if (edgeradioOption) {
            String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("Edge radio button is selected by default" + edgeText);
        } else {
            System.out.println("No radio button is selected by default");
        }

        //2)Select the age group (only if not selected)
        WebElement ageGroupRadio = driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked = ageGroupRadio.isSelected();
        if (!isChecked) {
            //ageGroupRadio.click();meken ynna balu
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
            System.out.println("Age group radio button is selected");
        }

    }

    @Test
        public void CheckboxTest () {
//<<<<<<<<Check box example>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            //1) Select wanted checkboxes and verifying those checkboxes selected status
            driver.get("https://www.leafground.com/checkbox.xhtml");
        List<WebElement> checkboxes = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for (WebElement element : checkboxes) {
           if (!element.getText().equals("Others")) {
                element.click();
                }
            }
        for (int i = 1; i <=checkboxes.size(); i++) {
            boolean checkBoxStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)["  +i+ "]")).isSelected();
            System.out.println("Checkbox " + i + " is selected : " + checkBoxStatus);
            
        }
        }
    }




