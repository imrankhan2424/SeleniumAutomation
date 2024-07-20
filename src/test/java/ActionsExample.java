import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExample {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/");

        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("imran")
                .keyUp(Keys.SHIFT).sendKeys("khan").doubleClick().build().perform();
        action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();

        driver.quit();
    }
}
