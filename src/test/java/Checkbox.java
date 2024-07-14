import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Checkbox {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement friends_and_family_chkbox=driver.findElement(By.cssSelector("input[id*='friendsandfamily']"));
        Assert.assertFalse(friends_and_family_chkbox.isSelected());

        friends_and_family_chkbox.click();
        Assert.assertTrue(friends_and_family_chkbox.isSelected());

        Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(),6);

        driver.quit();
    }
}
