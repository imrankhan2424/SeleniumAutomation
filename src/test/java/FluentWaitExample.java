import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;


public class FluentWaitExample {
    static WebDriver driver;
    @Test
    public void usecase1() {
        prerequisite("1");

        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement helloText=wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver){
                if(driver.findElement(By.cssSelector("#finish h4")).isDisplayed())
                    return driver.findElement(By.cssSelector("#finish h4"));
                else
                    return null;
            }
        });

        System.out.println(helloText.getText());

        driver.close();
    }

    @Test
    public void usecase2(){
        prerequisite("2");

        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(8))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement k=wait.until(new Function<WebDriver,WebElement>(){
            public WebElement apply(WebDriver driver){
                return driver.findElement(By.cssSelector("#finish h4"));
            }
        });

        System.out.println(k.getText());
        driver.quit();
    }

    public static void prerequisite(String usecase){
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        if(usecase.equals("1"))
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        else
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        driver.findElement(By.cssSelector("#start button")).click();

        System.out.println(driver.findElement(By.id("loading")).getText());
        driver.findElement(By.cssSelector("#loading img"));


    }
}