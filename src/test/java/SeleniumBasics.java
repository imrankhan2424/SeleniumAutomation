import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.annotations.Test;

import java.io.IOException;

public class SeleniumBasics {
    WebDriver driver;

    @Test
    public void LaunchBrowser(){
        System.setProperty("webriver.chrome.driver","src/main/resources/Drivers/chromedriver.exe");
        driver=new ChromeDriver();

//        System.setProperty("webriver.gecko.driver","src/main/resources/Drivers/geckodriver.exe");
//        driver=new FirefoxDriver();

        driver.get("https://www.google.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver.getTitle());
        driver.quit();


        //why not?
        //ChromeDriver driver=new ChromeDriver();
        //driver.resetInputState(); <-- Not From ChromeDriver
        //Because chromedriver has its own specific methods
        //which will not be applicable for Other broswers


    }
}
