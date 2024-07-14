package Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLOutput;
import java.util.List;

public class StaticDropdown {
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement ele=driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));
        Select dropdown=new Select(ele);
        List<WebElement> options=dropdown.getOptions();
        System.out.println("Total Number of Options: "+options.size());

        for(WebElement e:options){
            System.out.println(e.getText());
        }

        System.out.println("======");
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        driver.quit();
    }
}
