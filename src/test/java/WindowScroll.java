import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowScroll {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        jse.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
    }
}
