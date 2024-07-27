import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class WebTableSort {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        List<String> price;
        do{
            List<WebElement> elementList=driver.findElements(By.xpath(".//tr/td[1]"));
            price=elementList.stream().filter(s->s.getText().equals("Almond")).map(s->getItemValue(s)).collect(Collectors.toList());
            price.forEach(s-> System.out.println(s));
            if(price.size()<1){
                WebElement next=driver.findElement(By.cssSelector("a[aria-label='Next']"));
                next.click();
            }
        }while (price.size()<1);
    }

    private static String getItemValue(WebElement s) {
        return s.findElement(By.xpath("./following-sibling::td[1]")).getText();
    }
}
