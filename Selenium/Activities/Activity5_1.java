package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {
    public static void main(String[] args){
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();

        //Open a browser with https://www.training-support.net/selenium/dynamic-controls
        driver.get("https://www.training-support.net/selenium/dynamic-controls");

        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("The title of the page is " + driver.getTitle());

        /*Use findElement() to find the checkbox input element
        Use the isDisplayed() method to check if it is visible on the page*/
        WebElement checkBoxInput = driver.findElement(By.xpath("//input[@class='willDisappear']"));
        System.out.println("Checkbox input element is displayed or not ? " + checkBoxInput.isDisplayed());

        //Click the "Remove Checkbox"
        driver.findElement(By.xpath("//button[@id='toggleCheckbox']")).click();

        //Print the result of the isDisplayed() method again
        System.out.println("Checkbox input element is displayed or not ? " + checkBoxInput.isDisplayed());

        //Close the browser
        driver.quit();

    }
}
