package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String args[]) throws InterruptedException {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();

        //Open a browser with https://training-support.net/selenium/simple-form
        driver.get("https://training-support.net/selenium/simple-form");

        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("The title of the page is " + driver.getTitle());

        /*Use findElement() with name() to find the text fields - firstname and lastname.
        Use WebElement.sendKeys() to type in those text fields.*/

        driver.findElement(By.id("firstName")).sendKeys("Test1");
        driver.findElement(By.id("lastName")).sendKeys("User1");

        //Similarly, find and type into the email and contact number fields.

        driver.findElement(By.id("email")).sendKeys("test1@gmail.com");
        driver.findElement(By.id("number")).sendKeys("9876543210");

        Thread.sleep(10);
        //Finally, submit the form by clicking the Submit button.
        driver.findElement(By.cssSelector(".ui.green.button")).submit();

        //Close the browser with driver.close()
        driver.close();


    }
}
