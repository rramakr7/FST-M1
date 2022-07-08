package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_1 {
    public static void main(String[] args){
        //Create a WebDriver instance, named driver, with the FirefoxDriver()
        //Create a WebDriverWait instance, named wait, with duration of 10 seconds
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open a browser with https://www.training-support.net/selenium/dynamic-controls
        driver.get("https://www.training-support.net/selenium/dynamic-controls");

        //Get the title of the page using driver.getTitle() and print out the title
        System.out.println("The title of the page is " + driver.getTitle());

        //Find the checkbox and checkbox toggle button elements
        WebElement checkBox = driver.findElement(By.xpath("//input[@class='willDisappear']"));
        WebElement checkBoxToggleButton = driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));

        //Find the checkbox toggle button and click it
        checkBoxToggleButton.click();

        //Wait till the checkbox disappears
        wait.until(ExpectedConditions.invisibilityOf(checkBox));
        System.out.println("Checkbox is invisible");

        //Click the button again. Wait till it appears and check the checkbox.
        checkBoxToggleButton.click();
        wait.until(ExpectedConditions.visibilityOf(checkBox));
        System.out.println("Checkbox is visible");

        //Finally, close the browser
        driver.quit();


    }
}
