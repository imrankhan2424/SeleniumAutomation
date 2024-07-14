package Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();

        //From
        driver.findElement(By.cssSelector("div[data-testid='to-testID-origin']")).click();
//        driver.findElement(By.xpath("//div[@class='css-76zvg2 r-1srvcxg' and .='Agartala Airport']")).click();
        WebElement source=driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-knv0ih r-1k1q3bj r-ql8eny r-1dqxon3'] //div[@class='css-76zvg2 r-1srvcxg'])[1]"));
        System.out.println("Source: "+source.getText());
        source.click();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //To
//        driver.findElement(By.xpath("//div[@class='css-76zvg2 r-1srvcxg' and .='Aurangabad Airport']")).click();
        WebElement dest=driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-knv0ih r-1k1q3bj r-ql8eny r-1dqxon3'] //div[@class='css-76zvg2 r-1srvcxg'])[1]"));
        System.out.println("Dest: "+dest.getText());
        dest.click();

        driver.quit();
    }
}
