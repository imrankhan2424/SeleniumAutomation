import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotCapture {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.youtube.com/");
        driver.findElement(By.cssSelector("#search:nth-child(1)")).sendKeys("DCU Latest news");
        driver.findElement(By.id("search-icon-legacy")).click();
        Thread.sleep(3000);

        TakesScreenshot tk= (TakesScreenshot) driver;
        File src=tk.getScreenshotAs(OutputType.FILE);
        File output= new File("./screenshot.png");
        Files.copy(src.toPath(), output.toPath(), StandardCopyOption.REPLACE_EXISTING);

        driver.quit();
    }
}
