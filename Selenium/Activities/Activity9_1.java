package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_1 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/selects");
        System.out.println("The title of the page is " + driver.getTitle());

        //Use findElement() to find the dropdown WebElement on the page.
        WebElement chosen = driver.findElement(By.id("single-value"));
        WebElement dropDown = driver.findElement(By.id("single-select"));
        //Create a new Select class object with the WebElement.
        Select sel = new Select(dropDown);

        /*On the dropdown,
        Select the second option using selectByVisibleText()
        Select the third option using selectByIndex()
        Select the fourth option using selectByValue()*/
        sel.selectByVisibleText("Option 2");
        System.out.println(chosen.getText());
        sel.selectByIndex(3);
        System.out.println(chosen.getText());
        sel.selectByValue("4");
        System.out.println(chosen.getText());

        //Finally, get all the options in the dropdown and print them one by one.
        List<WebElement> dropDownOptions =  sel.getOptions();
        for(WebElement option : dropDownOptions){
            System.out.println(option.getText());
        }

        //Close the browser
        driver.quit();
    }
}
