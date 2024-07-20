import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class iFramesDroppable {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();

        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

        System.out.println("Before drag and drop:");
        WebElement source=driver.findElement(By.cssSelector("#draggable p"));
        WebElement dest=driver.findElement(By.cssSelector("#droppable p"));
        System.out.println(source.getText());
        System.out.println(dest.getText());

        Actions actions=new Actions(driver);
        actions.dragAndDrop(source, dest).build().perform();

        System.out.println("\nAfter drag and drop:");
        System.out.println(driver.findElement(By.cssSelector("#draggable p")).getText());
        System.out.println(driver.findElement(By.cssSelector("#droppable p")).getText());

        driver.switchTo().defaultContent();
    }
}
