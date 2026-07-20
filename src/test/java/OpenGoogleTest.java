import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; // මේක අනිවාර්යයෙන් import කරගන්න ඕනේ
import org.testng.annotations.Test;

public class OpenGoogleTest {

    @Test
    public void googleTest() {
        // 1. ChromeOptions object එකක් හදාගන්න
        ChromeOptions chromeOptions = new ChromeOptions();

        // 2. අවශ්‍ය options ටික set කරන්න
        chromeOptions.setBrowserVersion("150"); // ඔබේ පරිගණකයේ ඇති Chrome version එකට අනුව මෙය වෙනස් කරන්න හෝ අවශ්‍ය නැත්නම් comment out කරන්න
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--headless"); // background එකේ run කරන්න ඕනේ නම් පමණක් මේක uncomment කරන්න

        // 3. ChromeDriver එකට options pass කරන්න
        WebDriver driver = new ChromeDriver(chromeOptions);

        // 4. Test එක run කරන්න
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Colombo" + Keys.ENTER);

        // driver.quit();
    }
}