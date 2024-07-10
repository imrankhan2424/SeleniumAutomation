import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("inputUsername")).sendKeys("Imran");
        driver.findElement(By.name("inputPassword")).sendKeys("Khan");
        driver.findElement(By.className("submit")).click(); // classname is class attribute value in tag

        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        /*
        Css selector 3 ways
        if
            id is present -> tagname#id OR #id
            classname is present -> tagname.class OR .class
        else
            //tagname[attribute='value']
         */

        driver.quit();
    }
}
