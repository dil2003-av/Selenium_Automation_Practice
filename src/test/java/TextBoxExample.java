import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextBoxExample {
    WebDriver driver;

    @BeforeTest
    public void openLinkTestPage(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("150");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");

    }

    @Test
    public void TextBoxTests() {
        //01) Enter your name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("John Doe");

        //02) Append Country to this City.
        WebElement city = driver.findElement(By.id("j_idt88:j_idt91"));
        city.sendKeys("Colombo, Sri Lanka");

        //03) Verify if text box is disabled by name
        boolean enabled = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is the text box enabled? " + enabled);

        //04) Clear the text
         WebElement clearText = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt95\"]"));
        clearText.clear();

        //05) Retrieve the typed text
        WebElement text = driver.findElement(By.id("j_idt88:j_idt97"));
        String typedText = text.getAttribute("value");
        System.out.println("Typed text: " + typedText);

        //06) Type email and Tab. Confirm control moved to next element.
        WebElement email = driver.findElement(By.id("j_idt88:j_idt99"));
        email.sendKeys("kaushalya@gmail.com" + Keys.TAB + "Next Element");

    }

}
