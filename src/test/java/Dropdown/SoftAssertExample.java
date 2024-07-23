package Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class SoftAssertExample {
    public static void main(String[] args) throws IOException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a=new SoftAssert();


        for(WebElement link:links){
            String url= link.getAttribute("href");
            HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();

            int statusCode=conn.getResponseCode();
            System.out.println(statusCode);
            a.assertTrue(statusCode<400, "The link with Text '"+link.getText()+"' is broken with code: " +statusCode);
        }
        driver.quit();
        a.assertAll();
    }
}