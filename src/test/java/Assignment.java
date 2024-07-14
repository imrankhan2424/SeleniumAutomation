import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement checkbox=driver.findElement(By.id("checkBoxOption1"));

        Assert.assertFalse(checkbox.isSelected());

        checkbox.click();
        Assert.assertTrue(checkbox.isSelected());

        Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(),3);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.open()");
        // Switch to the new tab
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        // Navigate to a new URL
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        jse.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.name("name")).sendKeys("Imran");
        driver.findElement(By.name("email")).sendKeys("Imran@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Imran@gmail.com");
        driver.findElement(By.id("exampleCheck1")).click();
        WebElement dropdown=driver.findElement(By.id("exampleFormControlSelect1"));
        Select options=new Select(dropdown);
        options.selectByVisibleText("Female");
        options.selectByVisibleText("Male");

        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("02/10/1998");

        driver.findElement(By.cssSelector(".btn.btn-success")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert:nth-child(1)")).getText().contains(" The Form has been submitted successfully!."));

        driver.quit();

    }
}
