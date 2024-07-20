import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LinksNavigationVerification {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement footer=driver.findElement(By.id("gf-BIG"));
        WebElement footer_row=footer.findElement(By.xpath("//table/tbody/tr/td/ul"));
        List<WebElement> webelements=footer_row.findElements(By.tagName("a"));

        System.out.println(webelements.size());

        for(int i=1;i<webelements.size();i++){
            String openinnewtab= Keys.chord(Keys.CONTROL,Keys.ENTER);
            webelements.get(i).sendKeys(openinnewtab);
        }

        Set<String> windowhandles=driver.getWindowHandles();
        Iterator itr=windowhandles.iterator();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        while(itr.hasNext()){
            driver.switchTo().window(itr.next().toString());
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete';"));
            System.out.println(driver.getTitle());
        }
    }
}
