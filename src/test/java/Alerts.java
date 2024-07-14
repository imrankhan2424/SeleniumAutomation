import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Alerts {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        String alertname="Imran";
        String expected_alert="Hello "+alertname+", share this practice page and share your knowledge";
        String confirm_name="Khan";
        String confirm_alert="Hello "+confirm_name+", Are you sure you want to confirm?";

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("#name")).sendKeys(alertname);

        driver.findElement(By.id("alertbtn")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(), expected_alert);
        driver.switchTo().alert().accept();

        driver.findElement(By.cssSelector("#name")).sendKeys(confirm_name);
        driver.findElement(By.id("confirmbtn")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(),confirm_alert);
        driver.switchTo().alert().dismiss();

        driver.findElement(By.cssSelector("#name")).sendKeys(confirm_name);
        driver.findElement(By.id("confirmbtn")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(),confirm_alert);
        driver.switchTo().alert().accept();

        driver.quit();
    }
}
