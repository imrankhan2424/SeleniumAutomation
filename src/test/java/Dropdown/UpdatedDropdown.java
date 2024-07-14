package Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
        WebElement passagener_count=driver.findElement(By.xpath("(//*[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar'])[2]"));
        System.out.println(passagener_count.getText());

        passagener_count.click();
        for(int i=1;i<5;i++)
            driver.findElement(By.cssSelector("div[data-testid='Adult-testID-plus-one-cta']")).click();
        passagener_count.click();
        System.out.println(passagener_count.getText());
        driver.quit();
    }
}
