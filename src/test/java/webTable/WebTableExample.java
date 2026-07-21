package webTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableExample {
    WebDriver driver;

    @BeforeTest
    public void windowTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }
    @Test
    public void webTable() throws InterruptedException {
        //1.how many rows  are there in the table
       int rowCount = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("Cell Value: " + rowCount);

        //2.how many  columns are there in the table
        int columnCount = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("Cell Value: " + columnCount);

        //3.Retrieve the specific cell value from the table
        String value = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[3]/td[3]")).getText();
        System.out.println("Cell Value: " + value);

        //4.Retrieve all the cell values from the table
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 1; j <columnCount; j++) {
                String cellValue = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                System.out.print(cellValue + " ");
            }
            System.out.println();
        }

        //5.print ID and Name only
                // 5.1

        for (int i = 1; i <= rowCount; i++) {
            String tblIdValue = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[1]")).getText();
            String tblProductName = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[2]")).getText();
            System.out.println("ID: " + tblIdValue + ", Name: " + tblProductName);

            if (tblProductName.equals("Product 3")) { // Check if the product name is "Product 4"
                String tblPrice = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[3]")).getText();
                System.out.println(tblProductName +"Price of Product 3: " + tblPrice);
                break; // Exit the loop after finding the product
            }
        }

        //select all the checkboxes from the table
        int pageCount = driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
        List<WebElement> allCheckboxes = driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        for (int k=0; k<pageCount; k++) {
            allCheckboxes.get(k).click();
            Thread.sleep(1000); // Wait for the page to load after clicking the pagination link

            for (int i = 1; i <= rowCount; i++) {
                boolean attribute = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[4]/input")).isSelected();
                if (!attribute) {
                    driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[4]/input")).click();
                  Thread.sleep(300);
                }
            }
        }

       //Select One checkbox from the table
        int tblRow = 1;
        driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + tblRow + "]/td[4]/input")).click();
    }

}
