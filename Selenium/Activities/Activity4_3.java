package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {
    public static void main(String[] args){
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();

        //Open a browser with https://www.training-support.net/selenium/target-practice
        driver.get("https://www.training-support.net/selenium/target-practice");

        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("The title of the page is " + driver.getTitle());

        /*Use findElement() with xpath() to
           Find the third header on the page.
           Find the fifth header on the page and get it's 'colour' CSS Property.
           Find the violet button on the page and print all the class attribute values.
           Find the grey button on the page with Absolute XPath.*/
        String thirdHeader = driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
        System.out.println("Third header text is " + thirdHeader);

        WebElement fifthHeader = driver.findElement(By.xpath("//h5"));
        System.out.println("Fifth Header's color is " + fifthHeader.getCssValue("color"));

        String violetButtonClasses = driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
        System.out.println("Violet button's classes are " + violetButtonClasses);

        String greyButtonText = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText();
        System.out.println("Grey button's text is " + greyButtonText);

        //Close the browser
        driver.quit();



    }
}
