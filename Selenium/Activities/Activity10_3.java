package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10_3 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions builder = new Actions(driver);

        driver.get("https://www.training-support.net/selenium/drag-drop");
        System.out.println("The title of the page is " + driver.getTitle());

        //Wait for ball to load
        wait.until(ExpectedConditions.elementToBeClickable(By.id("draggable")));

        //Find the different elements
        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement drop1 = driver.findElement(By.id("droppable"));
        WebElement drop2 = driver.findElement(By.id("dropzone2"));

        //Simulate a click and drag to move it into "Dropzone 1".
        builder.dragAndDrop(ball,drop1).build().perform();
        //Verify that the ball has entered Dropzone 1.
        wait.until(ExpectedConditions.attributeToBeNotEmpty(drop1,"background-color"));
        System.out.println("Ball entered dropzone 1");
        System.out.println(drop1.getText());
        //Once verified, move the ball into "Dropzone 2".
        builder.dragAndDrop(ball,drop2).build().perform();
        // Verify that the ball has entered Dropzone 2.
        wait.until(ExpectedConditions.attributeToBeNotEmpty(drop2,"background-color"));
        System.out.println("Ball entered dropzone 2");
        System.out.println(drop2.getText());
        //Once verified, close the browser.
        driver.quit();

    }
}
