package com.assignment;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenGoogle {
    public static void main(String[] args) {

        // ❌ System.setProperty පේළිය ඉවත් කර ඇත.
        // Selenium විසින්ම ගැලපෙන Driver එක ඉබේම සොයාගනු ඇත.
        //WebDriverManager.chromedriver().setup();Step 02- auto ma path eka set karanawa
        WebDriver driver = new ChromeDriver();

        // වෙබ් අඩවියක් open කර බැලීමට මේ පේළිය එකතු කරන්න
        driver.get("https://www.google.com");
        driver.quit();

    }
}