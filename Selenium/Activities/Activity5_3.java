package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {
    public static void main(String[] args){
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();

        //Open a browser with https://www.training-support.net/selenium/dynamic-controls
        driver.get("https://www.training-support.net/selenium/dynamic-controls");

        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("The title of the page is " + driver.getTitle());

        /*Use findElement() to find the text field.
        Use the isEnabled() method to check if the text field is enabled.*/
        WebElement textInput = driver.findElement(By.xpath("//div[@id='dynamicText']"));
        System.out.println("Text input element is enabled or not ? " + textInput.isEnabled());

        //Click the "Enable Input" button to enable the input field.
        driver.findElement(By.xpath("//button[@id='toggleInput']")).click();

        //Use the isEnabled() method again and print the result.
        System.out.println("Text input element is enabled or not ? " + textInput.isEnabled());

        //Close the browser
        driver.quit();
    }
}
