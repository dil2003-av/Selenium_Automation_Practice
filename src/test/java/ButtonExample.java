import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ButtonExample {
    WebDriver driver;

    @BeforeTest
    public void openLinkTestPage(){
        driver = new ChromeDriver();
//        Dimension newSize = new Dimension(800,600); size eka apita oona widihata hdgnn puluwn
//        driver.manage().window().setSize(newSize);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void buttonTest(){
        // 01).click and confirm title
        driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt90\"]")).click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("actual title same as expected");
        }else {
            System.out.println("Actual title same as not expected");
        }
       // Assert.assertEquals(actualTitle,expectedTitle, "Title miss matched");

        // 02).Find the position of the submit button
        driver.navigate().back();
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("X Position is:" + x + "Y position is:" +y);

        //03). Find the  Save button color
        WebElement buttoncolor = driver.findElement(By.id("j_idt88:j_idt96"));
        String color = buttoncolor.getCssValue("background-color");
        System.out.println("Button color is" + color);

        // Find the height and width of using button
        WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
        int height = size.getSize().getHeight();
        int width = size.getSize().getWidth();
        System.out.println("Height" + height+ "Width" + width);

    }




}
