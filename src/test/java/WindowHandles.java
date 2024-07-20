import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandles {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.cssSelector("a.blinkingText")).click();

        Iterator<String> window=driver.getWindowHandles().iterator();
        System.out.println(driver.getWindowHandles().size());
        String parentid=window.next();
        String childId=window.next();
        System.out.println(parentid);
        System.out.println(childId);

        driver.switchTo().window(childId);

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("strong a")));

        String username=element.getText();
        System.out.println(username);

        driver.switchTo().window(parentid);
        driver.findElement(By.id("username")).sendKeys(username);

        driver.quit();
    }
}
