import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class FunctionalTest {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        String[] item_names={"Carrot","Beans","Walnuts"};

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
        driver.quit();
    }
}
