import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Locators {

    @Test
    public void LocatorsTest() throws InterruptedException {
        String username="Imran";
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
            tagname[attribute='value']

        By index
            tagname[attribute='value']:nth-child(index)
         */

        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys("abc");
        driver.findElement(By.xpath("//*[@type='text'][2]")).sendKeys("xyz");
        driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("9876543210");
        Thread.sleep(1000);
        driver.findElement(By.className("reset-pwd-btn")).click();
        String message=driver.findElement(By.className("infoMsg")).getText();
        System.out.println(message);
        Assert.assertEquals(message,"Please use temporary password 'rahulshettyacademy' to Login.");
        driver.findElement(By.className("go-to-login-btn")).click();
        Thread.sleep(1000); // element click intercepted exception

        //Re-login
        driver.findElement(By.xpath("//*[@placeHolder='Username']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("#chkboxOne")).click();
        driver.findElement(By.xpath("//*[@class='submit signInBtn']")).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        Assert.assertTrue(driver.findElement(By.cssSelector("h2")).getText().contains(username));
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        driver.quit();
    }
}
