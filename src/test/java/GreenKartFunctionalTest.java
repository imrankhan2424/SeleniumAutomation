import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class GreenKartFunctionalTest {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        String[] item_names={"Carrot","Beans","Walnuts"};

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Implicit wait
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> productNames=driver.findElements(By.cssSelector("h4.product-name"));
        List<WebElement> addToCart=driver.findElements(By.cssSelector("div.product-action"));

        int count=0;

        for(int i=0;i<productNames.size();i++){
            String productName=productNames.get(i).getText().split("-")[0].trim();

            for(String item:item_names) {
                if(productName.equals(item)){
                    System.out.println("Added "+productName+" to Cart");
                    addToCart.get(i).click();
                    count++;
                }
            }
            if(count== item_names.length)
                break;
        }

        driver.findElement(By.cssSelector("a.cart-icon img")).click();
        driver.findElement(By.cssSelector("div[class='cart-preview active'] [type='button']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("promoBtn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
        Assert.assertEquals(driver.findElement(By.className("promoInfo")).getText(), "Code applied ..!");

        driver.quit();
    }
}
