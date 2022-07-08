package activities;

//Activity 2

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity2 {

    public static void main(String[] args){

        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();

        //Open a browser with https://www.training-support.net
        driver.get("https://www.training-support.net");

        //Get the title of the page using driver.getTitle() and print out the title
        System.out.println("The title of the page is " + driver.getTitle());

        /*Use findElement() with the following locators to find the "About Us" link:
        id(), className(), linkText(), cssSelector()
        Print the text in the WebElement using the getText() method.*/
        WebElement idAboutUS = driver.findElement(By.id("about-link"));
        System.out.println("The text is " + idAboutUS.getText());

        WebElement classNameAboutUS = driver.findElement(By.className("green"));
        System.out.println("The text is " + classNameAboutUS.getText());

        WebElement linkTextAboutUS = driver.findElement(By.linkText("About Us"));
        System.out.println("The text is " + linkTextAboutUS.getText());

        WebElement cssSelectorAboutUS = driver.findElement(By.cssSelector(".green"));
        System.out.println("The text is " + cssSelectorAboutUS.getText());

        //Close the browser with driver.close()
        driver.close();
    }
}
