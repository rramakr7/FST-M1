package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity4_2 {

    public static void main(String[] args){
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();

        //Open a browser with https://www.training-support.net/selenium/simple-form
        driver.get("https://www.training-support.net/selenium/simple-form");

        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("The title of the page is " + driver.getTitle());

        /*Use findElement() with xpath() to find all the input fields on the page.
        Fill in the details in the fields using the sendKeys() method.*/
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Test3");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("User3");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test2@gmail.com");
        driver.findElement(By.xpath("//input[@id='number']")).sendKeys("1234567890");

        //Click the submit button at the end of the form to submit the form
        driver.findElement(By.xpath("//div[@class='field']/input[@class='ui green button']")).submit();

        //Close the browser
        driver.quit();




    }
}
