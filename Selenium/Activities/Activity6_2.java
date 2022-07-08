package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_2 {
    public static void main(String[] args){
        //Create a WebDriver instance, named driver, with the FirefoxDriver()
        //Create a WebDriverWait instance, named wait, with duration of 10 seconds
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open a browser with https://www.training-support.net/selenium/ajax
        driver.get("https://www.training-support.net/selenium/ajax");

        //Get the title of the page using driver.getTitle() and print out the title
        System.out.println("The title of the page is " + driver.getTitle());

        //Find and click the "Change content" button on the page
        WebElement changeContentButton = driver.findElement(By.xpath("//button[contains(text(),'Change Content')]"));
        changeContentButton.click();

        //Wait for the text to say "HELLO!"
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"),"HELLO!"));

        //Print the message that appears on the page
        String ajaxText = driver.findElement(By.id("ajax-content")).getText();
        System.out.println("Message that appears on the page is " + ajaxText);

        //Wait for the text to change to contain "I'm late!"
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"),"I'm late!"));

        //Print the new message on the page
        String lateText =  driver.findElement(By.id("ajax-content")).getText();
        System.out.println("Message that appears on the page is " + lateText);

        //Close the browser
        driver.quit();
    }
}
