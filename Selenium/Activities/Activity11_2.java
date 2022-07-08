package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity11_2 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions builder = new Actions(driver);

        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        System.out.println("The title of the page is " + driver.getTitle());

        //Use findElement() to find the button to open a CONFIRM alert and click it.
        driver.findElement(By.id("confirm")).click();
        //Switch the focus from the main window to the Alert box and get the text in it and print it.
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());

        //Close the alert with alert.accept()
        //alert.accept();
        //System.out.println("Alert accepted");

        //close the alert with alert.dismiss()
        alert.dismiss();
        System.out.println("Alert dismissed");

        //close the browser
        driver.close();

    }
}
